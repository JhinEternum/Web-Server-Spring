package br.com.transcendance.api.repository;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.AbstractBaseEntity;
import br.com.transcendance.api.services.AbstractCompositionBaseService;

@Service
@Transactional
public abstract class AbstractCompositionBaseRepositoryImpl<T extends AbstractBaseEntity, ID extends Serializable>
        implements AbstractCompositionBaseService<T, ID> {

    private AbstractCompositionBaseRepository<T, ID> abstractCompositionBaseRepository;

    @Autowired
    public AbstractCompositionBaseRepositoryImpl(AbstractCompositionBaseRepository<T, ID> abstractBaseRepository) {
        this.abstractCompositionBaseRepository = abstractBaseRepository;
    }

    @Override
    public Collection<T> findByCompositionId(Long compositionId) {
        return abstractCompositionBaseRepository.findByCompositionId(compositionId);
    }

    /*
     * @Override
     * public Collection<T> findByProdutorIdAndDescricaoIgnoreCase(Long produtorId,
     * String descricao) {
     * return
     * abstractBaseRepository.findByProdutorIdAndDescricaoIgnoreCase(produtorId,
     * descricao);
     * }
     */

}