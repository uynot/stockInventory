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
import jakarta.persistence.Transient;

@Entity(name="itemStock")
@Table(name = "item_stock")
public class ItemStock {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private int stockId;
    
    @Column(name = "transaction_id_fk")
	int transactionId;
    
    @Column(name = "item_id_fk")
    private int itemId;

    @Column(name = "skin_condition_id_fk")
	private int skinConditionId;
    
    @Column(name = "float_value")
    private Float floatValue;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "remark")
    private String remark;
    
    @Transient String itemName;
    
    @Transient String itemType;
    
    @Transient float stockInPrice;
    
    @Transient float currentPrice;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getSkinConditionId() {
		return skinConditionId;
	}

	public void setSkinConditionId(int skinConditionId) {
		this.skinConditionId = skinConditionId;
	}

	public Float getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(Float floatValue) {
		this.floatValue = floatValue;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public float getStockInPrice() {
		return stockInPrice;
	}

	public void setStockInPrice(float stockInPrice) {
		this.stockInPrice = stockInPrice;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
}
