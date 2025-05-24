package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.Enrollment;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class EnrollmentDTO {
    private Integer id;

    @NotNull(message = "El estudiante no puede estar vacío")
    private Integer studentId;

    @NotNull(message = "El curso no puede estar vacío")
    private Integer courseId;

    @NotNull(message = "La fecha de inscripción no puede estar vacía")
    private Instant enrolledAt;

    @NotNull(message = "El estado no puede estar vacío")
    @Size(max = 20, message = "El estado no puede superar los 20 caracteres")
    private String status;

    public static EnrollmentDTO fromEntity(Enrollment entity) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(entity.getId());

        dto.setStudentId(entity.getStudent().getId());
        dto.setCourseId(entity.getCourse().getId());

        dto.setEnrolledAt(entity.getEnrolledAt());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Enrollment toEntity() {
        Enrollment entity = new Enrollment();
        entity.setId(this.id);

        User student = new User();
        student.setId(this.studentId);
        entity.setStudent(student);

        Course course = new Course();
        course.setId(this.courseId);
        entity.setCourse(course);

        entity.setEnrolledAt(this.enrolledAt);
        entity.setStatus(this.status);
        return entity;
    }
}
