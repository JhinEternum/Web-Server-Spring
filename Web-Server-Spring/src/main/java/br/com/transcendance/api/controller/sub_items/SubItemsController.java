package br.com.transcendance.api.controller.sub_items;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.dto.AbstractDTO;
import br.com.transcendance.api.log.LogUtil;
import br.com.transcendance.api.models.Result;
import br.com.transcendance.api.models.sub_items.SubItems;
import br.com.transcendance.api.services.sub_items.SubItemsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/subItems")
public class SubItemsController extends AbstractController<SubItems, Long> {
    private SubItemsService service;

    @Autowired
    public SubItemsController(SubItemsService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping(value = "/findByItems", method = RequestMethod.POST)
    public ResponseEntity<Result> findByItemsId(@Valid @RequestBody AbstractDTO t) {

        Result result = new Result();

        try {
            log.info(LogUtil.formatMessageInfo("Searching for Sub Items by Items"));

            Collection<SubItems> list = service.findByItemsId(t.getId());

            log.info(LogUtil
                    .formatMessageInfo("Searching for Sub Items by Items success"));

            result.setMessage("Searching for Sub Items by Items success");
            result.setObject(list);
            result.setSuccess(true);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

}
