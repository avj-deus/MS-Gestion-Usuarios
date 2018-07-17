package com.cice.gestionusuarios.msgestionusuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "user")
    private String user;

    @Column(name = "pass")
    private String pass;

}
