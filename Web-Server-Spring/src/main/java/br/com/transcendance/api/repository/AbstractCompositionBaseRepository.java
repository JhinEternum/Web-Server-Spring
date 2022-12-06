package br.com.transcendance.api.repository;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.repository.NoRepositoryBean;

import br.com.transcendance.api.models.AbstractBaseEntity;

@NoRepositoryBean
public interface AbstractCompositionBaseRepository<T, ID>
		extends AbstractBaseRepository<AbstractBaseEntity, Serializable> {

	Collection<T> findByCompositionId(Long compositionId);

}
