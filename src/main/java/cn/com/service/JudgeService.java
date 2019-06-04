package cn.com.service;

import cn.com.entity.Judge;

import java.util.List;

public interface JudgeService {
    boolean insertJudge(Judge judge)throws Exception;
    List<Judge> searchJudge(int shoperid)throws Exception;
}
