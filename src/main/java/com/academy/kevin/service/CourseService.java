package com.academy.kevin.service;

import com.academy.kevin.dto.CourseResponse;
import com.academy.kevin.dto.CreateCourseRequest;
import com.academy.kevin.dto.UpdateCourseRequest; // Added
import java.util.List;

public interface CourseService {
    CourseResponse create(CreateCourseRequest request);
    List<CourseResponse> list();
    CourseResponse update(Long id, UpdateCourseRequest request); // Added [cite: 329]
}