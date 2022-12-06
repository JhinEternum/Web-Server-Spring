package br.com.transcendance.api.models.security;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;

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
public class Profile extends AbstractBaseEntity implements Serializable, GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

    @Override
    public String getAuthority() {
        return this.name;
    }

    @PrePersist
    @PreUpdate
    private void formata() {
        this.name = ModelUtil.padronizaString(name);
    }
}