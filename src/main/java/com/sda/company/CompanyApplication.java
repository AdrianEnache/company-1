package com.sda.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }


    //TODO Pentru cele 2 modele, construiti relatia de OneToMany intre ele, adica o Companie are mai multi Employees - done
    //TODO Pentru cele 2 modele, construiti CRUD-ul cu metodele de DeleteById, FindById si Update - done
    //todo de setat securitatea, de reluat discutia in 09.01.2021 - done
    //todo de configurat Authorization din Postman la toate metodele noastre - done
    //todo de oferit privilegii la admin sau user pentru Employee si Company - done




}
