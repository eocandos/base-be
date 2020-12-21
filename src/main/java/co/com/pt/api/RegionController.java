package co.com.pt.api;

import co.com.pt.entity.City;
import co.com.pt.entity.Department;
import co.com.pt.service.RegionService;
import co.com.pt.shared.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping("/department")
    @JsonView(Views.NoCities.class)
    public java.util.List<Department> findAllDeparments() {
        return regionService.findAllDepartments();
    }

    @GetMapping("/department/{id}")
    public ResponseEntity findCitiesByDeparmentId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(regionService.findCitiesByDepartment(id));
    }


    
}
