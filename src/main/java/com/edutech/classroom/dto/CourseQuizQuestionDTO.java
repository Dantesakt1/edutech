package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.CourseQuizQuestion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;
@Data

public class CourseQuizQuestionDTO {
    private Integer id;

    private Integer quizId;

    @Size(max = 800, message = "El texto no puede superar los 800 caracteres")
    private String questionText;

    @Size(max = 800, message = "La opción no puede superar los 800 caracteres")
    private String optionA;

    @Size(max = 800, message = "La opción no puede superar los 800 caracteres")
    private String optionB;

    @Size(max = 800, message = "La opción no puede superar los 800 caracteres")
    private String optionC;

    @Size(max = 800, message = "La opción no puede superar los 800 caracteres")
    private String optionD;

    @Size(max = 800, message = "La opción no puede superar los 800 caracteres")
    private String optionE;

    @Size(max = 800, message = "La opción no puede superar los 800 caracteres")
    private String correctAnswer;

    @Size(max = 1, message = "No pueden haber más de 2 opciones correctas")
    private String correctOption;

    @NotBlank(message = "El orden del índice no puede quedar nulo")
    private Integer orderIndex;

    @NotBlank(message = "La fecha de creación es obligatoria")
    private Instant createdAt;

    public static CourseQuizQuestionDTO fromEntity(CourseQuizQuestion entity) {
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setId(entity.getId());
        dto.setQuizId(entity.getQuiz().getId());
        dto.setQuestionText(entity.getQuestionText());
        dto.setOptionA(entity.getOptionA());
        dto.setOptionB(entity.getOptionB());
        dto.setOptionC(entity.getOptionC());
        dto.setOptionD(entity.getOptionD());
        dto.setOptionE(entity.getOptionE());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        dto.setCorrectOption(entity.getCorrectOption());
        dto.setOrderIndex(entity.getOrderIndex());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseQuizQuestion toEntity() {
        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(this.id);

        CourseQuiz courseQuiz = new CourseQuiz();
        courseQuiz.setId(this.quizId);
        entity.setQuiz(courseQuiz);

        entity.setQuestionText(this.questionText);
        entity.setOptionA(this.optionA);
        entity.setOptionB(this.optionB);
        entity.setOptionC(this.optionC);
        entity.setOptionD(this.optionD);
        entity.setOptionE(this.optionE);
        entity.setCorrectAnswer(this.correctAnswer);
        entity.setCorrectOption(this.correctOption);
        entity.setOrderIndex(this.orderIndex);
        entity.setCreatedAt(this.createdAt);
        return entity;
    }
}
