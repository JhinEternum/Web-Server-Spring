package br.com.transcendance.api.repository.proficiency;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.proficiency.Proficiency;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface ProficiencyRepository extends AbstractBaseRepository<Proficiency, Long> {

}
