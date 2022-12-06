package br.com.transcendance.api.models.security;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.transcendance.api.models.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfileScreen extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Profile profile;

	@OneToOne
	private Screen screen;

}
