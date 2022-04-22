package com.pdist.teacherSchedule.schedule.Repository;

import com.pdist.teacherSchedule.schedule.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
