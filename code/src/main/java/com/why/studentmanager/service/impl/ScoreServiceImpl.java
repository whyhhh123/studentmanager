package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Score;
import com.why.studentmanager.mapper.ScoreMapper;
import com.why.studentmanager.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> findAllScore() {
        List<Score> scores =scoreMapper.findAllScore();
        return scores;
    }

    @Override
    public Score findById(int id) {
        Score score = scoreMapper.findById(id);
        return score;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int deleteById(int id) {
        int result = scoreMapper.deleteById(id);
        //scoreMapper.alterTable();
        return result;
    }

    @Override
    public int uplodScore(List<Score> scores) {
        int result = scoreMapper.uplodScore(scores);
        return result;
    }

    @Override
    public int addScore(Score score) {
        System.out.println("score = " + score);
        int result = scoreMapper.addScore(score);
        return result;
    }

    @Override
    public int updateScore(Score score) {
        int result = scoreMapper.updateScore(score);
        return result;
    }

    @Override
    public Integer findByScore(Score score) {
        Integer result = scoreMapper.findByScore(score);
        return result;
    }

    @Override
    public List<Score> findBySid(int sid) {
        List<Score> scores = scoreMapper.findBySid(sid);
        return scores;

    }

    @Override
    public List<Score> findByTid(int tid) {
        List<Score> scores = scoreMapper.findByTid(tid);
        return scores;
    }

    @Override
    public List<Score> findByCourseId(int courseId) {
        List<Score> scores = scoreMapper.findByCourseId(courseId);
        return scores;
    }
}
