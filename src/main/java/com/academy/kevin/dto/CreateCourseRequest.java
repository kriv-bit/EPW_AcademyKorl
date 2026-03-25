package com.academy.kevin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating a new course.
 * Based on the structure from Guide 5.
 */
public class CreateCourseRequest {

    @NotBlank(message = "Name is required") // Validation for Point 4
    @Size(max = 150, message = "Name must be <= 150 chars")
    private String name;

    @Size(max = 500, message = "Description must be <= 500 chars")
    private String description;
    private Long instructorId; // [cite: 570]

    public Long getInstructorId() { return instructorId; } // [cite: 572-574]
    public void setInstructorId(Long instructorId) { this.instructorId = instructorId; } // [cite: 575-576]
    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}