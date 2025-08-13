package com.niit.mms.learning_api.controller;

import com.niit.mms.learning_api.entity.Course;
import com.niit.mms.learning_api.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // ✅ CREATE - Save a new course
    @PostMapping
    public ResponseEntity<Course> saveStudent(@Valid @RequestBody Course course) {
        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    // ✅ UPDATE - Update course details
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateStudent(@PathVariable Long id, @Valid @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        if (updatedCourse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCourse);
    }

    // ✅ READ - Get a single course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getStudentById(@PathVariable Long id) {
        Course course = courseService.findCourse(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    // ✅ READ - Get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllStudents() {
        List<Course> students = courseService.findAllCourses(null, null);
        return ResponseEntity.ok(students);
    }

    // ✅ DELETE - Delete a course by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
