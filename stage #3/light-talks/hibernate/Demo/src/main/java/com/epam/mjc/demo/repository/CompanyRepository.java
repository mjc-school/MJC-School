package com.epam.mjc.demo.repository;

import com.epam.mjc.demo.entity.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Company company) {
        entityManager.persist(company);
    }

    public Company findById(Long companyId) {
        return entityManager.find(Company.class, companyId);
    }
}
