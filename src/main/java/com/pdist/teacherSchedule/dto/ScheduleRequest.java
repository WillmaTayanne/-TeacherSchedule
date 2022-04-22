package com.pdist.teacherSchedule.dto;

import com.pdist.teacherSchedule.model.Schedule;
import com.pdist.teacherSchedule.model.Usuario;
import com.pdist.teacherSchedule.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequest {
    private String subject;
    private Long idTeacher;
    private Timestamp dateTimeBegin;
    private Timestamp dateTimeEnd;
    private String description;

    public Schedule toSchedule(UsuarioRepository usuarioRepository) {
        Optional<Usuario> teacher = usuarioRepository.findById(idTeacher);
        return teacher.map(usuario -> new Schedule(subject, usuario, dateTimeBegin, dateTimeEnd, description)).orElse(null);
    }
}
