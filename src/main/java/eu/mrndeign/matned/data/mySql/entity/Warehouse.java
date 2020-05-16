package eu.mrndeign.matned.data.mySql.entity;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private int warehouseId;

    @Column(name = "name")
    private String name;

    @Column(name = "width")
    private int width;

    @Column(name = "length")
    private int length;

    @Column(name = "height")
    private int height;

    @Column(name = "location_country")
    private String locationCountry;

    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<Regal> regals;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<Bot> bots;


    public Warehouse() {
    }

    private Warehouse(WarehouseBuilder builder) {
        this.name = builder.name;
        this.width = builder.width;
        this.length = builder.length;
        this.height = builder.height;
        this.locationCountry = builder.locationCountry;
    }

    public void addRegal(Regal regal){
        if (regals == null) this.regals = new LinkedList<>();
        regals.add(regal);
        regal.setWarehouse(this);
    }

    public void addBot(Bot bot){
        if (bots == null) this.bots = new LinkedList<>();
        bots.add(bot);
        bot.setWarehouse(this);
    }

    public int getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public String getLocationCountry() {
        return locationCountry;
    }
    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public List<Regal> getRegals() {
        return regals;
    }
    public void setRegals(List<Regal> regals) {
        this.regals = regals;
    }

    public List<Bot> getBots() {
        return bots;
    }
    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", warehouseName='" + name + '\'' +
                ", warehouseWidth=" + width +
                ", warehouseLength=" + length +
                ", warehouseHeight=" + height +
                ", warehouseLocationCountry='" + locationCountry + '\'' +
                '}';
    }

    public static class WarehouseBuilder{

        private String name;
        private int width;
        private int length;
        private int height;
        private String locationCountry;


        public WarehouseBuilder(int width, int length, int height) {
            this.width = width;
            this.length = length;
            this.height = height;

        }

        public WarehouseBuilder name(String warehouse_name){
            this.name = warehouse_name;
            return this;
        }

        public WarehouseBuilder locationCountry(String locationCountry){
            this.locationCountry =locationCountry;
            return this;
        }

        public Warehouse build(){
            return new Warehouse(this);
        }
    }


}
