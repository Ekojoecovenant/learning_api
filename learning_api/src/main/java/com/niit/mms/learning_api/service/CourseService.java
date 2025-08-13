package com.niit.mms.learning_api.service;

import com.niit.mms.learning_api.entity.Course;

import java.util.List;

public interface CourseService {

    Course saveCourse(Course course);

    Course updateCourse(Long id, Course course);

    Course findCourse(Long id);

    List<Course> findAllCourses(Long id, Course course);

    void deleteCourse(Long id);
}
