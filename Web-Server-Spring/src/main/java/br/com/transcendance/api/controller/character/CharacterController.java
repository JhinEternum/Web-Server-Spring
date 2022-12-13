package br.com.transcendance.api.controller.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.models.character.Character;
import br.com.transcendance.api.services.character.CharacterService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/character")
public class CharacterController extends AbstractController<Character, Long> {
    private CharacterService service;

    @Autowired
    public CharacterController(CharacterService service) {
        super(service);
        this.service = service;
    }

}
