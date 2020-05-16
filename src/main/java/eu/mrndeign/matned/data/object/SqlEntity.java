package eu.mrndeign.matned.data.object;

public interface SqlEntity<E> {

    void generateEntity();
    E getEntity();
    void refreshEntity();
    void dropEntity();
    void updateEntity();
    void setEntity(E entity);

}
