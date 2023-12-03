package hcmute.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class OrderDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_order", insertable = false, updatable = false)
    private OrderEntity orderByOrderDetail;

    @ManyToOne
    @JoinColumn(name = "id_milk_tea", insertable = false, updatable = false)
    private MilkTeaEntity milkTeaByOrderDetail;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "size", columnDefinition = "varchar(50)")
    private int size;

    @Column(name = "note", columnDefinition = "nvarchar(1000)")
    private String note;
}
