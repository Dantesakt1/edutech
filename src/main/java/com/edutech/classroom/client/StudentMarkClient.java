package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-student-mark", url = "https://localhost:9009/api/student-marks")
public interface StudentMarkClient {
    @GetMapping("/{id}")
    Object getStudentMarkById(@PathVariable("id") String id);
}
