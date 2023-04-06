package stock.inventory.springbootcrudapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="itemStock")
@Table(name = "item_stock")
public class ItemStock {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private int stockId;

    @ManyToOne
    @JoinColumn(name = "transaction_id_fk")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "item_id_fk")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "item_type_id_fk")
    private ItemType itemType;

    @ManyToOne
    @JoinColumn(name = "skin_condition_id_fk")
    private SkinCondition skinCondition;

    @Column(name = "float_value")
    private Float floatValue;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "remark")
    private String remark;

    // getters and setters
}
