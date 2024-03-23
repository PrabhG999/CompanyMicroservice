package com.example.companyms.Company;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CompanyService {
    //TODO : Ask for the methods needs to be created for CompanyServiceIMPL - Interface is a Contract BW a client and a Engineer

    List<Company> getAllCompanies();

    boolean updateCompany(int id, @RequestBody Company updateCompany);

    boolean addCompany(@RequestBody Company company);

    boolean deleteCompany(int id);

    Company getAllCompaniesById(int id);

    boolean patchCompany(int id, @RequestBody Company company);
}
