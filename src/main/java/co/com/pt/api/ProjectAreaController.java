package co.com.pt.api;

import co.com.pt.entity.ProjectCategory;
import co.com.pt.service.ProjectAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ProjectAreaController {

    @Autowired
    ProjectAreaService projectAreaService;

    @GetMapping("/area/category")
    public java.util.List<ProjectCategory> findAllCategories() {
        return projectAreaService.findAllCategories();
    }

}
