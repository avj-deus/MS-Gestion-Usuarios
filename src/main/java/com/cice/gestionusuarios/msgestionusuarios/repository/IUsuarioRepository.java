package com.cice.gestionusuarios.msgestionusuarios.repository;

import com.cice.gestionusuarios.msgestionusuarios.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query(value = "SELECT * FROM usuario WHERE user = :user AND pass = :pass", nativeQuery = true)
    UsuarioEntity findUsuarioEntityByUserAndPass(@Param("user") String user, @Param("pass") String pass);

}
