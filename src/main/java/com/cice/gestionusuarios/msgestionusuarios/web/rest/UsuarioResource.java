package com.cice.gestionusuarios.msgestionusuarios.web.rest;

import com.cice.gestionusuarios.msgestionusuarios.service.IUsuariosService;
import com.cice.gestionusuarios.msgestionusuarios.web.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
public class UsuarioResource {

    @Autowired
    IUsuariosService usuariosService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Void> getStatus(){
        System.out.println("/status");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity getHealt() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario",method = RequestMethod.POST)
    public ResponseEntity<Void> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {

        log.info("Usuario recibido: {}", usuarioDTO.toString());
        UsuarioDTO result = usuariosService.crearUsuario(usuarioDTO.getUser(), usuarioDTO.getPass());
        String location = String.format("http://localhost:8089/usuario/%s", result.getIdUsuario());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(location));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/usuario/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> recuperarUsuarioPorId(@PathVariable Long idUsuario){
        System.out.println(idUsuario);
        return ResponseEntity.ok(usuariosService.getUsuario(1L));
    }

    @RequestMapping(value = "/usuario/{user}/{pass}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> recuperarUsuarioRegistrado(@PathVariable String user, @PathVariable String pass) {
        UsuarioDTO usuarioDTO = usuariosService.getUsuario(user, pass);
        return ResponseEntity.ok(usuarioDTO);
    }

    @RequestMapping(value = "/usuario/{idUsuario}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarUsuarioYTodosSusProductos(@PathVariable Long idUsuario){
        usuariosService.eliminarUsuario(idUsuario);
        return ResponseEntity.ok("Todo ha ido bien...");
    }

}
