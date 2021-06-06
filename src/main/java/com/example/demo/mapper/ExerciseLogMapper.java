package com.example.demo.mapper;

import com.example.demo.dto.ExerciseLogDto;
import com.example.demo.entity.ExerciseLogEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExerciseLogMapper {

    ExerciseLogEntity mapToEntity(ExerciseLogDto exerciseLogDto);

    ExerciseLogDto mapToDto(ExerciseLogEntity exerciseLogEntity);

    List<ExerciseLogEntity> mapToEntity(List<ExerciseLogDto> exerciseLogDto);

    List<ExerciseLogDto> mapToDto(List<ExerciseLogEntity> exerciseLogEntity);

}
