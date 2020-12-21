package co.com.pt.service;

import co.com.pt.entity.City;
import co.com.pt.entity.Department;

public interface RegionService {

    java.util.List<Department> findAllDepartments();

    Department findCitiesByDepartment(Long departmentId);
}
