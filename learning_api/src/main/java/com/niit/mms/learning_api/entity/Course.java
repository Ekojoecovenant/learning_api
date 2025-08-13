package com.niit.mms.learning_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Course title is required")
    @Size(max = 50, message = "Course title must be at most 50 characters")
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @NotBlank(message = "Duration is required")
    @Size(max = 3, message = "Duration must be at most 3 characters")
    @Column(name = "duration", nullable = false, length = 3)
    private int duration;

    @NotBlank(message = "Instructor is required")
    @Size(max = 50, message = "Instructor must be at most 3 characters")
    @Column(name = "instructor", nullable = false, length = 50)
    private int instructor;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

}
