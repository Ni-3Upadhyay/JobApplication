package com.nitin.firstjobapp.company.companycontroller;


import com.nitin.firstjobapp.company.companyentity.Company;
import com.nitin.firstjobapp.company.companyservice.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Company> updateCompany(@RequestBody Company company){
        Company updatedCompany = companyService.updateCompanyById(company);
        if(updatedCompany != null){
            return new ResponseEntity<>(updatedCompany, HttpStatus.CREATED);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);

        return new ResponseEntity<>("Company created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        if(companyService.deleteCompanyById(id)){
            return new ResponseEntity<>("Has deleted the company with id : " + id, HttpStatus.CREATED);
        }

        return new ResponseEntity<>("unable to dlete the company with id : " + id , HttpStatus.NOT_FOUND);

    }

    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }





}
