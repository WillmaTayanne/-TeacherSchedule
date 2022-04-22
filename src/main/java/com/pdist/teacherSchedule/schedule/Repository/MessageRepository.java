package com.pdist.teacherSchedule.schedule.Repository;

import com.pdist.teacherSchedule.schedule.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
