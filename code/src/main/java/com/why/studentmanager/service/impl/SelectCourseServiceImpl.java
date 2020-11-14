package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.domain.SelectCourse;
import com.why.studentmanager.mapper.CourseMapper;
import com.why.studentmanager.mapper.SelectCourseMapper;
import com.why.studentmanager.service.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SelectCourseServiceImpl implements SelectCourseService {
    @Autowired
    SelectCourseMapper selectCourseMapper;
    @Autowired
    CourseMapper courseMapper;

    @Override
    public int addSelectCourse(SelectCourse selectCourse) {
        SelectCourse s = selectCourseMapper.findSelect(selectCourse);
        if(StringUtils.isEmpty(s)){
            int result = courseMapper.selectCourse(selectCourse);

            if(result==0){
                return 0;
            }
            else if(result == 1){
                int rs = selectCourseMapper.addSelectCourse(selectCourse);
                if(rs>0){
                    return 1;
                }
                else{
                    return 3;
                }

            }
        }
        return 2;

    }

    @Override
    public List<Course> showSelected(int sid) {
        List<Course> selectedCourses = selectCourseMapper.showSelected(sid);
        return selectedCourses;
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int deleteBySelectCourse(SelectCourse selectCourse) {
        SelectCourse sc = selectCourseMapper.findSelect(selectCourse);

        int rs = selectCourseMapper.deleteById(sc.getId());
        if(rs>0){
            selectCourseMapper.alterTable();
            int result = courseMapper.decSelected(selectCourse.getCourseId());

            if(result>0){
                courseMapper.alterTable();
                return 1;
            }
            return 2;
        }
        return 0;
    }
}
