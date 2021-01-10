package com.sda.company.service;

import com.sda.company.models.Company;

import java.util.List;

public interface CompanyService {

    // metoda ne returneaza o lista cu toate companiile
    List<Company> getAll();

}
