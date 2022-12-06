package br.com.transcendance.api.repository.secutity;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.security.Route;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface RouteRepository extends AbstractBaseRepository<Route, Long> {

}
