package com.academy.kevin.repository;

import com.academy.kevin.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Instructor entity [cite: 565-566].
 */
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}