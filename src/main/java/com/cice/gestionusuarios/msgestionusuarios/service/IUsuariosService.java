package com.cice.gestionusuarios.msgestionusuarios.service;

import com.cice.gestionusuarios.msgestionusuarios.web.dto.UsuarioDTO;

import java.util.List;

public interface IUsuariosService {

    /**
     * Metodo para crear un usuario en la base de datos
     * @param user
     * @param pass
     * @return
     */
    UsuarioDTO crearUsuario(String user, String pass);

    /**
     * Metodo que devuelve la lista de usuarios de la BD
     * @return
     */
    List<UsuarioDTO> getListaUsuarios();

    /**
     * Metodo que devuelve un usuario dado su user y pass
     * @param user
     * @param pass
     * @return
     */
    UsuarioDTO getUsuario(String user, String pass);

    /**
     * Metodo que devuelve un usuario dado su id
     * @param idUsuario
     * @return
     */
    UsuarioDTO getUsuario(Long idUsuario);

    /**
     * Metodo que actualiza un usuario dado
     * @param usuarioActualizado
     * @return
     */
    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioActualizado);

    /**
     * Metodo que elimina un usuario dado y detona la eliminación de todos
     * sus datos llamando a otros servicios dependientes.
     * @param idUsuario
     * @return
     */
    UsuarioDTO eliminarUsuario(Long idUsuario);

}
