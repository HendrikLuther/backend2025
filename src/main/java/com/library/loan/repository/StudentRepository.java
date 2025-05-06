package com.library.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.loan.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
}
