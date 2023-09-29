package com.maveric.quizapp.services;

import com.maveric.quizapp.dto.QuestionRequestDto;
import com.maveric.quizapp.dto.QuestionResponseDto;

import java.util.List;

public interface IquestionService {

QuestionResponseDto addQuestion(QuestionRequestDto questionRequestDto);

List<QuestionResponseDto> getAll();
}
