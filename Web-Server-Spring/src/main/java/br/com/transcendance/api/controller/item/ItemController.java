package br.com.transcendance.api.controller.item;

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
import br.com.transcendance.api.models.item.Item;
import br.com.transcendance.api.services.item.ItemService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/item")
public class ItemController extends AbstractController<Item, Long> {
    private ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping(value = "/findByCharacter", method = RequestMethod.POST)
    public ResponseEntity<Result> findByFuncionarioCarteiraTrabalhoId(@Valid @RequestBody AbstractDTO t) {

        Result resultado = new Result();

        try {
            log.info(LogUtil.formatMessageInfo("Searching for Item by Character"));

            Collection<Item> items = service.findByCharacterId(t.getId());

            log.info(LogUtil
                    .formatMessageInfo("Buscando lista de Carteira de Trabalho por Funcionario realizada com sucesso"));

            resultado.setMessage("Buscando lista de Carteira de Trabalho por Funcionario realizada com sucesso");
            resultado.setObject(items);
            resultado.setSuccess(true);

            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

}
