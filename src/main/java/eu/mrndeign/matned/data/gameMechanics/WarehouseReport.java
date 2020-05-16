package eu.mrndeign.matned.data.gameMechanics;

import eu.mrndeign.matned.data.mySql.entity.Warehouse;

public class WarehouseReport implements Report {

    private Warehouse warehouse;

    public WarehouseReport(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public int getIncome() {
        return 0;
    }

    @Override
    public int getCosts() {
        return 0;
    }

    @Override
    public int getNumberOdOrdersDelivered() {
        return 0;
    }

    @Override
    public int getNumberOfOrdersOnStock() {
        return 0;
    }

    @Override
    public int getValueOfElement() {
        return 0;
    }

    @Override
    public void generateReport() {

    }
}
