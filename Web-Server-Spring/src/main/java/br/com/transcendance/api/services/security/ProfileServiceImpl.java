package br.com.transcendance.api.services.security;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.security.Profile;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.secutity.ProfileRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class ProfileServiceImpl extends AbstractBaseRepositoryImpl<Profile, Long>
        implements ProfileService {

    private ProfileRepository myDomainRepository;

    public ProfileServiceImpl(ProfileRepository myDomainRepository) {
        super(myDomainRepository);
        this.myDomainRepository = myDomainRepository;
    }

    @Override
    public void validaColunaUnica(Profile entity) {
        Collection<Profile> collection = this.findAll();

        collection.stream().forEach(i -> {
            ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
        });

    }

    @Override
    public Page<Profile> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }
}
