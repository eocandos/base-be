package co.com.pt.api;

import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.ProjectStateForManagerEnum;
import co.com.pt.enums.ProjectStateForUserEnum;
import co.com.pt.service.ProjectService;
import co.com.pt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    @GetMapping("/project")
    public Page<Project> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "3") Integer size,
                                 Authentication authentication) {
        PageRequest request = PageRequest.of(page - 1, size);

        Page<Project> projectsPage = null;
        if (authentication != null) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                projectsPage = projectService.findAll(request);
            }
        }
        return projectsPage;
    }

    /**
     *  Get Project for Guest
     * @param page
     * @param size
     * @param authentication
     * @return
     */
    @GetMapping("/project/guest")
    public Page<Project> findAllGuest(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                      @RequestParam(value = "size", defaultValue = "3") Integer size,
                                      Authentication authentication) {

        PageRequest request = PageRequest.of(page - 1, size);
        Page<Project> projectsPage = null;
        if(authentication == null) {
            projectsPage = projectService.findAll(request);
        }
        return projectsPage;
    }

    @GetMapping("/project/own")
    public Page<Project> findOwnProjects(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "size", defaultValue = "3") Integer size,
                                         Authentication authentication) {

        PageRequest request = PageRequest.of(page - 1, size);
        Page<Project> projectPage = null;
        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                User user = userService.findOne(authentication.getName());
                projectPage = projectService.findByUser(user, request);
            }
        }
        return  projectPage;
    }

    @GetMapping("/project/nonOwn")
    public Page<Project> findNonOwnProjects(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "size", defaultValue = "3") Integer size,
                                         Authentication authentication) {

        PageRequest request = PageRequest.of(page - 1, size);
        Page<Project> projectPage = null;
        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                User user = userService.findOne(authentication.getName());
                projectPage = projectService.findByUserNot(user, request);
            }
        }
        return  projectPage;
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity showOne(@PathVariable("projectId") Long projectId) {
        return ResponseEntity.ok(projectService.findOne(projectId));
    }

    /** ====================================== POST METHODS============================================
     *  =============================================================================================== * */

    /**
     * Create new Project
     * @param project
     * @param bindingResult
     * @param authentication
     * @return
     */
    @PostMapping("/client/project/new")
    public ResponseEntity create(@Valid @RequestBody Project project,
                                 BindingResult bindingResult,
                                 Authentication authentication) {
        Project projectIdExists = projectService.findOne(project.getProjectId());
        if (projectIdExists != null) {
            bindingResult
                    .rejectValue("projectId", "error.project",
                            "There is already a project with the code provided");
        }

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }

        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                User user = userService.findOne(authentication.getName());
                project.setProjectStateForUser(ProjectStateForUserEnum.ACTIVE);
                project.setProjectStateForManager(ProjectStateForManagerEnum.REVIEW);
                project.setUser(user);
            }
        }
        return ResponseEntity.ok(projectService.save(project));
    }

    /** ======================================= PUT METHODS============================================
     *  =============================================================================================== * */

    @PutMapping("/client/project/{id}/edit")
    public ResponseEntity edit(@PathVariable("id") Long projectId,
                               @Valid @RequestBody Project project,
                               BindingResult bindingResult,
                               Authentication authentication) {

        project.setProjectId(projectId);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }
        if (!projectId.equals(project.getProjectId())) {
            return ResponseEntity.badRequest().body("Id Not Matched");
        }

        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                User user = userService.findOne(authentication.getName());
                project.setProjectStateForManager(ProjectStateForManagerEnum.REVIEW);
                project.setUser(user);
            }
        }
        return ResponseEntity.ok(projectService.update(project));
    }

    @PutMapping("/project/{id}/state/{state}")
    public ResponseEntity editState(@PathVariable("id") Long projectId,
                               @PathVariable("state") Integer state,
                               // BindingResult bindingResult,
                               Authentication authentication) {

        if (authentication != null) {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
                return ResponseEntity.ok(projectService.updateState(projectId, ProjectStateForUserEnum.getValue(state)));
            }
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
                return ResponseEntity.ok(projectService.updateState(projectId, ProjectStateForManagerEnum.getValue(state)));
            }
        }
        return ResponseEntity.badRequest().body("Not authorized!");
    }

    /** ====================================== DELETE METHODS==========================================
     *  =============================================================================================== * */

    @DeleteMapping("/client/project/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") Long projectId) {
        projectService.delete(projectId);
        return ResponseEntity.ok().build();
    }

}
