package co.com.pt.repository;

import co.com.pt.entity.Department;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    java.util.List<Department> findAll();

    Department findByDepartmentId(Long id);

}
