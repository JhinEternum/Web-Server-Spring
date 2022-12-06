package br.com.transcendance.api.models.person;

import java.io.Serializable;

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
public class Phone extends AbstractBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

}