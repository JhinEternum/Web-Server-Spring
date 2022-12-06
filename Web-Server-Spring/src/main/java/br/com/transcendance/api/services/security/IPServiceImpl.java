package br.com.transcendance.api.services.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.security.IP;
import br.com.transcendance.api.models.security.User;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.secutity.IPRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class IPServiceImpl extends AbstractBaseRepositoryImpl<IP, Long>
		implements IPService {

	private IPRepository myDomainRepository;

	public IPServiceImpl(IPRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	public String getIPFromHeader(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		if (ip == null || ip.isEmpty()) {
			return null;
		}
		System.out.println("IP:" + ip);
		return ip;
	}

	public boolean ipAutorizado(String ipFront, User usuario) {
		System.out.println("ipFront:" + ipFront);
		System.out.println("usuario:" + usuario);
		for (IP ip : usuario.getIps()) {
			if (ip.getIp().equals(ipFront)) {
				System.out.println("IP Autorizado :" + ip.getIp() + " " + ipFront);
				return true;
			}
		}
		return false;
	}

	@Override
	public void validaColunaUnica(IP entity) {
		Collection<IP> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getIp(), i.getIp());
		});

	}

	@Override
	public Page<IP> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
