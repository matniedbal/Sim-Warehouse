package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;

@Entity
@Table(name = "packed_pallet")
public class PackedPallet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "packed_pallet_id")
    private int packedPalletId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "order_id")
    private Order orderId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "pallet_no")
    private int palletNo;

    @Column(name = "x_id")
    private int xId;

    @Column(name = "y_id")
    private int yId;

    @Column(name = "z_id")
    private int zId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "package_type_id")
    private PackageType packageTypeId;

    public PackedPallet() {
    }

    public PackedPallet(Product product, int palletNo, int xId, int yId, int zId) {
        this.product = product;
        this.palletNo = palletNo;
        this.xId = xId;
        this.yId = yId;
        this.zId = zId;
    }

    public int getPackedPalletId() {
        return packedPalletId;
    }
    public void setPackedPalletId(int packedPalletId) {
        this.packedPalletId = packedPalletId;
    }

    public Order getOrderId() {
        return orderId;
    }
    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public int getPalletNo() {
        return palletNo;
    }
    public void setPalletNo(int palletNo) {
        this.palletNo = palletNo;
    }

    public int getxId() {
        return xId;
    }
    public void setxId(int xId) {
        this.xId = xId;
    }

    public int getyId() {
        return yId;
    }
    public void setyId(int yId) {
        this.yId = yId;
    }

    public int getzId() {
        return zId;
    }
    public void setzId(int zId) {
        this.zId = zId;
    }

    public PackageType getPackageTypeId() {
        return packageTypeId;
    }
    public void setPackageTypeId(PackageType packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    @Override
    public String toString() {
        return "PackedPallet{" +
                "packedPalletId=" + packedPalletId +
                ", orderId=" + orderId +
                ", palletNo=" + palletNo +
                ", xId=" + xId +
                ", yId=" + yId +
                ", zId=" + zId +
                ", packageTypeId=" + packageTypeId +
                '}';
    }
}
