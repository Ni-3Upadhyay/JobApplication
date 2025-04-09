package com.nitin.firstjobapp.company.companyrepository;

import com.nitin.firstjobapp.company.companyentity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>{


}
