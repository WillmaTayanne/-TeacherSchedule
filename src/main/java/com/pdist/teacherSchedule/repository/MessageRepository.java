package com.pdist.teacherSchedule.repository;

import com.pdist.teacherSchedule.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
