package com.why.studentmanager.service;

import com.why.studentmanager.domain.Score;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ScoreService {
    List<Score> findAllScore();
    Score findById(int id);
    int deleteById(int id);
    int uplodScore(List<Score> scores);
    int addScore(Score score);
    int updateScore(Score score);
    int findByScore(Score score);
}
