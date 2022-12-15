package br.com.transcendance.api.models.character;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import br.com.transcendance.api.models.AbstractBaseEntity;
import br.com.transcendance.api.models.proficiency.Proficiency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CharacterProficiency extends AbstractBaseEntity {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String proficiencyLevel;

    @NotEmpty
    private String proficiencyRank;

    @OneToOne
    private Proficiency proficiency;

    @OneToOne
    private Character character;

}