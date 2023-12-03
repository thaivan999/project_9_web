package hcmute.entity;

import java.io.Serializable;

import javax.persistence.*;

import hcmute.embeddedId.OrderDetailId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderDetail")
public class OrderDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderDetailId idOrderDetail;
    
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "size", columnDefinition = "varchar(50)")
    private int size;

    @Column(name = "note", columnDefinition = "nvarchar(1000)")
    private String note;
    
    @ManyToOne
    @JoinColumn(name = "id_order", insertable = false, updatable = false)
    private OrderEntity orderByOrderDetail;

    @ManyToOne
    @JoinColumn(name = "id_milk_tea", insertable = false, updatable = false)
    private MilkTeaEntity milkTeaByOrderDetail;
}
