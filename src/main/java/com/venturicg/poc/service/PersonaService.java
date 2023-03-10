package com.venturicg.poc.service;

import com.venturicg.poc.service.model.Persona;
import com.venturicg.poc.web.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {

    List<Persona> obtenerPersonas();

    void insertPersona(PersonaDTO personaDTO);

    void updatePersona(PersonaDTO personaDTO);

    void deletePersona(long id);
}
