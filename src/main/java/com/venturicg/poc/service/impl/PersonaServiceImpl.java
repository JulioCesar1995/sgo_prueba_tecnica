package com.venturicg.poc.service.impl;

import com.venturicg.poc.repository.PersonaDAO;
import com.venturicg.poc.service.PersonaService;
import com.venturicg.poc.service.model.Persona;
import com.venturicg.poc.web.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDAO personaDAO;

    @Override
    public List<Persona> obtenerPersonas() {
        return personaDAO.obtenerPersonas();
    }

    @Override
    public void insertPersona(PersonaDTO personaDTO) {
        personaDAO.insertPersona(personaDTO);
    }

    @Override
    public void updatePersona(PersonaDTO personaDTO) {
        personaDAO.updatePersona(personaDTO);
    }

    @Override
    public void deletePersona(long id) {
        personaDAO.deletePersona(id);
    }

}