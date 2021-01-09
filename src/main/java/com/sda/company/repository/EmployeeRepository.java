package com.sda.company.repository;


import com.sda.company.models.Department;
import com.sda.company.models.Employee;
import com.sda.company.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// annotarea @Repository nu este obligatorie, dar este bine de mentionat
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    Optional<Employee> findEmployeeByProjectListAndDepartment(Department department, Project project);

    @Query("select e from Employee e where e.firstName like :name%")
    List<Employee> getAllEmployeesBySpecificName(@Param("name") String name);


}
