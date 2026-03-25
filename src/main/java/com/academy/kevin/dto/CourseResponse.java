package com.academy.kevin.dto;

import java.time.Instant;

/**
 * DTO for course response data.
 * Based on the structure from Guide 5.
 */
public class CourseResponse {
    private Long id;
    private String name;
    private String description;
    private Boolean active;
    private Instant createdAt;
    private Long instructorId; // [cite: 580]
    private String instructorName;

    public Long getInstructorId() { return instructorId; } // [cite: 582-584]
    public void setInstructorId(Long instructorId) { this.instructorId = instructorId; } // [cite: 585-587]
    public String getInstructorName() { return instructorName; } // [cite: 588-590]
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; } // [cite: 591-593]
    // Getters and Setters [cite: 243-248]
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}