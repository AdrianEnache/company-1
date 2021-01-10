package com.sda.company.controller;


import com.sda.company.models.Company;
import com.sda.company.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
public class CompanyController {

    // == constants ==
    private final CompanyService companyService;

    // == constructor ==
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // == public methods ==
    @RequestMapping(value = "/showAllCompanies", method = RequestMethod.GET)
    public String showAllCompanies(Model model) {
        List<Company> companyList = companyService.getAll();
        model.addAttribute("list", companyList);
        log.info("showAllCompanies method called");
        return "companyTable";
    }
}
