package api.stock;

import api.store.Store;
import api.utils.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stocks")
public class Stock extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "stocks")
    private Set<Store> stores = new HashSet<>();

    public Stock() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public String getName() {
        return name;
    }

    public Set<Store> getStores() {
        return stores;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", name=" + name + ", stores=" + stores + "]";
    }
}
