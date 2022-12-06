package br.com.transcendance.api.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.models.person.Uf;
import br.com.transcendance.api.services.person.UfService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/person/uf")
public class UfController extends AbstractController<Uf, Long> {
    private UfService service;

    @Autowired
    public UfController(UfService service) {
        super(service);
        this.service = service;
    }

}
