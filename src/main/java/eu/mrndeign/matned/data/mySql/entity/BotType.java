package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;

@Entity
@Table(name = "bot_type")
public class BotType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bot_type_id")
    private int botTypeId;

    @Column(name = "type")
    private String type;

    @Column(name = "max_speed")
    private int maxSpeed;

    @Column(name = "max_capacity")
    private int maxCapacity;

    @Column(name = "max_height_reach")
    private int maxHeightReach;


    public BotType() {
    }

    public BotType(String type, int maxSpeed, int maxCapacity) {
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.maxCapacity = maxCapacity;
    }

    public int getBotTypeId() {
        return botTypeId;
    }
    public void setBotTypeId(int botTypeId) {
        this.botTypeId = botTypeId;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxHeightReach() {
        return maxHeightReach;
    }
    public void setMaxHeightReach(int maxHeightReach) {
        this.maxHeightReach = maxHeightReach;
    }

    @Override
    public String toString() {
        return "BotType{" +
                "botTypeId=" + botTypeId +
                ", type='" + type + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
