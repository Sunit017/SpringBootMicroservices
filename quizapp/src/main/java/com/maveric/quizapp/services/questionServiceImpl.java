package com.maveric.quizapp.services;

import com.maveric.quizapp.dto.QuestionRequestDto;
import com.maveric.quizapp.dto.QuestionResponseDto;
import com.maveric.quizapp.entity.Question;
import com.maveric.quizapp.repository.QuestionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class questionServiceImpl implements IquestionService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public QuestionResponseDto addQuestion(QuestionRequestDto questionRequestDto) {

        Question question=this.modelMapper.map(questionRequestDto, Question.class);
        Question addedquestion=this.questionRepo.save(question);
        return this.modelMapper.map(addedquestion,QuestionResponseDto.class);
    }

    @Override
    public List<QuestionResponseDto> getAll() {
        List<Question> questionList = this.questionRepo.findAll();
        List<QuestionResponseDto> responseDtos=questionList.stream().map((qus)->this.modelMapper.map(qus,QuestionResponseDto.class))
                .collect(Collectors.toList());
        return responseDtos;
    }
}
