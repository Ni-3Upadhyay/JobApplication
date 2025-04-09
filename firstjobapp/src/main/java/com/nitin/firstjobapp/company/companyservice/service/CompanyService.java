package com.nitin.firstjobapp.company.companyservice.service;

import com.nitin.firstjobapp.company.companyentity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company updateCompanyById(Company company);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);

}
