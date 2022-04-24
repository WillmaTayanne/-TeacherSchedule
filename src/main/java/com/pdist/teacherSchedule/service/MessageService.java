package com.pdist.teacherSchedule.service;

import com.pdist.teacherSchedule.dto.MessageRequest;
import com.pdist.teacherSchedule.model.Message;
import com.pdist.teacherSchedule.repository.MessageRepository;
import com.pdist.teacherSchedule.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Message> read() {
        return this.messageRepository.findAll();
    }

    public Message readById(Long id){
        return this.messageRepository.findById(id).orElse(null);
    }

    public List<Message> readForUser(Long idUser){
        return this.read().stream().filter(message -> message.getUserIdOrigin().getId().equals(idUser) ||
                message.getUserIdDestination().getId().equals(idUser)).toList();
    }

    @Transactional
    public Message push(Message message){
        return this.messageRepository.save(message);
    }

    @Transactional
    public Message create(MessageRequest messageRequest){
        Message message = messageRequest.toMessage(usuarioRepository);
        return this.messageRepository.save(message);
    }

    @Transactional
    public Message update(Message message){
        return this.messageRepository.save(message);
    }

    public void delete(Long id){
        this.messageRepository.deleteById(id);
    }
}
