package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @Column(name="name")
    private String name;

    @Column(name="wealth")
    private int wealth;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    private List<Warehouse> warehouses;

    public Company() {
    }

    public Company(String name, int wealth) {
        this.name = name;
        this.wealth = wealth;
    }

    public int getCompanyId() {
        return companyId;
    }
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getWealth() {
        return wealth;
    }
    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }
    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", wealth=" + wealth +
                ", warehouses=" + warehouses +
                '}';
    }
}
