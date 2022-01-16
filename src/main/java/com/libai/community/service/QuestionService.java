package com.libai.community.service;

import com.libai.community.dto.PaginationDTO;
import com.libai.community.dto.QuestionDTO;
import com.libai.community.mapper.QuestionMapper;
import com.libai.community.mapper.UserMapper;
import com.libai.community.model.Question;
import com.libai.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        Integer offsize = size * (page - 1);
        List<Question> list = questionMapper.list(offsize,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : list){
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        Integer totalCount = questionMapper.count();
        //分页数
        paginationDTO.setPagenation(totalCount,page,size);
        return paginationDTO;
    }
}
