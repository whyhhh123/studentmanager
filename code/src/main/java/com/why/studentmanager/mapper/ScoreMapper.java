package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Score;

import java.util.List;

public interface ScoreMapper {
    List<Score>  findAllScore();
    Score findById(int id);
    int deleteById(int id);
    int uplodScore(List<Score> scores);
    int addScore(Score score);
    int updateScore(Score score);
    int alterTable();
}
