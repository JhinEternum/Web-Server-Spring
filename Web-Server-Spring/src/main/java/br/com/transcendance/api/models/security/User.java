package br.com.transcendance.api.models.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.transcendance.api.models.AbstractBaseEntity;
import br.com.transcendance.api.models.person.Person;
import br.com.transcendance.api.util.ModelUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "\"user\"") // Tive que usar assim porque a palavra user é uma palavra chave do postgres
public class User extends AbstractBaseEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(unique = true)
	private String userName;

	@OneToOne
	private Person person;

	private String pass;

	private boolean validateIp;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Profile> profiles;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<IP> ips;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.profiles;
	}

	@Override
	public String getPassword() {
		return this.pass;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@PrePersist
	@PreUpdate
	private void formata() {
		this.userName = ModelUtil.padronizaString(userName);
		// this._userName = ModelUtil.semAcento(userName);
	}

}
