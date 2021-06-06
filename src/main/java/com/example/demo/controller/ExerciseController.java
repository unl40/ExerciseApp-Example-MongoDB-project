package com.example.demo.controller;

import com.example.demo.dto.ExerciseLogDto;
import com.example.demo.entity.ExerciseLogEntity;
import com.example.demo.enums.ExerciseTypesEnum;
import com.example.demo.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @PostMapping("/exerciseLog")
    public ExerciseLogDto saveExerciseLog(@RequestBody ExerciseLogDto exerciseLogDto) {
        return exerciseService.saveExerciseLog(exerciseLogDto);
    }

    @GetMapping("/exerciseLog")
    public List<ExerciseLogDto> findExerciseLogByDateTimeBetweenAndByExerciseType(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
                                                                                  @RequestParam(required = false) ExerciseTypesEnum exerciseTypesEnum) {
        return exerciseService.findByDateTimeBetweenAndByExerciseTypesEnum(start, end, exerciseTypesEnum);

    }

    @GetMapping("/exerciseLogRepository")
    public List<ExerciseLogEntity> findByExerciseTypesEnum(@RequestParam ExerciseTypesEnum exerciseTypesEnum) {
        return exerciseService.findByExerciseTypesEnum(exerciseTypesEnum);
    }

    @DeleteMapping("/exerciseLog/{id}")
    public void deleteExerciseLog(@PathVariable String id) {
        exerciseService.deleteExerciseLog(id);
    }

    @PutMapping("/exerciseLog/{id}")
    public void updateExerciseLog(@PathVariable String id, @RequestBody ExerciseLogDto exerciseLogDto) {
        exerciseService.updateExerciseLog(id, exerciseLogDto);
    }

}
