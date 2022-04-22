package com.pdist.teacherSchedule.message.Repository;

import com.pdist.teacherSchedule.message.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
