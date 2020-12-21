package co.com.pt.api;

import co.com.pt.entity.Message;
import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.AnswerStateEnum;
import co.com.pt.enums.MessageNotifyEnum;
import co.com.pt.enums.QuestionStateEnum;
import co.com.pt.enums.ResultEnum;
import co.com.pt.exception.MyException;
import co.com.pt.service.MessageService;
import co.com.pt.service.ProjectService;
import co.com.pt.service.UserService;
import co.com.pt.shared.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    /** ======================================= GET METHODS============================================
     *  =============================================================================================== * */
    /**
     * Get questions to User
     *
     * @param userId
     * @param page
     * @param size
     * @param authentication
     * @return Page<Message>
     */
    @GetMapping("/message/questionsTo/user/{id}")
    public Page<Message> getQuestionsToUser(@PathVariable("id") Long userId,
                                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "size", defaultValue = "5") Integer size,
                                            Authentication authentication) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Message> messagePage = null;

        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                User user = userService.findByUserId(userId);

                // 1 con el userId obtener que tipo de preguntas quiere obtener: Mis Preguntas o Las preguntas a responder
                // 2 Si el userId intenta obtener sus preguntas realizadas entonces obtenerlas todas sin importar el estado
                // 3 Si el userId intenta obtener las preguntas que le han hecho entonces obtener las que tengan el estado APPROVED

                messagePage = messageService.findByClient(user, request);
            }
        }
        return messagePage;
    }

    /**
     * Get answers to User
     *
     * @param userId
     * @param page
     * @param size
     * @param authentication
     * @return Page<Message>
     */
    @GetMapping("/message/answersTo/user/{id}")
    public Page<Message> getAnswersToUser(@PathVariable("id") Long userId,
                                          @RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @RequestParam(value = "size", defaultValue = "5") Integer size,
                                          Authentication authentication) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Message> messagePage = null;

        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                User user = userService.findByUserId(userId);
                messagePage = messageService.findByProvider(user, request);
            }
        }
        return messagePage;
    }

    /**
     * Get messages by Project
     *
     * @param projectId
     * @param page
     * @param size
     * @param authentication
     * @return Page<Message>
     */
    // @JsonView(Views.Messages.class)
    @GetMapping("/message/project/{id}")
    public Page<Message> getMessagesByProject(@PathVariable("id") Long projectId,
                                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "size", defaultValue = "5") Integer size,
                                              Authentication authentication) {

        PageRequest request = PageRequest.of(page - 1, size);
        Project project = projectService.findOne(projectId);
        if (project != null) return messageService.findByProject(project, request);
        throw new MyException(ResultEnum.PROJECT_NOT_EXIST);
    }

    /**
     * Get messages by project Id and Provider Id
     *
     * @param projectId
     * @param providerId
     * @param page
     * @param size
     * @param authentication
     * @return Page<Message>
     */
    @GetMapping("/message/project/{projectId}/provider/{providerId}")
    public Page<Message> getMessageByProjectAndProvider(@PathVariable("projectId") Long projectId,
                                                        @PathVariable("providerId") Long providerId,
                                                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "5") Integer size,
                                                        Authentication authentication) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Message> messagePage = null;

        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                Project project = projectService.findOne(projectId);
                User provider = userService.findByUserId(providerId);
                if (project != null && provider != null)
                    messagePage = messageService.findByProjectAndProvider(project, provider, request);
            }
        }
        return messagePage;
    }

    /**
     *  Get Messages List
     * @param page
     * @param size
     * @param authentication
     * @return
     */
    @GetMapping("/message")
    public Page<Message> getMessageList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "size", defaultValue = "5") Integer size,
                                        Authentication authentication) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Message> messagePage = null;

        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                messagePage = messageService.findAll(request);
            }
        }
        return messagePage;
    }

    /** ====================================== POST METHODS============================================
     *  =============================================================================================== * */

    /**
     * New question to project
     *
     * @param projectId
     * @param question
     * @param bindingResult
     * @param authentication
     * @return ResponseEntity
     */
    @JsonView(Views.Messages.class)
    @PostMapping("/message/question/project/{projectId}")
    public ResponseEntity newQuestionToProject(@PathVariable("projectId") Long projectId,
                                               @Valid @RequestBody Message question,
                                               BindingResult bindingResult,
                                               Authentication authentication) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }

        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                Project project = projectService.findOne(projectId);
                User user = userService.findOne(authentication.getName());

                if (project == null) return ResponseEntity.badRequest().body(ResultEnum.PROJECT_NOT_EXIST);

                if (project.getUser().getId() != user.getId()) {
                    Message message = new Message();
                    message.setClient(project.getUser());
                    message.setProvider(user);
                    message.setProject(project);
                    message.setQuestion(question.getQuestion());
                    message.setAnswerState(AnswerStateEnum.UN_ANSWERED);
                    message.setQuestionState(QuestionStateEnum.REVIEW);
                    message.setNotify(MessageNotifyEnum.NEW);
                    return ResponseEntity.ok(messageService.save(message));
                    // return ResponseEntity.ok().body("Pregunta registrada con exito. Por favor esperar la respuesta");
                } else {
                    return ResponseEntity.badRequest().body("¡Usted no puede realizar una pregunta a este Proyecto!");
                }
            }
        }
        return ResponseEntity.badRequest().body("¡No fue posible registrar su pregunta, intente más tarde!");
    }

    /**
     * Answer to Message
     *
     * @param messageId
     * @param answer
     * @param bindingResult
     * @param authentication
     * @return ResponseEntity
     */
    @JsonView(Views.Messages.class)
    @PostMapping("/message/{id}/answer")
    public ResponseEntity newAnswerToMessage(@PathVariable("id") Long messageId,
                                             @Valid @RequestBody Message answer,
                                             BindingResult bindingResult,
                                             Authentication authentication) {

        if (bindingResult.hasErrors()) return ResponseEntity.badRequest().body(bindingResult);

        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                Message message = messageService.findOne(messageId);

                if (message == null) return ResponseEntity.badRequest().body(ResultEnum.QUESTION_NOT_EXIST);

                message.setAnswer(answer.getAnswer());
                message.setAnswerState(AnswerStateEnum.REVIEW);
                message.setNotify(MessageNotifyEnum.SOLVED);
                java.util.Date date = new java.util.Date();
                message.setAnswerDate(date);
                return ResponseEntity.ok(messageService.save(message));
            }
        }
        return ResponseEntity.badRequest().body("¡No fue posible registrar su respuesta, intente más tarde!");
    }

    /** ====================================== POST METHODS ===========================================
     *  =============================================================================================== * */

    /**
     * Approve Question
     * @param questionId
     * @param authentication
     * @return
     */
    @PatchMapping("/message/question/approve/{id}")
    public ResponseEntity<Message> approveQuestion(@PathVariable("id") Long questionId, Authentication authentication) {
        if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(messageService.approveQuestion(questionId));
    }

    /**
     * Not Approve Question
     * @param questionId
     * @param authentication
     * @return
     */
    @PatchMapping("/message/question/notApprove/{id}")
    public ResponseEntity<Message> notApproveQuestion(@PathVariable("id") Long questionId, Authentication authentication) {
        if (authentication != null) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return ResponseEntity.ok(messageService.notApproveQuestion(questionId));
    }

    /**
     * Approve Answer
     * @param questionId
     * @param authentication
     * @return
     */
    @PatchMapping("/message/answer/approve/{id}")
    public ResponseEntity<Message> approveAnswer(@PathVariable("id") Long questionId, Authentication authentication) {
        if (authentication != null) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return ResponseEntity.ok(messageService.approveAnswer(questionId));
    }

    /**
     * Not approve Answer
     * @param questionId
     * @param authentication
     * @return
     */
    @PatchMapping("/message/answer/notApprove/{id}")
    public ResponseEntity<Message> notApproveAnswer(@PathVariable("id") Long questionId, Authentication authentication) {
        if (authentication != null) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return ResponseEntity.ok(messageService.notApproveAnswer(questionId));
    }

}
