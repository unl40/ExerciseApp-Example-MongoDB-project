package com.example.demo.service;

import com.example.demo.dto.ExerciseLogDto;
import com.example.demo.entity.ExerciseLogEntity;
import com.example.demo.enums.ExerciseTypesEnum;
import com.example.demo.mapper.ExerciseLogMapper;
import com.example.demo.repository.ExerciseLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    ExerciseLogRepository exerciseLogRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ExerciseLogMapper exerciseLogMapper;

    public ExerciseLogDto saveExerciseLog(ExerciseLogDto exerciseLogDto) {
        ExerciseLogEntity result = exerciseLogRepository.save(exerciseLogMapper.mapToEntity(exerciseLogDto));
        return exerciseLogMapper.mapToDto(result);
    }

    public void deleteExerciseLog(String id) {
        exerciseLogRepository.deleteById(id);
    }

    public List<ExerciseLogDto> findByDateTimeBetweenAndByExerciseTypesEnum(LocalDateTime start, LocalDateTime end, ExerciseTypesEnum exerciseTypesEnum) {
        Query query = new Query();
        if (start != null && end != null) {
            query.addCriteria(Criteria.where("exerciseDateTime").gte(start).andOperator(Criteria.where("exerciseDateTime").lte(end)));
        }
        if (exerciseTypesEnum != null) {
            query.addCriteria(Criteria.where("exerciseTypesEnum").is(exerciseTypesEnum.name()));
        }
        List<ExerciseLogEntity> result = mongoTemplate.find(query, ExerciseLogEntity.class);
        return exerciseLogMapper.mapToDto(result);
    }

    public List<ExerciseLogEntity> findByExerciseTypesEnum(ExerciseTypesEnum exerciseTypesEnum) {
        return exerciseLogRepository.findByExerciseTypesEnum(exerciseTypesEnum);
    }

    public void updateExerciseLog(String id, ExerciseLogDto exerciseLogDto) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("exerciseTypesEnum", exerciseLogDto.getExerciseTypesEnum());
        update.set("exerciseDateTime", exerciseLogDto.getExerciseDateTime());
        mongoTemplate.updateFirst(query, update, ExerciseLogEntity.class);
    }

}



