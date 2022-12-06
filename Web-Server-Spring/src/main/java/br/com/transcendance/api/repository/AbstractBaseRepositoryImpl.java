package br.com.transcendance.api.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.AbstractBaseEntity;
import br.com.transcendance.api.services.AbstractBaseService;

@Service
@Transactional
public abstract class AbstractBaseRepositoryImpl<T extends AbstractBaseEntity, ID extends Serializable>
        implements AbstractBaseService<T, ID> {

    private AbstractBaseRepository<T, ID> abstractBaseRepository;

    @Autowired
    public AbstractBaseRepositoryImpl(AbstractBaseRepository<T, ID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }

    /*
     * @Override
     * public Collection<T> findByProdutorId(long produtorId) {
     * return abstractBaseRepository.findByProdutorId(produtorId);
     * }
     */

    @Override
    public List<T> saveAll(List<T> entity) {
        entity = abstractBaseRepository.saveAll(entity);
        // T entityFull = this.findById((ID)(Long)entity.getId());
        return entity;
    }

    @Override
    public T save(T entity) {
        entity = abstractBaseRepository.saveAndFlush(entity);
        // T entityFull = this.findById((ID)(Long)entity.getId());
        return entity;
    }

    @Override
    public List<T> findAll() {
        return abstractBaseRepository.findAll();
    }

    /*
     * @Override
     * public List<T> findAllOrderByIdDesc() {
     * // TODO Auto-generated method stub
     * return (List<T>) abstractBaseRepository.findAllOrderByIdDesc();
     * }
     */

    // @Override
    // public Page<T> findAll(Pageable pageable) {
    // return abstractBaseRepository.findAll(pageable);
    // }

    @Override
    public List<T> findByOrderByIdDesc() {
        // TODO Auto-generated method stub
        return abstractBaseRepository.findByOrderByIdDesc();
    }

    @Override
    public T findById(ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public T update(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if (optional.isPresent()) {
            return (T) abstractBaseRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public T inactive(ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if (optional.isPresent()) {
            optional.get().setActive(false);
            return (T) abstractBaseRepository.save(optional.get());
        } else {
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        abstractBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        abstractBaseRepository.deleteById(entityId);
    }

}