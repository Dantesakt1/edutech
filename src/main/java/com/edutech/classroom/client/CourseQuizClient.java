package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-course-quiz", url = "https://localhost:9006/api/course-quizzes")
public interface CourseQuizClient {
    @GetMapping("/{id}")
    Object getCourseQuizById(@PathVariable("id") String id);
}
