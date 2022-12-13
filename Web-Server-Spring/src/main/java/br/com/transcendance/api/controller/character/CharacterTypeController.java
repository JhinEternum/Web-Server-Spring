package br.com.transcendance.api.controller.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.models.character.CharacterType;
import br.com.transcendance.api.services.character.CharacterTypeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/character/type")
public class CharacterTypeController extends AbstractController<CharacterType, Long> {
    private CharacterTypeService service;

    @Autowired
    public CharacterTypeController(CharacterTypeService service) {
        super(service);
        this.service = service;
    }

}
