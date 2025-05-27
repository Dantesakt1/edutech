package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-role", url = "https://localhost:9001/api/roles")
public interface RoleClient {
    @GetMapping("/{id}")
    Object getRoleById(@PathVariable("id") String id);
}
