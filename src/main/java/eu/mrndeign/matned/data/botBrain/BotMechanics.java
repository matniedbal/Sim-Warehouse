package eu.mrndeign.matned.data.botBrain;

import eu.mrndeign.matned.data.mySql.entity.Bot;
import eu.mrndeign.matned.data.mySql.entity.Order;
import eu.mrndeign.matned.data.mySql.entity.RegalSpace;

public class BotMechanics {

    private Bot bot;
    private int positionX;
    private int positionY;
    private int capacity;
    private int speed;
    private int reach;

    private Order actualOrder;

    public BotMechanics(Bot bot, int positionX, int positionY) {
        this.bot = bot;
        this.positionX = positionX;

        this.positionY = positionY;
        capacity = bot.getBotType().getMaxCapacity();
        speed = bot.getBotType().getMaxSpeed();
        reach = bot.getBotType().getMaxHeightReach();
    }

    public void move(Direction direction){
        switch (direction){
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
            default:
                break;
        }
    }

    public void take(RegalSpace regalSpace){
        actualOrder = regalSpace.getOrder();
        if(actualOrder.getOrderWeight() > capacity)
            actualOrder = null;
        else regalSpace.setOrder(null);
    }

    public void put(RegalSpace regalSpace){
        if(regalSpace.isEmpty() && isEnoughSpace(regalSpace)) {
            regalSpace.setOrder(actualOrder);
            actualOrder = null;
        }
    }

    private boolean isEnoughSpace(RegalSpace regalSpace) {
        int spaceHeight = regalSpace.getHeight();
        int spaceWidth = regalSpace.getWidth();
        int spaceLength = regalSpace.getLength();
        int orderHeight = actualOrder.getOrderHeight();
//        int orderWidth = actualOrder.getPallets()..getPackageType().getMaxWidth();
//        int orderLength = actualOrder.getPackageType().getMaxLength();
        return false;
    }


    public Bot getBot() {
        return bot;
    }

    public int getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public Order getActualOrder() {
        return actualOrder;
    }

    private void moveUp() {
        positionX -= 1;
    }

    private void moveDown() {
        positionX += 1;
    }

    private void moveLeft() {
        positionY -= 1;
    }

    private void moveRight() {
        positionY += 1;
    }

    @Override
    public String toString() {
        return "BotMechanics{" +
                "bot=" + bot +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", capacity=" + capacity +
                ", speed=" + speed +
                ", reach=" + reach +
                ", actualOrder=" + actualOrder +
                '}';
    }
}
