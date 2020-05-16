package eu.mrndeign.matned.data.object;

import eu.mrndeign.matned.data.mySql.DBFactory;
import eu.mrndeign.matned.data.mySql.entity.Company;
import eu.mrndeign.matned.data.mySql.entity.Warehouse;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;

import static eu.mrndeign.matned.data.use.ConstantValues.HIBERNATE_FILE;

public class CompanyObject implements SqlEntity<Company>{

    private Company entity;
    private DBFactory db;

    private int companyId;
    private String companyName;

    private List<Warehouse> warehouses;

    private int round;
    private int money;

    public CompanyObject() {
    }


    @Override
    public void generateEntity() {
        db= new DBFactory(HIBERNATE_FILE);
        db.connectionOn();
        Session session = db.getSession();
        entity = new Company(companyName, money);
        session.persist(entity);
        db.connectionOff();
        // now goes initialization of all the shit
        initialize();
    }

    @Override
    public Company getEntity() {
        return entity;
    }

    @Override
    public void refreshEntity() {
        db= new DBFactory();
        Session session = db.getSession();
        db.connectionOn();
        entity = session.get(Company.class,companyId);
        db.connectionOff();
    }

    @Override
    public void dropEntity() {
        db= new DBFactory();
        Session session = db.getSession();
        db.connectionOn();
        session.delete(entity);
        db.connectionOff();
    }

    @Override
    public void updateEntity() {
        db= new DBFactory();
        Session session = db.getSession();
        db.connectionOn();
        session.update(entity);
        db.connectionOff();
    }

    @Override
    public void setEntity(Company entity) {
        this.entity = entity;
    }

    private void initialize() {
        companyId = entity.getCompanyId();
        money = entity.getWealth();
        companyName = entity.getName();
        warehouses = new LinkedList<Warehouse>(entity.getWarehouses());
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }
    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "CompanyObject{" +
                "entity=" + entity +
                ", db=" + db +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", warehouses=" + warehouses +
                ", round=" + round +
                ", money=" + money +
                '}';
    }
}
