package co.com.pt.repository;

import co.com.pt.entity.Message;
import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.AnswerStateEnum;
import co.com.pt.enums.MessageNotifyEnum;
import co.com.pt.enums.QuestionStateEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    Message findByMessageId(Long id);

    Page<Message> findAllByOrderByUpdateDateDesc(Pageable pageable);

    // Questions
    Page<Message> findByClientAndQuestionStateOrderByUpdateDateDesc(User client, QuestionStateEnum questionState, Pageable pageable);
    // Page<Message> findByClientOrderByUpdateDateDesc(User client, Pageable pageable);

    // all answer
    Page<Message> findByProviderOrderByUpdateDateDesc(User client, Pageable pageable);
    // Page<Message> findByProviderAndAnswerStateNotOrderByUpdateDateDesc(User client, AnswerStateEnum answerState, Pageable pageable);

    // Answers SOLVED
    Page<Message> findByProviderAndNotify(User client, MessageNotifyEnum notify, Pageable pageable);

    Page<Message> findByProjectOrderByUpdateDateDesc(Project project, Pageable pageable);

    Page<Message> findByProjectAndProvider(Project project, User provider, Pageable pageable);

    Message save(Message message);

}
