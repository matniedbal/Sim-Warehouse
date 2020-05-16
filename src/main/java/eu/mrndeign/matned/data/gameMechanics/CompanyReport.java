package eu.mrndeign.matned.data.gameMechanics;

import java.util.LinkedList;
import java.util.List;

public class CompanyReport implements Report {

    private List<WarehouseReport> warehouseReports;

    public CompanyReport(List<WarehouseReport> warehouseReports) {
        this.warehouseReports = new LinkedList<>(warehouseReports);
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
