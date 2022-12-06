package br.com.transcendance.api.models.person;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Person extends AbstractBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL)
    private Phone phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Email email;

    @OneToOne(cascade = CascadeType.ALL)
    private Uf uf;

    @OneToOne(cascade = CascadeType.ALL)
    private City city;
}