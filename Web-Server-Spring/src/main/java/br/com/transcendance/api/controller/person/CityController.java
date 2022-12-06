package br.com.transcendance.api.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.models.person.City;
import br.com.transcendance.api.services.person.CityService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/person/city")
public class CityController extends AbstractController<City, Long> {
    private CityService service;

    @Autowired
    public CityController(CityService service) {
        super(service);
        this.service = service;
    }

}
