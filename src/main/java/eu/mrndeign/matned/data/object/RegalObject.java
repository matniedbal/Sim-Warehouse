package eu.mrndeign.matned.data.object;

import eu.mrndeign.matned.data.mySql.entity.Regal;
import eu.mrndeign.matned.data.use.MatrixCoordinates;

import java.util.LinkedList;
import java.util.List;

public class RegalObject implements SqlEntity<Regal>{
    private int regalId;

    private WarehouseObject warehouse;

    private int regalLength;
    private int regalHeight;

    private List<SpaceObject[]> regalSpaces;
    private List<MatrixCoordinates[]> coordinates;

    RegalObject(int regalId, WarehouseObject warehouse) {
        this.regalId = regalId;
        this.warehouse = warehouse;
        regalLength = warehouse.getRegalLength();
        regalSpaces = new LinkedList<>();
        coordinates = new LinkedList<>();
        refresh();

    }

    @Override
    public void generateEntity() {
        initialize();
    }

    @Override
    public Regal getEntity() {
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
    public void setEntity(Regal entity) {

    }

    private void initialize(){

    }
    void addLayer(){
        regalSpaces.add(new SpaceObject[regalLength]);
        SpaceObject[] lastLayerRecord = regalSpaces.get(regalSpaces.size()-1);
        for (int i = 0; i < lastLayerRecord.length; i++) {
            lastLayerRecord[i] = new SpaceObject(this, SpaceObjectType.REGAL);
        }
        refresh();
    }

    void addCoordinatesLayer(MatrixCoordinates[] mc) {
        coordinates.add(mc);
        int counter = 0;

        for (SpaceObject element : regalSpaces.get(regalSpaces.size()-1)) {
            element.setCoordinates(coordinates.get(coordinates.size()-1)[counter]);
            counter++;
        }
    }

    private void refresh() {
        regalHeight = warehouse.getRegalHeight(regalId);
    }
    int getRegalId() {
        return regalId;
    }

    public void setRegalId(int regalId) {
        this.regalId = regalId;
    }
    public WarehouseObject getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseObject warehouse) {
        this.warehouse = warehouse;
    }
    public int getRegalLength() {
        return regalLength;
    }

    public void setRegalLength(int regalLength) {
        this.regalLength = regalLength;
    }
    public int getRegalHeight() {
        return regalHeight;
    }

    public void setRegalHeight(int regalHeight) {
        this.regalHeight = regalHeight;
    }
    public List<SpaceObject[]> getRegalSpaces() {
        return regalSpaces;
    }

    public void setRegalSpaces(List<SpaceObject[]> regalSpaces) {
        this.regalSpaces = regalSpaces;
    }

    @Override
    public String toString() {
        return "RegalObject{" +
                "regalId=" + regalId +
                ", warehouse=" + warehouse +
                ", regalLength=" + regalLength +
                ", regalHeight=" + regalHeight +
                '}';
    }
}
