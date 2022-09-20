package com.testapp.municipalitytax.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Schedule {

    public enum ScheduleType {
        YEARLY,
        MONTHLY,
        WEEKLY,
        DAILY
    }

    private final Set<String> scheduleTypes = new HashSet<>(Arrays.stream(ScheduleType.values())
            .map(ScheduleType::name).collect(Collectors.toList()));

    private final String value;

    public Schedule(ScheduleType value){
        this.value = value.toString();
    }

    public Schedule(String value) {
        try {
            this.value = value.toUpperCase();
            validate();
        } catch (Exception e){
            throw new RuntimeException("not valid value", e);
        }
    }

    private void validate(){
        Objects.requireNonNull(value);
        if(!scheduleTypes.contains(value)){
            throw new RuntimeException("not valid value");
        }
    }

    public String value() {
        return value;
    }

    public ScheduleType type(){
        return ScheduleType.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        return value.equals(schedule.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
