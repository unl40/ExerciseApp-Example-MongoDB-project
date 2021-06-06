package com.example.demo.enums;

public enum ExerciseTypesEnum {

    RUNNING(5),
    ROWING(8),
    YOGA(2),
    SWIMMING(7);

    private final int calorieBurnPerMinute;

    ExerciseTypesEnum(int calorieBurnPerMinute) {
        this.calorieBurnPerMinute = calorieBurnPerMinute;
    }

    public int getCalorieBurnPerMinute() {
        return calorieBurnPerMinute;
    }
}
