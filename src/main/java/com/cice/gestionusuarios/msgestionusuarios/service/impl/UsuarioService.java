package com.cice.gestionusuarios.msgestionusuarios.service.impl;

import com.cice.gestionusuarios.msgestionusuarios.entity.UsuarioEntity;
import com.cice.gestionusuarios.msgestionusuarios.feign.IProductoFeign;
import com.cice.gestionusuarios.msgestionusuarios.repository.IUsuarioRepository;
import com.cice.gestionusuarios.msgestionusuarios.service.IUsuariosService;
import com.cice.gestionusuarios.msgestionusuarios.web.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuariosService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IProductoFeign productoFeign;

    @Override
    public UsuarioDTO crearUsuario(String user, String pass) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(null, user, pass);
        UsuarioEntity result = usuarioRepository.save(usuarioEntity);

        return new UsuarioDTO(result.getIdUsuario(), result.getUser(), result.getPass());
    }

    @Override
    public List<UsuarioDTO> getListaUsuarios() {
        return null;
    }

    @Override
    public UsuarioDTO getUsuario(String user, String pass) {
        UsuarioEntity usuarioEntity = usuarioRepository.findUsuarioEntityByUserAndPass(user, pass);
        return new UsuarioDTO(usuarioEntity.getIdUsuario(), usuarioEntity.getUser(), usuarioEntity.getPass());
    }

    @Override
    public UsuarioDTO getUsuario(Long idUsuario) {
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(idUsuario);
        UsuarioDTO usuarioDTO = null;
        if(usuarioEntityOptional.isPresent()){
            usuarioDTO = new UsuarioDTO(
                    usuarioEntityOptional.get().getIdUsuario(),
                    usuarioEntityOptional.get().getUser(),
                    usuarioEntityOptional.get().getPass()
            );
        }
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioActualizado) {
        return null;
    }

    @Override
    public UsuarioDTO eliminarUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
        productoFeign.eliminarProductoByIdUsuario(idUsuario);
        return null;
    }
}
