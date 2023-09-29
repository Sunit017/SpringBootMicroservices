package com.maveric.quizapp.controller;

import com.maveric.quizapp.dto.QuestionRequestDto;
import com.maveric.quizapp.dto.QuestionResponseDto;
import com.maveric.quizapp.services.questionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class questionController {

    @Autowired
    private questionServiceImpl questionService;

    @PostMapping("/add")
    public ResponseEntity<QuestionResponseDto> addAll(@RequestBody QuestionRequestDto requestDto)
    {
        QuestionResponseDto questionResponseDto=this.questionService.addQuestion(requestDto);
        return new ResponseEntity<>(questionResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<QuestionResponseDto>> getAllQuestion()
    {
        List<QuestionResponseDto> responseDtoList=this.questionService.getAll();
        return ResponseEntity.ok(responseDtoList);
    }


}
