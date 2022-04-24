package com.pdist.teacherSchedule.controller;

import com.pdist.teacherSchedule.model.Login;
import com.pdist.teacherSchedule.model.Usuario;
import com.pdist.teacherSchedule.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public Usuario login(@RequestBody Login login) {
        return this.usuarioService.login(login);
    }

    @GetMapping("/user")
    public List<Usuario> read(){
        return this.usuarioService.read();
    }

    @GetMapping("/user/{id}")
    public Usuario readById(@PathVariable("id") Long id){
        return this.usuarioService.readById(id);
    }

    @PostMapping("/user")
    public Usuario create(@RequestBody Usuario usuario){
        return this.usuarioService.create(usuario);
    }

    @PutMapping("/user/{id}")
    public Usuario update(@RequestBody Usuario usuario){
        return this.usuarioService.update(usuario);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") Long id){
        this.usuarioService.delete(id);
    }
}
