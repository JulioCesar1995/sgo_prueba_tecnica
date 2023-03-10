package com.venturicg.poc.repository;

import com.venturicg.poc.service.model.Pais;
import com.venturicg.poc.service.model.Persona;
import com.venturicg.poc.web.dto.PersonaDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonaDAO extends PaisDAO {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nombres", column = "nombres"),
            @Result(property = "apellidos", column = "apellidos"),
            @Result(property="pais", javaType=Pais.class, column="idPais", one=@One(select="obtenerPaiseFromID"))
    })
    @Select("SELECT * FROM persona")
    List<Persona> obtenerPersonas();

    @Insert("INSERT INTO persona(nombres, apellidos, idPais) VALUES(#{nombres}, #{apellidos}, #{pais.id})")
    void insertPersona(PersonaDTO personaDTO);

    @Update("UPDATE persona set nombres=#{nombres}, apellidos=#{apellidos}, idPais=#{pais.id} WHERE id=#{id}")
    void updatePersona(PersonaDTO personaDTO);

    @Delete("DELETE FROM persona WHERE id=#{id}")
    void deletePersona(long id);
}
