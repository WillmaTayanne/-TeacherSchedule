package com.pdist.teacherSchedule.controller;

import com.pdist.teacherSchedule.dto.MessageRequest;
import com.pdist.teacherSchedule.model.Message;
import com.pdist.teacherSchedule.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public List<Message> read(){
        return this.messageService.read();
    }

    @GetMapping("/message/{id}")
    public Message readById(@PathVariable("id") Long id){
        return this.messageService.readById(id);
    }

    @PostMapping("/message")
    public Message create(@RequestBody MessageRequest messageRequest){
        return this.messageService.create(messageRequest);
    }

    @PutMapping("/message/{id}")
    public Message update(@RequestBody Message message){
        return this.messageService.update(message);
    }

    @DeleteMapping("/message/{id}")
    public void delete(@PathVariable("id") Long id){
        this.messageService.delete(id);
    }
}
