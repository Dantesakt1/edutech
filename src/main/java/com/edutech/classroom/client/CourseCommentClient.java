package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-course-comment", url = "https://localhost:9004/api/course-comments")
public interface CourseCommentClient {
    @GetMapping("/{id}")
    Object getCourseCommentById(@PathVariable("id") String id);
}
