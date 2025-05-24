package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-quiz-response", url = "https://localhost:9008/api/quiz-responses")
public interface QuizResponseClient {
    @GetMapping("/{id}")
    Object getQuizResponseById(@PathVariable("id") String id);
}
