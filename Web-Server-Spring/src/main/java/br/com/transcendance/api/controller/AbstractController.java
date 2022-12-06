package br.com.transcendance.api.controller;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.transcendance.api.exception.CRUDDeleteException;
import br.com.transcendance.api.exception.CRUDInactiveException;
import br.com.transcendance.api.exception.CRUDSaveException;
import br.com.transcendance.api.exception.CRUDUpdateException;
import br.com.transcendance.api.exception.FindAllException;
import br.com.transcendance.api.exception.RegrasNegocioException;
import br.com.transcendance.api.exception.ValidacaoException;
import br.com.transcendance.api.models.AbstractBaseEntity;
import br.com.transcendance.api.models.Result;
import br.com.transcendance.api.services.AbstractBaseService;
import br.com.transcendance.api.util.MessageUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@PropertySource("classpath:messages.properties")
@Slf4j
@Data
public abstract class AbstractController<T extends AbstractBaseEntity, ID extends Serializable> {

	@Autowired
	private Environment env;

	@Autowired
	private MessageUtil messageUtil;

	private AbstractBaseService<T, Long> service;

	public AbstractController(AbstractBaseService<T, Long> service) {
		this.service = service;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Result> save(@Valid @RequestBody T t) {

		Result result = new Result();

		try {
			service.validaColunaUnica(t);
			T created = service.save(t);

			result.setObject(created);
			result.setMessage(messageUtil.getInfoSalvarSucesso());
			result.setSuccess(true);

			return ResponseEntity.ok(result);
		}

		catch (ValidacaoException e) {
			throw new ValidacaoException(e);
		}

		catch (RegrasNegocioException e) {
			throw new RegrasNegocioException(e);
		}

		catch (DataIntegrityViolationException e) {
			throw new ValidacaoException(e);
		}

		catch (Exception e) {
			throw new CRUDSaveException(e);
		}

	}

	@GetMapping("/all")
	public ResponseEntity<Result> findAll(@RequestHeader HttpHeaders headers, HttpServletRequest request) {

		Result result = new Result();

		try {
			List<T> list = service.findByOrderByIdDesc();

			result.setObject(list);
			result.setMessage(messageUtil.getInfoBuscarTodasSucesso());
			result.setSuccess(true);

			return ResponseEntity.ok(result);
		} catch (RegrasNegocioException e) {
			throw new RegrasNegocioException(e);
		} catch (Exception e) {
			throw new FindAllException();
		}
	}

	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public ResponseEntity<Result> buscar(@RequestBody T t) {

		Result result = new Result();

		try {
			T created = service.findById(t.getId());

			result.setObject(created);
			result.setMessage(messageUtil.getInfoBuscarSucesso());
			result.setSuccess(true);

			if (created != null) {
				return ResponseEntity.ok(result);
			} else {
				throw new EntityNotFoundException();
			}
		} catch (RegrasNegocioException e) {
			throw new RegrasNegocioException(e);
		} catch (Exception e) {
			throw new EntityNotFoundException();
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Result> atualizar(@RequestBody T t) {

		Result result = new Result();

		try {
			service.validaColunaUnica(t);
			T created = service.updateById(t, t.getId());
			created = service.findById(created.getId());

			result.setObject(created);
			result.setMessage(messageUtil.getInfoAlterarSucesso());
			result.setSuccess(true);

			return ResponseEntity.ok(result);
		} catch (ValidacaoException e) {
			throw new ValidacaoException(e);
		} catch (DataIntegrityViolationException e) {
			throw new ValidacaoException(e);
		} catch (RegrasNegocioException e) {
			throw new RegrasNegocioException(e);
		} catch (Exception e) {
			throw new CRUDUpdateException(e);
		}

	}

	@RequestMapping(value = "/inactive", method = RequestMethod.POST)
	public ResponseEntity<Result> inativar(@RequestBody T t) {

		Result result = new Result();

		try {
			T created = service.inactive(t.getId());

			result.setObject(created);
			result.setMessage(messageUtil.getInfoInativarSucesso());
			result.setSuccess(true);

			return ResponseEntity.ok(result);
		} catch (RegrasNegocioException e) {
			throw new RegrasNegocioException(e);
		} catch (Exception e) {
			throw new CRUDInactiveException(e);
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Result> deletar(@RequestBody T t) {

		Result result = new Result();

		try {
			T entity = service.findById(t.getId());
			service.deleteById(t.getId());

			result.setMessage(messageUtil.getInfoDeletarSucesso());
			result.setSuccess(true);
			result.setObject(entity);

			return ResponseEntity.ok(result);
		} catch (DataIntegrityViolationException e) {
			throw new RegrasNegocioException(messageUtil.getErrorDataIntegrityViolationException());
		} catch (RegrasNegocioException e) {
			throw new RegrasNegocioException(e);
		} catch (Exception e) {
			throw new CRUDDeleteException(e);
		}

	}

	@GetMapping("/page")
	public ResponseEntity<Result> findAll(Pageable pageable) {

		Result result = new Result();

		try {
			Page<T> list = service.findAll(pageable);

			result.setObject(list);
			result.setMessage(messageUtil.getInfoBuscarTodasSucesso());
			result.setSuccess(true);

			return ResponseEntity.ok(result);

		} catch (RegrasNegocioException e) {
			throw new RegrasNegocioException(e);
		} catch (Exception e) {
			throw new FindAllException();
		}
	}

	@RequestMapping(value = "/inactive/{id}", method = RequestMethod.GET)
	public ResponseEntity<Result> get(@PathVariable long id) {

		Result result = new Result();

		try {
			T created = service.inactive(id);

			result.setObject(created);
			result.setMessage(messageUtil.getInfoInativarSucesso());
			result.setSuccess(true);

			return ResponseEntity.ok(result);

		} catch (RegrasNegocioException e) {
			throw new RegrasNegocioException(e);
		} catch (Exception e) {
			throw new CRUDInactiveException();
		}
	}

}