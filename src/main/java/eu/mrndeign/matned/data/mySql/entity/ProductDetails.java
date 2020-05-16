package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_details_id")
    private int productId;

    @Column(name = "width")
    private int width;

    @Column(name = "length")
    private int length;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private double weight;

    @Column(name = "box_amount")
    private double boxAmount;

    @Column(name = "is_fragile")
    private boolean isFragile;

    private ProductDetails() {
    }

    private ProductDetails(ProductDetailsBuilder builder) {
        this.width = builder.width;
        this.length = builder.length;
        this.height = builder.height;
        this.weight = builder.weight;
        this.boxAmount = builder.boxAmount;
        this.isFragile = builder.isFragile;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBoxAmount() {
        return boxAmount;
    }
    public void setBoxAmount(double boxAmount) {
        this.boxAmount = boxAmount;
    }

    public boolean isFragile() {
        return isFragile;
    }
    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "productId=" + productId +
                ", width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", weight=" + weight +
                ", boxAmount=" + boxAmount +
                ", isFragile=" + isFragile +
                '}';
    }

    public static class ProductDetailsBuilder {

        private int width;
        private int length;
        private int height;
        private double weight;
        private boolean isFragile;
        private int boxAmount;



        public ProductDetailsBuilder(int width, int length, int height, double weight) {
            this.width = width;
            this.length = length;
            this.height = height;
            this.weight = weight;
        }

        public ProductDetailsBuilder isFragile(boolean isFragile){
            this.isFragile = isFragile;
            return this;
        }

        public ProductDetailsBuilder boxAmount(int boxAmount){
            this.boxAmount = boxAmount;
            return this;
        }


        public ProductDetails build (){
            return new ProductDetails(this);
        }


    }
}
