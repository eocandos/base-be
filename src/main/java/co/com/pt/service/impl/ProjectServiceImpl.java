package co.com.pt.service.impl;


import co.com.pt.entity.Project;
import co.com.pt.entity.User;
import co.com.pt.enums.ProjectStateForManagerEnum;
import co.com.pt.enums.ProjectStateForUserEnum;
import co.com.pt.enums.ResultEnum;
import co.com.pt.exception.MyException;
import co.com.pt.repository.ProjectRepository;
import co.com.pt.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project findOne(Long projectId) {
        return projectRepository.findByProjectId(projectId);
    }

    @Override
    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAllByOrderByUpdateTimeDescProjectNameDesc(pageable);
    }

    @Override
    public Page<Project> findByUser(User user, Pageable pageable) {
        return projectRepository.findAllByUserOrderByUpdateTimeDescProjectNameDesc(user, pageable);
    }

    @Override
    public  Page<Project> findByUserNot(User user, Pageable pageable) {
        return  projectRepository.findAllByUserNotOrderByUpdateTimeDescProjectNameDesc(user, pageable);
    }

    @Override
    public Page<Project> findByActiveProjectStateForUser(ProjectStateForUserEnum stateForUser,
                                                         ProjectStateForManagerEnum stateForManager,
                                                         Pageable pageable) {
        return projectRepository.findAllByProjectStateForUserAndProjectStateForManagerOrderByUpdateTimeDescProjectNameDesc(stateForUser, stateForManager, pageable);
    }
    /*
    @Override
    public Page<Project> findAllInCategory(Integer categoryType, Pageable pageable) {
        return projectRepository.findAllByCategoryTypeOrderByProjectIdAsc(categoryType, pageable);
    }*/

    @Override
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project updateState(Long projectId, ProjectStateForUserEnum projectState) {

        Project project = findOne(projectId);
        if (project == null) throw new MyException(ResultEnum.PROJECT_NOT_EXIST);

        project.setProjectStateForUser(projectState);
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project updateState(Long projectId, ProjectStateForManagerEnum projectState) {

        Project project = findOne(projectId);
        if (project == null) throw new MyException(ResultEnum.PROJECT_NOT_EXIST);

        project.setProjectStateForManager(projectState);
        return projectRepository.save(project);
    }

    @Override
    public Project save(Project project) {
        return update(project);
    }

    @Override
    public void delete(Long projectId) {
        Project project = findOne(projectId);
        if (project == null) throw new MyException(ResultEnum.PROJECT_NOT_EXIST);
        projectRepository.delete(project);

    }


}
