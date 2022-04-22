package com.pdist.teacherSchedule.repository;

import com.pdist.teacherSchedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
