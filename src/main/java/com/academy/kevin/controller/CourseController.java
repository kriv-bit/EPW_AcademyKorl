package com.academy.kevin.controller;

import com.academy.kevin.dto.CourseResponse;
import com.academy.kevin.dto.CreateCourseRequest;
import com.academy.kevin.dto.UpdateCourseRequest;
import com.academy.kevin.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing course endpoints [cite: 454-456].
 */
@RestController
@RequestMapping("/api/courses") // Base path for the API [cite: 455]
public class CourseController {

    private final CourseService service;

    /**
     * Constructor injection for the service layer [cite: 457-460].
     */
    public CourseController(CourseService service) {
        this.service = service;
    }

    /**
     * Endpoint to create a new course.
     * Returns HTTP 201 Created on success [cite: 461-462].
     * Validates the request body[cite: 463].
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse create(@Valid @RequestBody CreateCourseRequest request) {
        return service.create(request); // [cite: 465]
    }

    /**
     * Endpoint to list all courses.
     * Returns a JSON array of courses .
     */
    @GetMapping
    public List<CourseResponse> list() {
        return service.list(); // [cite: 469]
    }

    /**
     * Endpoint to update an existing course by ID.
     */
    @PutMapping("/{id}")
    public CourseResponse update(@PathVariable Long id, @Valid @RequestBody UpdateCourseRequest request) {
        return service.update(id, request); // [cite: 477]
    }
}