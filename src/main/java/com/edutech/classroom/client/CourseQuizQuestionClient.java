package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-course-quiz-question", url = "http://localhost:9007/api/course-quiz-questions")
public interface CourseQuizQuestionClient {
    @GetMapping("/{id}")
    Object getCourseQuizQuestionById(@PathVariable("id") String id);
}
