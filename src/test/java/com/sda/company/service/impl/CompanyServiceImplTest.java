package com.sda.company.service.impl;

import com.sda.company.models.Company;
import com.sda.company.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
class CompanyServiceImplTest {

    @InjectMocks
    private CompanyServiceImpl companyService;


    @Mock
    private CompanyRepository companyRepository;

    @Test
    void getAll() {

        List<Company>  outCompanyList = new ArrayList<>();
        Company companyExample = new Company();
        outCompanyList.add(companyExample);
        Mockito.when(companyService.getAll()).thenReturn(outCompanyList);

        List<Company> resultList = companyService.getAll();

        Mockito.verify(companyRepository,Mockito.times(1)).findAll();

        Assertions.assertEquals(resultList.size(),outCompanyList.size());


    }
}