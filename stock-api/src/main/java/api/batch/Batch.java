package api.batch;

import api.stock.Stock;
import api.utils.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "batches")
public class Batch extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    private String description;

    @NotNull
    private int units;

    @NotNull
    private Date manufactureDate;

    @NotNull
    private Date expirationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stock_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Stock stock;

    public Batch() {

    }

    public Batch(
            @Size(max = 100) String description,
            @NotNull int units,
            @NotNull Date manufactureDate,
            @NotNull Date expirationDate,
            Stock stock
    ) {
        this.description = description;
        this.units = units;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product [ " +
                "id=" + id +
                ", description=" + description +
                ", units=" + units +
                ", manufactureDate=" + manufactureDate +
                ", expirationDate=" + expirationDate +
                "]";
    }
}
