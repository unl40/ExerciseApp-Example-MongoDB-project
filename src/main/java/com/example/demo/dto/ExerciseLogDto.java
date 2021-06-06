package com.example.demo.dto;

import com.example.demo.enums.ExerciseTypesEnum;

import java.time.LocalDateTime;

public class ExerciseLogDto {

    private String id;
    private ExerciseTypesEnum exerciseTypesEnum;
    private LocalDateTime exerciseDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExerciseTypesEnum getExerciseTypesEnum() {
        return exerciseTypesEnum;
    }

    public void setExerciseTypesEnum(ExerciseTypesEnum exerciseTypesEnum) {
        this.exerciseTypesEnum = exerciseTypesEnum;
    }

    public LocalDateTime getExerciseDateTime() {
        return exerciseDateTime;
    }

    public void setExerciseDateTime(LocalDateTime exerciseDateTime) {
        this.exerciseDateTime = exerciseDateTime;
    }

}
