package co.com.pt.service.impl;

import co.com.pt.entity.ProjectCategory;
import co.com.pt.repository.ProjectAreaRepository;
import co.com.pt.service.ProjectAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectAreaServiceImpl implements ProjectAreaService {

    @Autowired
    ProjectAreaRepository projectAreaRepository;

    /*
    @Autowired
    CityRepository cityRepository;*/

    @Override
    public List<ProjectCategory> findAllCategories() {
        return projectAreaRepository.findAll();
    }

    /*
    @Override
    public Department findCitiesByDepartment(Long id) {
        return departmentRepository.findByDepartmentId(id);
    }*/


}
