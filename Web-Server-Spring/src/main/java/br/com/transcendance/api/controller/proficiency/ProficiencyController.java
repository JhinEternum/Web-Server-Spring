package br.com.transcendance.api.controller.proficiency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.models.proficiency.Proficiency;
import br.com.transcendance.api.services.proficiency.ProficiencyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/proficiency")
public class ProficiencyController extends AbstractController<Proficiency, Long> {
    private ProficiencyService service;

    @Autowired
    public ProficiencyController(ProficiencyService service) {
        super(service);
        this.service = service;
    }

}
