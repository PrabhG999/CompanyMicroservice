package com.example.companyms.Company.Impl;

import com.example.companyms.Company.Company;
import com.example.companyms.Company.CompanyRepository;
import com.example.companyms.Company.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    //TODO : Dependency Injection
    private final CompanyRepository companyRepository;

    // it tells Spring to automatically inject the dependencies required by that service when it is instantiated.
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }
    @Override
    @Transactional
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(int id,  Company updateCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setName(updateCompany.getName());
            company.setDescription(updateCompany.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addCompany(Company company) {
        if (company != null) {
            companyRepository.save(company);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCompany(int id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Company getAllCompaniesById(int id) {
        return companyRepository.findById(id).orElse(null);
    }


    @Override
    public boolean patchCompany(int id,  Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company existingCompany = companyOptional.get();
            if (company.getName() != null) {
                existingCompany.setName(company.getName());
            }
            if (company.getDescription() != null) {
                existingCompany.setDescription(company.getDescription());
            }
            companyRepository.save(existingCompany);
            return true;
        }
        return false;
    }
}
