package com.example.companyms.Company;

import com.example.companyms.Company.DTO.CompanyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Beans are typically defined in the Spring configuration files or annotated with
specific annotations such as @Component, @Service, @Repository, or @Controller.*/
/*bean as a Java object that Spring manages and makes available for use throughout your application.
Beans are configured and initialized by Spring, and they can represent various components of your application,
such as controllers, services, repositories, or any other class that you want Spring to manage*/
@RestController
@RequestMapping("/companies")
public class CompanyController {
    //TODO : Dependency Injection for Company Service
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<CompanyDTO> company = companyService.getAllCompanies();
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable int id, @RequestBody Company company) {
        boolean isCompanyUpdated = companyService.updateCompany(id, company);
        if (isCompanyUpdated) {
            return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company was not updated Successfully ", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        boolean isCompanyAdded = companyService.addCompany(company);
        if (isCompanyAdded) {
            return new ResponseEntity<>("Company Added Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Company Was Not Added Sucessfully", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id) {
        boolean isCompanyDeleted = companyService.deleteCompany(id);
        if (isCompanyDeleted) {
            return new ResponseEntity<>("Company Deleted Successfully ", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company Was Not Deleted Successfully ", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getAllCompaniesById(@PathVariable int id) {
        CompanyDTO company = companyService.getAllCompaniesById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchCompany(@PathVariable int id, @RequestBody Company company) {
        boolean isCompanyPatched = companyService.patchCompany(id, company);
        if (isCompanyPatched) {
            return new ResponseEntity<>("Company Patched Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company Was Not Patched Successfully", HttpStatus.BAD_REQUEST);
        }
    }

}
