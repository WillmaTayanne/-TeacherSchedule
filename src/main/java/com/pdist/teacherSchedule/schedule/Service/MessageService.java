package com.pdist.teacherSchedule.schedule.Service;

import com.pdist.teacherSchedule.schedule.Model.Message;
import com.pdist.teacherSchedule.schedule.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    public Message push(Message message){
        return this.messageRepository.save(message);
    }
}
