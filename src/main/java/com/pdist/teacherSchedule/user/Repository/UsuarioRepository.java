package com.pdist.teacherSchedule.user.Repository;

import com.pdist.teacherSchedule.user.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
