package com.Huski.JSP.service;

import com.Huski.JSP.config.database;
import com.Huski.JSP.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    public List<Usuario> listarUsuarios() {
        return database.usuarios;
    }

    public Usuario crearUsuario(Usuario usuario) {
        database.usuarios.add(usuario);
        return usuario;
    }

    public boolean validarCredenciales(String correo, String password) {
        for (Usuario usuario : database.usuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
