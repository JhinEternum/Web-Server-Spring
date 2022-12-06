package br.com.transcendance.api.services.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.security.Profile;
import br.com.transcendance.api.models.security.ProfileScreen;
import br.com.transcendance.api.models.security.Screen;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.secutity.ProfileScreenRepository;

@Service
@Transactional
public class ProfileScreenServiceImpl extends AbstractBaseRepositoryImpl<ProfileScreen, Long>
		implements ProfileScreenService {

	private ProfileScreenRepository myDomainRepository;

	@Autowired
	private ProfileService profileService;

	public ProfileScreenServiceImpl(ProfileScreenRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	@Override
	public Collection<ProfileScreen> findByScreenId(Long screenId) {
		return myDomainRepository.findByScreenId(screenId);
	}

	@Override
	public Collection<ProfileScreen> findByProfileId(Long profileId) {
		return myDomainRepository.findByProfileId(profileId);
	}

	@Override
	public ProfileScreen findByProfileIdAndScreenId(Long profileId, Long ScreenId) {
		return myDomainRepository.findByProfileIdAndScreenId(profileId, ScreenId);
	}

	@Override
	public Collection<Screen> findScreenByProfileId(Long profileId) {
		List<Screen> screens = new ArrayList<Screen>();
		Collection<ProfileScreen> c = myDomainRepository.findByProfileId(profileId);
		c.stream().forEach(pt -> {
			screens.add(pt.getScreen());
		});

		return screens;
	}

	@Override
	public Collection<ProfileScreen> saveScreensProfile(Long profileId, Collection<Screen> screens) {

		/*
		 * screens.stream().forEach(screen->{
		 * ProfileScreen profileScreen = this.findByProfileIdAndScreenId(profileId,
		 * screen.getId());
		 * if(profileScreen == null) {
		 * this.save(profileScreen);
		 * }
		 * });
		 */

		// Boolean novaScreen = new Boolean(true);

		List<ProfileScreen> listProfileScreen = new ArrayList<ProfileScreen>();

		Collection<ProfileScreen> profileScreenBD = this.findByProfileId(profileId);

		// Para cada screen que existe no banco, mas que não tem na lista enviada,
		// deleta do banco.
		profileScreenBD.stream().forEach(screenBD -> {

			ProfileScreen profileScreenControle1 = new ProfileScreen();

			profileScreenControle1.setId(screenBD.getId());

			screens.stream().forEach(screen -> {

				if (screen.getId() == screenBD.getScreen().getId()) {
					profileScreenControle1.setId(-1);
				}

			});

			if (profileScreenControle1.getId() != -1) {
				this.deleteById(profileScreenControle1.getId());
			}

		});

		// Para cada screen que existe na lista enviada e não tem no banco, salva no
		// banco.
		screens.stream().forEach(screen -> {

			ProfileScreen profileScreenControle2 = new ProfileScreen();

			profileScreenControle2.setScreen(screen);

			profileScreenBD.stream().forEach(screenBD -> {

				if (screen.getId() == screenBD.getScreen().getId()) {
					profileScreenControle2.setScreen(null);
				}

			});

			if (profileScreenControle2.getScreen() != null) {
				Profile p = new Profile();
				p.setId(profileId);
				profileScreenControle2.setProfile(p);
				listProfileScreen.add(profileScreenControle2);
			}

		});

		if (!listProfileScreen.isEmpty()) {
			this.saveAll(listProfileScreen);
		}

		// TODO Auto-generated method stub
		return findByProfileId(profileId);
	}

	@Override
	public void validaColunaUnica(ProfileScreen entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<ProfileScreen> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
