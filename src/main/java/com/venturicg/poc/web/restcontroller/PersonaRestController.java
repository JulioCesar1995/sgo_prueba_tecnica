package com.venturicg.poc.web.restcontroller;

import com.venturicg.poc.service.PersonaService;
import com.venturicg.poc.service.model.Respuesta;
import com.venturicg.poc.web.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/persona")
public class PersonaRestController {

    @Autowired
    private PersonaService personasService;

    @GetMapping
    public List<PersonaDTO> obtenerPersonas() {
        return personasService.obtenerPersonas().stream()
                .map(p -> new PersonaDTO(p.getId(), p.getNombres(), p.getApellidos(), p.getPais()))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Respuesta insertarPersona(@RequestBody PersonaDTO personaDTO) {
        personasService.insertPersona(personaDTO);
        return Respuesta.respuestaExitosa();
    }

    @PutMapping
    public Respuesta updatePersona(@RequestBody PersonaDTO personaDTO) {
        personasService.updatePersona(personaDTO);
        return Respuesta.respuestaExitosa();
    }

    @DeleteMapping("/{id}")
    public Respuesta detelePersona(@PathVariable long id) {
        personasService.deletePersona(id);
        return Respuesta.respuestaExitosa();
    }
}
