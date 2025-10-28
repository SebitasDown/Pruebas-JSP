package com.Huski.JSP.controller;

import com.Huski.JSP.model.Usuario;
import com.Huski.JSP.config.database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {


    @GetMapping
    public ResponseEntity<List<Usuario>> usuarios (Usuario usuario){
        return ResponseEntity.ok(database.usuarios);
    }

    @PostMapping
    public ResponseEntity<?> Register (@RequestBody Usuario usuario){
        for(Usuario u: database.usuarios){
            if (u.getCorreo().equalsIgnoreCase(usuario.getCorreo())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con ese correo ya existe");
            }
        }
        Long contador = (long) (database.usuarios.size() + 1);
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setId(contador);
        usuarioNuevo.setName(usuario.getName());
        usuarioNuevo.setCorreo(usuario.getCorreo());
        usuarioNuevo.setPassword(usuario.getPassword());
        database.usuarios.add(usuarioNuevo);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
    }


    @PostMapping("/login")
    public ResponseEntity<?> Login (@RequestBody Usuario login){
        for(Usuario u : database.usuarios){
            if(u.getCorreo().equalsIgnoreCase(login.getCorreo()) && u.getPassword().equalsIgnoreCase(login.getPassword())){
                return ResponseEntity.status(HttpStatus.OK).body("Login existoso");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales no validas");
    }
}
