package eu.mrndeign.matned.data.use;

import eu.mrndeign.matned.data.mySql.entity.Product;

public class ProdSize {
    private int x;
    private int y;
    private int z;
    private Product product;

    public ProdSize(Product prod) {
        this.product = prod;
        x = prod.getProductDetails().getLength();
        y = prod.getProductDetails().getWidth();
        z = prod.getProductDetails().getHeight();
    }

    public ProdSize turn(){
        int tempX = x;
        x = y;
        y = tempX;
      return this;
    }

    public Product getProduct() {
        return product;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "ProdSize{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
