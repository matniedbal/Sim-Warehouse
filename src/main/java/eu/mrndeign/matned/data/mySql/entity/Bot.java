package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;

@Entity
@Table(name = "bot")
public class Bot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bot_id")
    private  int botId;

    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) /*   One way   */
    @JoinColumn(name = "bot_type_id")
    private BotType botType;

    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) /*   Two ways   */
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    public Bot() {
    }

    public Bot(BotType botType, Warehouse warehouse) {
        this.botType = botType;
        this.warehouse = warehouse;
    }

    public int getBotId() {
        return botId;
    }
    public void setBotId(int botId) {
        this.botId = botId;
    }

    public BotType getBotType() {
        return botType;
    }
    public void setBotType(BotType botType) {
        this.botType = botType;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "botId=" + botId +
                '}';
    }
}
