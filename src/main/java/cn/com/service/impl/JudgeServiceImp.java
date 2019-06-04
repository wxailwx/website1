package cn.com.service.impl;

import cn.com.entity.Judge;
import cn.com.mapping.JudgeMapper;
import cn.com.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeServiceImp implements JudgeService {
    @Autowired
    private JudgeMapper judgeMapper;
    public boolean insertJudge(Judge judge)throws Exception{
        return judgeMapper.insertJudge(judge);
    }
    public List<Judge> searchJudge(int shoperid)throws Exception{
        return judgeMapper.searchJudge(shoperid);
    }
}
