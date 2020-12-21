package co.com.pt.repository;

import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.ProjectStateForManagerEnum;
import co.com.pt.enums.ProjectStateForUserEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {

    Project findByProjectId(Long id);

    Page<Project> findAllByUserOrderByUpdateTimeDescProjectNameDesc(User user, Pageable pageable);

    Page<Project> findAllByUserNotOrderByUpdateTimeDescProjectNameDesc(User user, Pageable pageable);

    // project in one category
    // Page<Project> findAllByCategoryTypeOrderByProjectIdAsc(Integer categoryType, Pageable pageable);

    Page<Project> findAllByOrderByUpdateTimeDescProjectNameDesc(Pageable pageable);

    Page<Project> findAllByProjectStateForUserAndProjectStateForManagerOrderByUpdateTimeDescProjectNameDesc(ProjectStateForUserEnum stateForUser,
                                                                    ProjectStateForManagerEnum stateForManager,
                                                                    Pageable pageable);
}
