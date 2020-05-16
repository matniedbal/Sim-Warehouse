package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "regal")
public class Regal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regal_id")
    private int regalId;

    @Column(name = "name")
    private String regalName;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "regal", cascade = CascadeType.ALL)
    private List<RegalSpace> regalSpaces;

    public Regal() {
    }

    public Regal(String regalName, int regalPalletsLength, int regalPalletsHeight) {
        this.regalName = regalName;
    }

    public List<RegalSpace> getregalSpaces() {
        return regalSpaces;
    }
    public void setProductDetails(List<RegalSpace> productDetails) {
        this.regalSpaces = regalSpaces;
    }

    public String getRegalName() {
        return regalName;
    }
    public void setRegalName(String regalName) {
        this.regalName = regalName;
    }

    public int getRegalId() {
        return regalId;
    }
    public void setRegalId(int regalId) {
        this.regalId = regalId;
    }



    public Warehouse getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Regal{" +
                "regalId=" + regalId +
                '}';
    }
}

