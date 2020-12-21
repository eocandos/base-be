package co.com.pt.repository;

import co.com.pt.entity.City;
import co.com.pt.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

    java.util.List<City> findByDepartment(Long departmentId);

}
