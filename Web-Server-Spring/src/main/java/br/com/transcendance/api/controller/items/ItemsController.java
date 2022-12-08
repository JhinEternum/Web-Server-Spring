package br.com.transcendance.api.controller.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.models.items.Items;
import br.com.transcendance.api.services.items.ItemsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/items")
public class ItemsController extends AbstractController<Items, Long> {
    private ItemsService service;

    @Autowired
    public ItemsController(ItemsService service) {
        super(service);
        this.service = service;
    }

}
