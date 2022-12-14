package br.com.transcendance.api.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.transcendance.api.models.AbstractBaseEntity;

public interface AbstractBaseService<T extends AbstractBaseEntity, ID extends Serializable> {
    public abstract List<T> saveAll(List<T> entity);

    public abstract T save(T entity);

    public abstract List<T> findAll();

    List<T> findByOrderByIdDesc();

    public abstract Page<T> findAll(Pageable pageable);

    public abstract T findById(ID entityId);

    public abstract T update(T entity);

    public abstract T updateById(T entity, ID entityId);

    public abstract T inactive(ID entityId);

    public abstract void delete(T entity);

    public abstract void deleteById(ID entityId);

    public abstract void validaColunaUnica(T entity);
}