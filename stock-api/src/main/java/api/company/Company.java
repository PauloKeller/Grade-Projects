package api.company;

import api.enums.CompanyType;
import api.utils.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "companies")
public class Company extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(max = 14)
    @Column(unique = true)
    private String cnpj;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    public Company() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", companyType=" + companyType + "]";
    }
}