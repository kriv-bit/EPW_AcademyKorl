package com.academy.kevin.repository;

import com.academy.kevin.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Course entity persistence operations.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Inherits standard CRUD methods from JpaRepository
}