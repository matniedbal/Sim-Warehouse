package eu.mrndeign.matned.data.object;

import eu.mrndeign.matned.data.mySql.DBFactory;
import eu.mrndeign.matned.data.mySql.entity.Bot;
import eu.mrndeign.matned.data.mySql.entity.BotType;
import org.hibernate.Session;
import org.hibernate.query.*;

import static eu.mrndeign.matned.data.use.ConstantValues.HIBERNATE_FILE;

public class BotObject implements SqlEntity<Bot>{


    private Bot entity;
    private BotType botTypeEntity;
    private DBFactory db;

    private int botType_Id;

    private WarehouseObject warehouse;
    private int botId;
    private boolean isFull;
    private boolean isDead;

    private int speed;
    private int reach;
    private int charge;
    private int capacity;

    public BotObject(WarehouseObject warehouse, int botTypeId) {
        this.warehouse = warehouse;
        this.botType_Id = botTypeId;
    }

    @Override
    public void generateEntity() {
        db= new DBFactory(HIBERNATE_FILE);
        db.connectionOn();
        Session session = db.getSession();
        Query query = session.createQuery("FROM BotType WHERE botTypeId =: botType_Id");
        query.setParameter("botType_Id", botType_Id);
        botTypeEntity = (BotType) query.getSingleResult();
        entity = new Bot(botTypeEntity, warehouse.getWarehouse());
        session.persist(entity);
        db.connectionOff();
        // now goes initialization of all the shit
        initialize();
    }

    @Override
    public Bot getEntity() {
        return entity;
    }

    @Override
    public void refreshEntity() {
        db= new DBFactory();
        Session session = db.getSession();
        db.connectionOn();
        entity = session.get(Bot.class,botId);
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
    public void setEntity(Bot entity) {
        this.entity = entity;
    }

    private void initialize() {
        botId = entity.getBotId();
        speed = entity.getBotType().getMaxSpeed();
        reach = entity.getBotType().getMaxHeightReach();
        capacity = entity.getBotType().getMaxCapacity();
        charge = 100;
        isFull = false;
        isDead = false;
    }

    public WarehouseObject getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(WarehouseObject warehouse) {
        this.warehouse = warehouse;
    }

    public int getBotId() {
        return botId;
    }
    public void setBotId(int botId) {
        this.botId = botId;
    }

    public boolean isDead() {
        return isDead;
    }
    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return isFull;
    }
    public void setFull(boolean full) {
        isFull = full;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getReach() {
        return reach;
    }
    public void setReach(int reach) {
        this.reach = reach;
    }

    public int getCharge() {
        return charge;
    }
    public void setCharge(int charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "BotObject{" +
                "botId=" + botId +
                ", isFull=" + isFull +
                ", speed=" + speed +
                ", reach=" + reach +
                ", charge=" + charge +
                '}';
    }
}
