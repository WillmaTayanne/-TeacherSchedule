package com.pdist.teacherSchedule.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdist.teacherSchedule.amqp.QueueSender;
import com.pdist.teacherSchedule.dto.ScheduleRequest;
import com.pdist.teacherSchedule.model.Message;
import com.pdist.teacherSchedule.model.Schedule;
import com.pdist.teacherSchedule.model.Usuario;
import com.pdist.teacherSchedule.repository.ScheduleRepository;
import com.pdist.teacherSchedule.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private QueueSender queueSender;

    public List<Schedule> read() {
        return this.scheduleRepository.findAll();
    }

    public Schedule readById(Long id){
        return this.scheduleRepository.findById(id).orElse(null);
    }

    @Transactional
    public Schedule create(ScheduleRequest scheduleRequest){
        Schedule schedule = scheduleRequest.toSchedule(usuarioRepository);
        return this.scheduleRepository.save(schedule);
    }

    @Transactional
    public Schedule update(Schedule schedule){
        Schedule oldSchedule = this.scheduleRepository.getById(schedule.getId());
        Schedule newSchedule = this.scheduleRepository.save(schedule);
        for(Usuario student : schedule.getStudents()) {
            if(oldSchedule.getStudents().contains(student))
                this.sendMessage(newSchedule, student, "Horário Atualizado");
            else
                this.sendMessage(newSchedule, student, "Novo Horário Cadastrado");
        }

        for(Usuario studentOld : oldSchedule.getStudents()) {
            if(!newSchedule.getStudents().contains(studentOld))
                this.sendMessage(newSchedule, studentOld, "Horário Removido");
        }

        return newSchedule;
    }

    public void sendMessage(Schedule schedule, Usuario student, String title) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Message message = new Message();

        message.setRead(false);
        message.setTitle(title);
        message.setUserIdOrigin(schedule.getTeacher());
        message.setUserIdDestination(student);
        message.setDateTime(new Timestamp(System.currentTimeMillis()));
        message.setDescription("Gostariamos de notificar que sobre a aula em " +
                dateFormat.format(schedule.getDateTimeBegin()));

        ObjectMapper objectMapper = new ObjectMapper();
        String messageValue = "";
        try {
            messageValue = objectMapper.writeValueAsString(message);
        } catch(Exception e) {}

        System.out.println("[.] Enviando mensagem para ser salva");
        queueSender.send(messageValue);
    }

    public void delete(Long id){
        this.scheduleRepository.deleteById(id);
    }
}
