package br.com.transcendance.api.models.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;

import br.com.transcendance.api.models.AbstractBaseEntity;
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
public class Screen extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(unique = true)
	private String name;

	// @Column(unique=true)
	// private String _name;

	@PrePersist
	@PreUpdate
	private void formata() {
		this.name = ModelUtil.padronizaString(name);
		// this._name = ModelUtil.semAcento(name);

	}

}
