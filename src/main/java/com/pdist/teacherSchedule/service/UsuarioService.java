package com.pdist.teacherSchedule.service;

import com.pdist.teacherSchedule.model.Login;
import com.pdist.teacherSchedule.model.Usuario;
import com.pdist.teacherSchedule.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(Login login) {
        List<Usuario> users = this.read();
        List<Usuario> filterUsers = users.stream().filter(user -> user.getRegistration().equals(login.getRegistration()) &&
                user.getPassword().equals(login.getPassword())).toList();
        return filterUsers.size() > 0 ? filterUsers.get(0) : null;
    }

    public List<Usuario> read() {
        return this.usuarioRepository.findAll();
    }

    public Usuario readById(Long id){
        return this.usuarioRepository.findById(id).orElse(null);
    }

    @Transactional
    public Usuario create(Usuario usuario) {
        List<Usuario> users = this.read();
        List<Usuario> filterUsers = users.stream().filter(user -> user.getRegistration().equals(usuario.getRegistration()) &&
                user.getEmail().equals(usuario.getEmail()) && user.getCpf().equals(usuario.getCpf())).toList();
        return filterUsers.size() == 0 ? this.usuarioRepository.save(usuario) : null;
    }

    @Transactional
    public Usuario update(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public void delete(Long id){
        this.usuarioRepository.deleteById(id);
    }
}
