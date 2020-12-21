package co.com.pt.service;


import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.ProjectStateForManagerEnum;
import co.com.pt.enums.ProjectStateForUserEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProjectService {

    Project findOne(Long projectId);
    // All projects
    Page<Project> findAll(Pageable pageable);
    // All projects by user
    Page<Project> findByUser(User user, Pageable pageable);

    // All projects by user not
    Page<Project> findByUserNot(User user, Pageable pageable);

    // All projects by active projectStateForUser
    Page<Project> findByActiveProjectStateForUser(ProjectStateForUserEnum stateForUser,
                                                  ProjectStateForManagerEnum stateForManager,
                                                  Pageable pageable);
    // All projects in a category
    // Page<Project> findAllInCategory(Integer categoryType, Pageable pageable);

    Project update(Project project);

    Project updateState(Long projectId, ProjectStateForUserEnum projectState);

    Project updateState(Long projectId, ProjectStateForManagerEnum projectState);

    Project save(Project project);

    void delete(Long projectId);


}
