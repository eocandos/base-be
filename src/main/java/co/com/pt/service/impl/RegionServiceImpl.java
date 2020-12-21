package co.com.pt.service.impl;

import co.com.pt.entity.City;
import co.com.pt.entity.Department;
import co.com.pt.repository.CityRepository;
import co.com.pt.repository.DepartmentRepository;
import co.com.pt.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findCitiesByDepartment(Long id) {
        return departmentRepository.findByDepartmentId(id);
    }


}
