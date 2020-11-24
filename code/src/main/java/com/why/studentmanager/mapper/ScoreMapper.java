package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Score;

import java.util.List;

public interface ScoreMapper {
    List<Score>  findAllScore();
    Score findById(int id);
    List<Score> findBySid(int sid);
    List<Score> findByTid(int tid);
    List<Score> findByCourseId(int courseId);
    int deleteById(int id);
    int uplodScore(List<Score> scores);
    int addScore(Score score);
    int updateScore(Score score);
    Integer findByScore(Score score);


    int alterTable();
}
