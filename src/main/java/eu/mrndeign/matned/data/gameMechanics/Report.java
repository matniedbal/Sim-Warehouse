package eu.mrndeign.matned.data.gameMechanics;

public interface Report {

    int getIncome();
    int getCosts();
    int getNumberOdOrdersDelivered();
    int getNumberOfOrdersOnStock();
    int getValueOfElement();

    void generateReport();


}
