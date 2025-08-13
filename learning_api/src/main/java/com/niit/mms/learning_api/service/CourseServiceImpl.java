package com.niit.mms.learning_api.service;

import com.niit.mms.learning_api.entity.Course;
import com.niit.mms.learning_api.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    public final CourseRepository courseRepository;

    public CourseServiceImpl (CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Optional<Course> existingCourse = courseRepository.findById(id);

        if(existingCourse.isPresent()) {
            Course updatedCourse = existingCourse.get();
            updatedCourse.setDescription(updatedCourse.getDescription());
            updatedCourse.setDuration(updatedCourse.getDuration());
            updatedCourse.setTitle(updatedCourse.getTitle());
            updatedCourse.setInstructor(updatedCourse.getInstructor());
            // Add other fields as needed
            return courseRepository.save(updatedCourse);
        }
        throw new RuntimeException("Course not found with id: " + id);
    }

    @Override
    public Course findCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> findAllCourses(Long id, Course course) {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
