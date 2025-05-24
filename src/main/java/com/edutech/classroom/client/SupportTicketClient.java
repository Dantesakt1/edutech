package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-support-client", url = "https://localhost:9010/api/support-tickets")
public interface SupportTicketClient {
    @GetMapping("/{id}")
    Object getSupportTicketById(@PathVariable("id") String id);
}
