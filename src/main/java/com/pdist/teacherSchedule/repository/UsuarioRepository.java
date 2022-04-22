package com.pdist.teacherSchedule.repository;

import com.pdist.teacherSchedule.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
