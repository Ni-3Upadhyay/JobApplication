package com.nitin.firstjobapp.company.companyservice.impl;

import com.nitin.firstjobapp.company.companyentity.Company;
import com.nitin.firstjobapp.company.companyrepository.CompanyRepository;
import com.nitin.firstjobapp.company.companyservice.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompanyById(Company company) {

        Optional<Company> optionalCompany = companyRepository.findById(company.getId());

        if(optionalCompany.isPresent()){
            Company updateCompany = optionalCompany.get();
            updateCompany.setName(company.getName());
            updateCompany.setDescription(company.getDescription());
            updateCompany.setJobs(company.getJobs());

            companyRepository.save(updateCompany);
            return updateCompany;
        }

        return null;
    }

    public void createCompany(Company company){

        companyRepository.save(company);
    }

    public boolean deleteCompanyById(Long id){

        Optional<Company> findCompany = companyRepository.findById(id);

        if(findCompany.isPresent()){
            Company company = findCompany.get();

            companyRepository.deleteById(id);

            return  true;
        }

        return false;
    }

    @Override
    public Company getCompanyById(Long id) {

        return companyRepository.findById(id).orElse(null);

    }


}

