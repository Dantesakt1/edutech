package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.QuizResponse;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data

public class QuizResponseDTO {
    private Integer id;

    @NotNull(message = "El ID del quiz no puede estar vacío")
    private Integer quizId;

    @NotNull(message = "El ID del estudiante no puede estar vacío")
    private Integer studentId;

    @Size(max = 1, message = "Solo puede seleccionar una opción")
    private String selectedOption;

    @Size(max = 800, message = "El contenido de la respuesta no puede superar los 800 caracteres")
    private String responseContent;

    @Size(max = 800, message = "La URL del trabajo no puede superar los 800 caracteres")
    private String assignmentUrl;

    @NotNull(message = "La fecha de entrega no puede estar vacía")
    private Instant submittedAt;

    public static QuizResponseDTO fromEntity(QuizResponse entity) {
        QuizResponseDTO dto = new QuizResponseDTO();
        dto.setId(entity.getId());
        dto.setQuizId(entity.getQuiz().getId());
        dto.setStudentId(entity.getStudent().getId());
        dto.setSelectedOption(entity.getSelectedOption());
        dto.setResponseContent(entity.getResponseContent());
        dto.setAssignmentUrl(entity.getAssignmentUrl());
        dto.setSubmittedAt(entity.getSubmittedAt());
        return dto;
    }

    public QuizResponse toEntity() {
        QuizResponse entity = new QuizResponse();
        entity.setId(this.id);

        CourseQuiz quiz = new CourseQuiz();
        quiz.setId(this.quizId);
        entity.setQuiz(quiz);

        User student = new User();
        student.setId(this.studentId);
        entity.setStudent(student);

        entity.setSelectedOption(this.selectedOption);
        entity.setResponseContent(this.responseContent);
        entity.setAssignmentUrl(this.assignmentUrl);
        entity.setSubmittedAt(this.submittedAt);

        return entity;
    }
}
