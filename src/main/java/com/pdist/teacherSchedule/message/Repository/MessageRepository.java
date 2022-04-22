package com.pdist.teacherSchedule.message.Repository;

import com.pdist.teacherSchedule.message.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
