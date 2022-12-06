package br.com.transcendance.api.services;

import java.io.Serializable;
import java.util.Collection;

import br.com.transcendance.api.models.AbstractBaseEntity;

public interface AbstractCompositionBaseService<T extends AbstractBaseEntity, ID extends Serializable>
      extends AbstractBaseService<T, Long> {

   public abstract Collection<T> findByCompositionId(Long compositionId);
}
