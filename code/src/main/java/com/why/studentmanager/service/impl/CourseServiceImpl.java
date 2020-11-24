package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.domain.SelectCourse;
import com.why.studentmanager.mapper.CourseMapper;
import com.why.studentmanager.mapper.SelectCourseMapper;
import com.why.studentmanager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private SelectCourseMapper selectCourseMapper;

    @Override
    public List<Course> findAllCourse() {
        List<Course> courses = courseMapper.findAllCourse();
        return courses;
    }

    @Override
    public List<Course> findByTid(int tid) {
        List<Course> courses = courseMapper.findByTid(tid);
        return courses;
    }

    @Override
    public int addCourse(Course course) {
        int result = courseMapper.addCourse(course);
        return result;
    }

    @Override
    public int updateCourse(Course course) {
        int result = courseMapper.updateCourse(course);
        return result;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int deleteCourse(int id) {
        List<SelectCourse> selectCourses = selectCourseMapper.findByCourseId(id);
        System.out.println(selectCourses);
        if(selectCourses.size() == 0){
            int result = courseMapper.deleteCourse(id);
            courseMapper.alterTable();
            return result;
        }
        else{
            return 0;
        }

    }

    @Override
    public Course findById(int id) {

        Course course = courseMapper.findById(id);
        return course;
    }


}
