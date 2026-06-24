package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository automatically gives you methods like save(), findAll(), findById(), delete()!
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}