package com.academy.kevin.service.impl;

import com.academy.kevin.dto.CourseResponse;
import com.academy.kevin.dto.CreateCourseRequest;
import com.academy.kevin.dto.UpdateCourseRequest;
import com.academy.kevin.entity.Course;
import com.academy.kevin.entity.Instructor;
import com.academy.kevin.exception.ResourceNotFoundException;
import com.academy.kevin.repository.CourseRepository;
import com.academy.kevin.repository.InstructorRepository;
import com.academy.kevin.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Complete implementation of CourseService with Instructor relationship.
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final InstructorRepository instructorRepository;

    /**
     * Constructor injection for both repositories.
     */
    public CourseServiceImpl(CourseRepository repository, InstructorRepository instructorRepository) {
        this.repository = repository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public CourseResponse create(CreateCourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());

        // Point 5: Relationship with Instructor 
        if (request.getInstructorId() != null) {
            Instructor instructor = instructorRepository.findById(request.getInstructorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Instructor " + request.getInstructorId() + " not found"));
            course.setInstructor(instructor);
        }

        Course saved = repository.save(course);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public CourseResponse update(Long id, UpdateCourseRequest request) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course " + id + " not found"));

        course.setName(request.getName());
        course.setDescription(request.getDescription());
        
        if (request.getActive() != null) {
            course.setActive(request.getActive());
        }

        return toResponse(repository.save(course));
    }

    /**
     * Helper method to map Entity to Response DTO.
     */
    private CourseResponse toResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setName(course.getName());
        response.setDescription(course.getDescription());
        response.setActive(course.getActive());
        response.setCreatedAt(course.getCreatedAt());

        // Point 5: Map Instructor details to the response if they exist 
        if (course.getInstructor() != null) {
            response.setInstructorId(course.getInstructor().getId());
            response.setInstructorName(course.getInstructor().getName());
        }

        return response;
    }
}