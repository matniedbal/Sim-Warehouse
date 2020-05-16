package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;

@Entity
@Table(name = "regal_space")
public class RegalSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="regal_space_id")
    private int regalSpaceId;

    @Column(name="length")
    private int length;

    @Column(name="width")
    private int width;

    @Column(name="height")
    private int height;

    @Column(name="level")
    private int level;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name="regal_id")
    private Regal regal;


    private RegalSpace() {
    }

    private RegalSpace(RegalSpaceBuilder builder) {
        this.regal = builder.regal;
        this.length = builder.length;
        this.width = builder.width;
        this.height = builder.height;
        this.level = builder.level;
    }


    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public int getRegalSpaceId() {
        return regalSpaceId;
    }
    public void setRegalSpaceId(int regalSpaceId) {
        this.regalSpaceId = regalSpaceId;
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

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public Regal getRegal() {
        return regal;
    }
    public void setRegal(Regal regal) {
        this.regal = regal;
    }

    @Override
    public String toString() {
        return "RegalSpace{" +
                "regalSpaceId=" + regalSpaceId +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", level=" + level +
                '}';
    }

    public boolean isEmpty() {
        return order == null;
    }

    public static class RegalSpaceBuilder{

        private int length;
        private int width;
        private int height;
        private int level;
        private Regal regal;

        public RegalSpaceBuilder(Regal regal) {
            this.regal = regal;
        }

        public RegalSpaceBuilder length(int length){
            this.length=length;
            return this;
        }

        public RegalSpaceBuilder width(int width){
            this.width=width;
            return this;
        }

        public RegalSpaceBuilder height(int height){
            this.height=height;
            return this;
        }

        public RegalSpaceBuilder level(int level){
            this.level=level;
            return this;
        }

        public RegalSpace build(){
            return new RegalSpace(this);
        }
    }

}
