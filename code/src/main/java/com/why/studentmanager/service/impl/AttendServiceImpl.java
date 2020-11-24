package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Attend;
import com.why.studentmanager.domain.Attendance;
import com.why.studentmanager.mapper.AttendMapper;
import com.why.studentmanager.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendServiceImpl implements AttendService {
    @Autowired
    private AttendMapper attendMapper;

    @Override
    public List<Attend> findByCourseId(int courseId) {
        List<Attend> attends = attendMapper.findByCourseId(courseId);
        return attends;
    }

    @Override
    public List<Attend> findByTid(int tid) {
        List<Attend> attends =attendMapper.findByTid(tid);
        return attends;
    }

    @Override
    public int newattend(Attend attend) {

        int count = attendMapper.countselect(attend.getCourseId());
        attend.setCount(count+1);
        System.out.println(attend);
        attendMapper.newattend(attend);
        return count+1;
    }

    @Override
    public int updateNum(int id) {
        int result = attendMapper.updateNum(id);
        return result;
    }

    @Override
    public int batchInsert(List<Attendance> attendances) {
        int rsult = attendMapper.batchInsert(attendances);
        return rsult;
    }

    @Override
    public int findByAttend(Attend attend) {
        int rs = attendMapper.findByAttend(attend);
        return rs;
    }
}
