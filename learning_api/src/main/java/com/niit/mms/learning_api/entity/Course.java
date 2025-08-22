package com.niit.mms.learning_api.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

    @Min(value = 1, message = "Duration must be at least 1 hour")
    @Max(value = 99, message = "Duration must not exceed 99 hours")
    @Column(name = "duration", nullable = false, length = 3)
    private int duration;

    @NotBlank(message = "Instructor is required")
    @Size(max = 50, message = "Instructor must be at most 50 characters")
    @Column(name = "instructor", nullable = false, length = 50)
    private String instructor;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // This is what we added today (20th August 2025)
    @ManyToMany(mappedBy = "course")
//    @JsonBackReference
    @Builder.Default
    private Set<Student> student = new HashSet<>();

}
