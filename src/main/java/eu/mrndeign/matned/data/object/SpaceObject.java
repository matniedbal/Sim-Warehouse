package eu.mrndeign.matned.data.object;

import eu.mrndeign.matned.data.mySql.entity.RegalSpace;
import eu.mrndeign.matned.data.use.MatrixCoordinates;

public class SpaceObject implements SqlEntity<RegalSpace> {

    private RegalSpace entity;

    private SpaceObjectType type;
    private MatrixCoordinates coordinates;

    private OrderObject order;

    private RegalObject regal;

    private boolean isOccupied;

    SpaceObject(RegalObject regal, SpaceObjectType type) {
        this.type = type;
        this.regal = regal;
        isOccupied = false;

    }

    @Override
    public void generateEntity() {

        initialize();
    }

    @Override
    public RegalSpace getEntity() {
        return null;
    }

    @Override
    public void refreshEntity() {

    }

    @Override
    public void dropEntity() {

    }

    @Override
    public void updateEntity() {

    }

    @Override
    public void setEntity(RegalSpace entity) {

    }

    private void initialize(){

    }

    boolean setOrder(OrderObject order){
        this.order = order;
        isOccupied = true;
        return true;
    }

    boolean removeOrder(){
        this.order = null;
        isOccupied = false;
        return true;
    }

    void setCoordinates(MatrixCoordinates coordinates) {
        this.coordinates = coordinates;
    }
    public SpaceObjectType getType() {
        return type;
    }

    public void setType(SpaceObjectType type) {
        this.type = type;
    }

    public MatrixCoordinates getCoordinates() {
        return coordinates;
    }

    public OrderObject getOrder() {
        return order;
    }
    public RegalObject getRegal() {
        return regal;
    }

    public void setRegal(RegalObject regal) {
        this.regal = regal;
    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "SpaceObject{" +
                "type=" + type +
                ", coordinates=" + coordinates +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
