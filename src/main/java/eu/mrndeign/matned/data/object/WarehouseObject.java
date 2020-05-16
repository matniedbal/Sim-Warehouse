package eu.mrndeign.matned.data.object;

import eu.mrndeign.matned.data.mySql.entity.Warehouse;
import eu.mrndeign.matned.data.use.MatrixCoordinates;

import java.util.LinkedList;
import java.util.List;

import static eu.mrndeign.matned.data.use.ConstantValues.*;


public class WarehouseObject implements SqlEntity<Warehouse>{


    private String name;
    private String location;

    private int length;
    private int width;
    private int height;

    private SpaceObjectType[][][] matrix;
    private List<RegalObject> regalList;
    private List<BotObject> botList;

    private Warehouse warehouse;
    private int chargers;
    private int actualLayer;

    public WarehouseObject() {
    }

    WarehouseObject(Warehouse warehouse) {
        initialize();
    }

    @Override
    public void generateEntity() {
        initialize();
    }

    @Override
    public Warehouse getEntity() {
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
    public void setEntity(Warehouse entity) {

    }

    private void initialize(){
        this.warehouse = warehouse;
        this.name = warehouse.getName();
        this.location = warehouse.getLocationCountry();
        this.length = warehouse.getLength();
        this.width = warehouse.getWidth();
        this.height = warehouse.getHeight();
        regalList = new LinkedList<>();
        botList = new LinkedList<>();
        generateFirstWarehouse();
    }

    boolean putRegalLayer(int regalNo) {
        actualLayer = 0;
        if (regalNo * REGAL_AND_ROAD_WIDTH < width - 2 && regalLayerCheck(regalNo) && regalNo >= 0) {
            generateSpace(actualLayer, actualLayer + GAP,
                    regalNo * REGAL_AND_ROAD_WIDTH - GAP, regalNo * REGAL_AND_ROAD_WIDTH,
                    REGAL_X_START, length,
                    SpaceObjectType.REGAL);
            if(actualLayer == 0) {
                regalList.add(new RegalObject(regalNo, this));
                regalList.get(regalList.size()-1).addLayer();
                regalList.get(regalList.size()-1).addCoordinatesLayer(getRegalMatrix(regalNo)[actualLayer-1]);
            }
            else regalList.get(getRegalId(regalNo)).addLayer();
            return true;
        }else  return false;
    }

    private int getRegalId(int regalNo) {
        int counter =0;
        for (RegalObject element : regalList) {
            if(element.getRegalId() == regalNo) return counter;
            else counter++;
        }
        return 0;
    }

    boolean putCharger() {
        if (chargers + DELIVERY_SPACE_L + GAP <= length) {
            generateSpace(0, DELIVERY_SPACE_L,
                    width- GAP, width,
                    chargers + DELIVERY_SPACE_L, chargers + DELIVERY_SPACE_L + GAP,
                    SpaceObjectType.CHARGER);
            chargers++;
            return true;
        } else return false;
    }


    private void generateFirstWarehouse() {
        chargers = 0;
        if (length < MIN_LENGTH) length = MIN_LENGTH;
        if (width < MIN_WIDTH) width = MIN_WIDTH;
        if (height < MIN_HEIGHT) height = MIN_HEIGHT;
        matrix = new SpaceObjectType[height][width][length];
        generateSpace(0, height, 0, width, 0, length, SpaceObjectType.FREE);
        generateSpace(0, DELIVERY_SPACE_H, 0, MIN_WIDTH /2, 0, DELIVERY_SPACE_L, SpaceObjectType.DELIVERY_SP);
        generateSpace(0, DELIVERY_SPACE_H, MIN_WIDTH /2, MIN_WIDTH, 0, DELIVERY_SPACE_L, SpaceObjectType.RECEIVE_SP);
        putRegalLayer(FIRST_REGAL_ID);
        putRegalLayer(FIRST_REGAL_ID);

        putCharger();
    }

    private boolean regalLayerCheck(int regalNo) {
        if(actualLayer < height) {
            if (matrix[actualLayer][regalNo * REGAL_AND_ROAD_WIDTH - GAP][REGAL_X_START] != SpaceObjectType.FREE){
                actualLayer++;
                return regalLayerCheck(regalNo);
            }else return true;
        }else return false;
    }

    private void generateSpace(int z1, int z2, int y1, int y2, int x1, int x2, SpaceObjectType ro) {
        for (int i = z1; i < z2; i++) {
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    matrix[i][j][k] = ro;
                }
            }
        }
    }

    MatrixCoordinates[][] getRegalMatrix(int regalNo){
        MatrixCoordinates[][] matrix = new MatrixCoordinates[getRegalHeight(regalNo)][getRegalLength()];
        for (int i = 0; i < getRegalHeight(regalNo); i++) {
            for (int j = REGAL_X_START; j < 5; j++) {
                matrix[i][j] = new MatrixCoordinates(j,regalNo * REGAL_AND_ROAD_WIDTH - GAP,i);
            }
        }
        return matrix;
    }

    int getRegalHeight(int regalNo){
        if(regalNo * REGAL_AND_ROAD_WIDTH < width - 2) {
            actualLayer = 0;
            regalLayerCheck(regalNo);
            return actualLayer;
        }else return 0;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<RegalObject> getRegalList() {
        return regalList;
    }

    public List<BotObject> getBotList() {
        return botList;
    }

    public int getChargers() {
        return chargers;
    }

    int getRegalLength(){
        return length -REGAL_X_START;
    }

    SpaceObjectType[][][] getMatrix() {
        return matrix;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "WarehouseObject{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
