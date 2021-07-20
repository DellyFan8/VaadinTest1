package com.example.vaadintest.backend.repository;
import com.example.vaadintest.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}