package com.sda.company.repository;

import com.sda.company.models.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// adnotarea @Repository nu este obligatorie, dar este bine de mentionat
// PagingAndSortingRepository - extinde CrudRepository
@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {


}
