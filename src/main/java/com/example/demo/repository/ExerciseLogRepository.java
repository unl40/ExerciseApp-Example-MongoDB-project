package com.example.demo.repository;

import com.example.demo.entity.ExerciseLogEntity;
import com.example.demo.enums.ExerciseTypesEnum;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExerciseLogRepository extends MongoRepository<ExerciseLogEntity, String> {

    List<ExerciseLogEntity> findByExerciseTypesEnum(ExerciseTypesEnum exerciseTypesEnum);
}

