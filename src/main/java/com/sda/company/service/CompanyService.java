package com.sda.company.service;

import com.sda.company.models.Company;

import java.util.List;

public interface CompanyService {


    // metoda ne returneaza o lista cu toate companiile, pentru asta nu avem nevoie sa ii introducem parametrii
    List<Company> getAll();


}
