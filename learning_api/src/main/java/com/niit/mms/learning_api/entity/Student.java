package com.niit.mms.learning_api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference; // newly added
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder; // newly added
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet; // newly added
import java.util.Set; // newly added

@Builder // newly added
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidate")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must be at most 50 characters")
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Size(max = 50, message = "Middle name must be at most 50 characters")
    @Column(name = "middle_name", length = 50)
    private String middleName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must be at most 50 characters")
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 120, message = "Age cannot exceed 120")
    @Column(name = "age", nullable = false)
    private int age;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @NotBlank(message = "Date of birth is required")
    @Pattern(
            regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Date of birth must be in the format YYYY-MM-DD"
    )
    @Column(name = "dob", nullable = false, length = 10)
    private String dob;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^\\+?[0-9]{10,15}$",
            message = "Phone number must be valid and contain 10 to 15 digits"
    )
    @Column(name = "phone", nullable = false, unique = true, length = 15)
    private String phone;

    /*          This is what we added today (20th August 2025)          */
    //  To add the relationship between the Course table and the Student table
    @ManyToMany // This relationship is a many-to-many relationship
    @JoinTable(
            name = "candidate_subject",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    @JsonManagedReference
    @Builder.Default
    private Set<Course> course = new HashSet<>();


    // Helper Methods

    public void addCourse(Course course) {
        this.course.add(course);
        course.getStudent().add(this);
    }

    public void removeCourse(Course course) {
        this.course.remove(course);
        course.getStudent().remove(this);
    }

}
