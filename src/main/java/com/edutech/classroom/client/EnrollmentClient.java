package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-enrollment", url = "https://localhost:9011/api/enrollments")
public interface EnrollmentClient {
    @GetMapping("/{id}")
    Object getEnrollmentById(@PathVariable("id") String id);
}
