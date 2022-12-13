package br.com.transcendance.api.controller.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.models.character.CharacterLevel;
import br.com.transcendance.api.services.character.CharacterLevelService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/character/level")
public class CharacterLevelController extends AbstractController<CharacterLevel, Long> {
    private CharacterLevelService service;

    @Autowired
    public CharacterLevelController(CharacterLevelService service) {
        super(service);
        this.service = service;
    }

}
