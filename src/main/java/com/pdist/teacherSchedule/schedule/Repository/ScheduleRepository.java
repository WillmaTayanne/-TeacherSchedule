package com.pdist.teacherSchedule.schedule.Repository;

import com.pdist.teacherSchedule.schedule.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
