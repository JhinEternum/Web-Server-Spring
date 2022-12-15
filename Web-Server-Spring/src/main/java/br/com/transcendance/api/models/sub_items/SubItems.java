package br.com.transcendance.api.models.sub_items;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import br.com.transcendance.api.models.AbstractBaseEntity;
import br.com.transcendance.api.models.item.Item;
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
    private Item items;

    // @PrePersist
    // @PreUpdate
    // private void formata() {
    // this.name = ModelUtil.padronizaString(name);
    // }
}