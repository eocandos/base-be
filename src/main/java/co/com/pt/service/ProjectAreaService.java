package co.com.pt.service;

import co.com.pt.entity.Department;
import co.com.pt.entity.ProjectCategory;

public interface ProjectAreaService {

    java.util.List<ProjectCategory> findAllCategories();

    // Department findCitiesByDepartment(Long departmentId);
}
