package stock.inventory.springbootcrudapi.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDateTime;

@Entity(name="caseStock")
@Table(name="tb_case_stock")
public class CaseStock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trade_id")
	private int tradeId;
	
	@Column(name="item_owner")
	private String itemOwner;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="trade_action") //buy or sell
	private String tradeAction;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="buy_in_price")
	private float buyinPrice;
	
	@Column(name="cashout_price")
	private float cashoutPrice;
	
	@Column(name="trade_time")
	private LocalDateTime tradeTime;
	
	@Column(name="buff_url")
	private String buffUrl;

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getItemOwner() {
		return itemOwner;
	}

	public void setItemOwner(String itemOwner) {
		this.itemOwner = itemOwner;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getTradeAction() {
		return tradeAction;
	}

	public void setTradeAction(String tradeAction) {
		this.tradeAction = tradeAction;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getBuyinPrice() {
		return buyinPrice;
	}

	public void setBuyinPrice(float buyinPrice) {
		this.buyinPrice = buyinPrice;
	}

	public float getCashoutPrice() {
		return cashoutPrice;
	}

	public void setCashoutPrice(float cashoutPrice) {
		this.cashoutPrice = cashoutPrice;
	}

	public LocalDateTime getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(LocalDateTime tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getBuffUrl() {
		return buffUrl;
	}

	public void setBuffUrl(String buffUrl) {
		this.buffUrl = buffUrl;
	}

	
}
