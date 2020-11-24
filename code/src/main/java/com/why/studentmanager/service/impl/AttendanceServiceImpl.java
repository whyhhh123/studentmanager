package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Attend;
import com.why.studentmanager.domain.Attendance;
import com.why.studentmanager.mapper.AttendMapper;
import com.why.studentmanager.mapper.AttendanceMapper;
import com.why.studentmanager.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private AttendMapper attendMapper;

    @Override
    public List<Attendance> findByCourseId(int courseId) {
        List<Attendance> attendances = attendanceMapper.findByCourseId(courseId);
        return attendances;
    }

    @Override
    public List<Attendance> findBySid(int sid) {
        List<Attendance> attendances = attendanceMapper.findBySid(sid);
        return attendances;
    }

    @Override
    public List<Attendance> findAll() {
        List<Attendance> attendances = attendanceMapper.findAll();
        return attendances;
    }

    @Override
    public int addAttend(Attendance attendance) {
        int result = attendanceMapper.addAttend(attendance);
        return result;
    }

    @Override
    public List<Attendance> findByAttend(Attendance attendance) {
        List<Attendance> attendances = attendanceMapper.findByAttend(attendance);
        return attendances;
    }

    @Override
    @Transactional
    public int attendOnTime(int id) {
        Attendance attendance = attendanceMapper.findById(id);
        System.out.println(attendance);
        Attend attend = attendMapper.findById(attendance.getAttendId());
        if(attendance.getStatus()==0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
            Date now = new Date();
            String dateString = sdf.format(now);
            System.out.println(attend);
            if (attend.getStart().compareTo(dateString)>0) {
                return 3;
            } else if (dateString.compareTo(attend.getEnd())<0) {
                attendance.setStatus(2);
                attendanceMapper.updateStatus(attendance);
                return 2;
            } else {
                attendance.setTime(dateString);
                attendance.setStatus(1);
                attendanceMapper.updateStatus(attendance);
                attendMapper.updateNum(attendance.getAttendId());
                return 1;
            }
        }
        else if(attendance.getStatus()==1){
            return 4;
        }
        else{
            return attendance.getStatus();
        }
    }

    @Override
    public List<Attendance> findByCourseIdAttend(Attend attend) {
        List<Attendance> attendances = attendanceMapper.findByCourseIdAttend(attend);
        return attendances;
    }
}
