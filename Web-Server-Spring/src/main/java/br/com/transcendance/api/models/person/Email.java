package br.com.transcendance.api.models.person;

import javax.persistence.Entity;

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
public class Email extends AbstractBaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;

}