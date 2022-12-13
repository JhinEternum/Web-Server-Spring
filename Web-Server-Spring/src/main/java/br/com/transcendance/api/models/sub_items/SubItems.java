package br.com.transcendance.api.models.sub_items;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;

import br.com.transcendance.api.models.AbstractBaseEntity;
import br.com.transcendance.api.models.items.Items;
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
public class SubItems extends AbstractBaseEntity {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String name;

    private Double money;

    @ManyToOne
    @JoinColumn(name = "items_id", nullable = false)
    private Items items;

    // @PrePersist
    // @PreUpdate
    // private void formata() {
    // this.name = ModelUtil.padronizaString(name);
    // }
}