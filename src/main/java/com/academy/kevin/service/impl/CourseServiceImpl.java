package com.academy.kevin.service.impl;

import com.academy.kevin.dto.CourseResponse;
import com.academy.kevin.dto.CreateCourseRequest;
import com.academy.kevin.dto.UpdateCourseRequest;
import com.academy.kevin.entity.Course;
import com.academy.kevin.exception.ResourceNotFoundException; // You need this from Guide 6
import com.academy.kevin.repository.CourseRepository;
import com.academy.kevin.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseResponse create(CreateCourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        Course saved = repository.save(course);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    /**
     * Complete Update Logic [cite: 371-375].
     */
    @Override
    public CourseResponse update(Long id, UpdateCourseRequest request) {
        // 1. Find the existing course or throw exception [cite: 372, 375]
        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course " + id + " not found"));

        // 2. Update fields [cite: 373, 376]
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        
        // Update active status if provided [cite: 377]
        if (request.getActive() != null) {
            course.setActive(request.getActive());
        }

        // 3. Save and return [cite: 387]
        return toResponse(repository.save(course));
    }

    private CourseResponse toResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setName(course.getName());
        response.setDescription(course.getDescription());
        response.setActive(course.getActive());
        response.setCreatedAt(course.getCreatedAt());
        return response;
    }
}