package co.com.pt.repository;

import co.com.pt.entity.Department;
import co.com.pt.entity.ProjectCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectAreaRepository extends JpaRepository<ProjectCategory, String> {

    java.util.List<ProjectCategory> findAll();

    // Department findByDepartmentId(Long id);

}
