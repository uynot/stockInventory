package stock.inventory.springbootcrudapi.model;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDateTime;

@Entity(name="currentPrice")
@Table(name="tb_current_price")
public class CurrentPrice {

	@Id
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="current_price")
	private String currentPrice;

	@Column(name="lastUpdateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime lastUpdateTime;
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

}
