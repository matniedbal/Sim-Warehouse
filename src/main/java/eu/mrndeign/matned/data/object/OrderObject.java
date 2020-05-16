package eu.mrndeign.matned.data.object;


import eu.mrndeign.matned.data.mySql.entity.Order;
import eu.mrndeign.matned.data.mySql.entity.PackageType;

import java.util.LinkedList;
import java.util.List;

import static eu.mrndeign.matned.data.use.ConstantValues.*;

public class OrderObject implements SqlEntity<Order>{

    private Order entity;

    private PackageType packageTypeEntity;

    private List productIds;
    private int packageTypeId;

    public OrderObject() {
    }

    public OrderObject(Order entity) {
        this.entity = entity;
    }

    @Override
    public void generateEntity() {

        initialize();
    }

    @Override
    public Order getEntity() {
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
    public void setEntity(Order entity) {

    }

    private void initialize(){

    }

    public void generateOrder(){
        generatePackageType();
        generateProductList();
    }

    private void generatePackageType() {
        packageTypeId = random(NUMBER_OF_PACKAGE_TYPE_IN_DB);
    }

    private void generateProductList() {
        productIds = new LinkedList();
        for (int i = 0; i < random(MAX_NUMBER_OF_PRODUCTS); i++) {
            productIds.add(random(PRODUCTS_IN_DB));
        }

    }

    private int random(int max) {
        return (int) (Math.random()*max);
    }


}





