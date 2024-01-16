package com.example.hibernate.manytomany.dao;

import com.example.hibernate.manytomany.Company;
import com.example.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing

        }
    }
    @Test
    void getByLastName() {
        //Given
        Employee employee1 = new Employee("Kagami", "Wakatsuki");
        Employee employee2 = new Employee("Tsukasa", "Wakatsuki");
        Employee employee3 = new Employee("Kimika", "Tachibana");
        Employee employee4 = new Employee("Ayana", "Otonashi");

        //When
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        employeeDao.save(employee4);
        List<Employee> filteredEmployees = employeeDao.getByLastName("Wakatsuki");

        //Then
        assertEquals(2, filteredEmployees.size());
        assertTrue(filteredEmployees.contains(employee1));
        assertTrue(filteredEmployees.contains(employee2));

        //CleanUp
        employeeDao.deleteById(employee1.getId());
        employeeDao.deleteById(employee2.getId());
        employeeDao.deleteById(employee3.getId());
        employeeDao.deleteById(employee4.getId());

    }
    @Test
    void getByFirstThreeLetters() {
        //Given
        Company company1 = new Company("Capsule Corp");
        Company company2 = new Company("SeeD");
        Company company3 = new Company("Longinus Dreizehn Orden");
        Company company4 = new Company("Starnova");

        //When
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);
        List<Company> filteredCompanies = companyDao.getByFirstThreeLetters("Cap");

        //Then
        assertEquals(1, filteredCompanies.size());
        assertTrue(filteredCompanies.contains(company1));

        //CleanUp
        companyDao.deleteById(company1.getId());
        companyDao.deleteById(company2.getId());
        companyDao.deleteById(company3.getId());
        companyDao.deleteById(company4.getId());

    }
}