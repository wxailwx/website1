package cn.com.service.impl;

import cn.com.entity.Judge;
import cn.com.mapping.JudgeMapper;
import cn.com.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JudgeServiceImp implements JudgeService {
    @Autowired
    private JudgeMapper judgeMapper;
    public boolean insertJudge(Judge judge)throws Exception{
        return judgeMapper.insertJudge(judge);
    }
}
