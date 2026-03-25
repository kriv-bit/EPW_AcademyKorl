package com.academy.kevin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO for updating an existing course[cite: 203, 209].
 */
public class UpdateCourseRequest {

    @NotBlank(message = "Name is required") // [cite: 210]
    @Size(max = 150, message = "Name must be <= 150 chars") // [cite: 211]
    private String name;

    @Size(max = 500, message = "Description must be <= 500 chars") // [cite: 212]
    private String description;

    private Boolean active;

    // Getters and Setters [cite: 216-226]
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}