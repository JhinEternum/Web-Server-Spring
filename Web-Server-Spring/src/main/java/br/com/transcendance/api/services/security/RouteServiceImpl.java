package br.com.transcendance.api.services.security;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.security.Route;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.secutity.RouteRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class RouteServiceImpl extends AbstractBaseRepositoryImpl<Route, Long>
        implements RouteService {

    private RouteRepository myDomainRepository;

    // @Autowired
    // private EnderecoService enderecoService;

    // @Autowired
    // private PessoaService pessoaService;

    public RouteServiceImpl(RouteRepository myDomainRepository) {
        super(myDomainRepository);
        this.myDomainRepository = myDomainRepository;
    }

    @Override
    public void validaColunaUnica(Route entity) {
        Collection<Route> collection = this.findAll();

        collection.stream().forEach(i -> {
            ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
        });

    }

    @Override
    public Page<Route> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }
}
