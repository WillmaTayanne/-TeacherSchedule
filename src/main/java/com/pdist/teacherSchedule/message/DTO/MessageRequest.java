package com.pdist.teacherSchedule.message.DTO;

import com.pdist.teacherSchedule.message.Model.Message;
import com.pdist.teacherSchedule.message.Model.Usuario;
import com.pdist.teacherSchedule.message.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private Long userIdOrigin;
    private Long userIdDestination;
    private String title;
    private String description;

    public Message toMessage(UsuarioRepository usuarioRepository) {
        Optional<Usuario> userOrigin = usuarioRepository.findById(userIdOrigin);
        Optional<Usuario> userDestination = usuarioRepository.findById(userIdDestination);
        if(userOrigin.isPresent() && userDestination.isPresent()) {
            return new Message(userOrigin.get(), userDestination.get(), title, description);
        } else return null;
    }
}
