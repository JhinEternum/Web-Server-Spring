package br.com.transcendance.api.services.security;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.security.Screen;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.secutity.ScreenRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class ScreenServiceImpl extends AbstractBaseRepositoryImpl<Screen, Long>
        implements ScreenService {

    private ScreenRepository myDomainRepository;

    public ScreenServiceImpl(ScreenRepository myDomainRepository) {
        super(myDomainRepository);
        this.myDomainRepository = myDomainRepository;
    }

    @Override
    public Screen findByName(String name) {
        // TODO Auto-generated method stub
        return myDomainRepository.findByName(name);
    }

    @Override
    public void validaColunaUnica(Screen entity) {
        Collection<Screen> collection = this.findAll();

        collection.stream().forEach(i -> {
            ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
        });

    }

    @Override
    public Page<Screen> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

}
