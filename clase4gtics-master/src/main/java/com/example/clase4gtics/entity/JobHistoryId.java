package com.example.clase4gtics.entity;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class JobHistoryId implements Serializable {

    private Integer employee;
    private LocalDateTime startDate;

    public JobHistoryId() {
    }

    public JobHistoryId(Integer employee, LocalDateTime startDate) {
        this.employee = employee;
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobHistoryId)) return false;
        JobHistoryId that = (JobHistoryId) o;
        return Objects.equals(employee, that.employee) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, startDate);
    }
}
