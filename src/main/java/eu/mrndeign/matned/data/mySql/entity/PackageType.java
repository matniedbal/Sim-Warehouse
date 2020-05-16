package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;

@Entity
@Table(name = "package_type")
public class PackageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_type_id")
    private int productTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "max_width")
    private int maxWidth;

    @Column(name = "max_length")
    private int maxLength;

    @Column(name = "max_height")
    private int maxHeight;

    @Column(name = "weight")
    private int weight;

    public PackageType() {
    }

    public PackageType(String name, int maxWidth, int maxLength, int maxHeight, int weight) {
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
        this.weight = weight;
    }

    public int getProductTypeId() {
        return productTypeId;
    }
    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMaxWidth() {
        return maxWidth;
    }
    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxLength() {
        return maxLength;
    }
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PackageType{" +
                "productTypeId=" + productTypeId +
                ", productTypeName='" + name + '\'' +
                ", maxWidth=" + maxWidth +
                ", maxLength=" + maxLength +
                ", maxHeight=" + maxHeight +
                '}';
    }
}
