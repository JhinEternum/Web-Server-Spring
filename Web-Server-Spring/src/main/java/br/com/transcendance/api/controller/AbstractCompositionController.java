package br.com.transcendance.api.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.transcendance.api.dto.AbstractDTO;
import br.com.transcendance.api.models.AbstractBaseEntity;
import br.com.transcendance.api.models.Result;
import br.com.transcendance.api.services.AbstractBaseService;
import br.com.transcendance.api.services.AbstractCompositionBaseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractCompositionController<T extends AbstractBaseEntity, ID extends Serializable>
		extends AbstractController<T, Long> {

	public AbstractCompositionController(AbstractBaseService<T, Long> service) {
		super(service);
	}

	private Logger logger = LoggerFactory.getLogger(AbstractCompositionController.class);

	private AbstractCompositionBaseService<T, Long> service;

	public AbstractCompositionController(AbstractCompositionBaseService<T, Long> service) {
		super(service);
		this.service = service;
	}

	@RequestMapping("/all/composition")
	public ResponseEntity<Result> findByCompositionId(@RequestBody AbstractDTO abstractDTO) {

		Result result = new Result();

		try {
			// log.info(LogUtil.formatMessageInfo(getMessageUtil().getInfoBuscarTodas()));

			Collection<T> c = service.findByCompositionId(abstractDTO.getId());

			// log.info(LogUtil.formatMessageInfo(getMessageUtil().getInfoBuscarTodasSucesso()));

			result.setMessage(getMessageUtil().getInfoBuscarTodasSucesso());
			result.setObject(c);
			result.setSuccess(true);

			return ResponseEntity.ok(result);

		} catch (Exception e) {
			throw new EntityNotFoundException();
		}

	}

}