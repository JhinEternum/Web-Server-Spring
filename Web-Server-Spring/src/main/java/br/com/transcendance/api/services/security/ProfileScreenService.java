package br.com.transcendance.api.services.security;

import java.util.Collection;

import br.com.transcendance.api.models.security.ProfileScreen;
import br.com.transcendance.api.models.security.Screen;
import br.com.transcendance.api.services.AbstractBaseService;

public interface ProfileScreenService extends AbstractBaseService<ProfileScreen, Long> {

	Collection<ProfileScreen> findByScreenId(Long screenId);

	Collection<ProfileScreen> findByProfileId(Long profileId);

	Collection<Screen> findScreenByProfileId(Long profileId);

	ProfileScreen findByProfileIdAndScreenId(Long profileId, Long screenId);

	Collection<ProfileScreen> saveScreensProfile(Long profileId, Collection<Screen> screens);

}
