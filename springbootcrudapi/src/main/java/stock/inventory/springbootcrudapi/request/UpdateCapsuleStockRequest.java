package stock.inventory.springbootcrudapi.request;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class UpdateCapsuleStockRequest {
	
	private Integer tradeId;
	private String itemOwner;
	private Integer itemId;
	private String tradeAction;
	private Integer quantity;
	private float buyInPrice;
	private float cashoutPrice;
	private String tradeTime;
	private String buffUrl;
	
	public Integer getTradeId() {
		return tradeId;
	}
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}
	public String getItemOwner() {
		return itemOwner;
	}
	public void setItemOwner(String itemOwner) {
		this.itemOwner = itemOwner;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getTradeAction() {
		return tradeAction;
	}
	public void setTradeAction(String tradeAction) {
		this.tradeAction = tradeAction;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public float getBuyInPrice() {
		return buyInPrice;
	}
	public void setBuyinPrice(float buyInPrice) {
		this.buyInPrice = buyInPrice;
	}
	public float getCashoutPrice() {
		return cashoutPrice;
	}
	public void setCashoutPrice(float cashoutPrice) {
		this.cashoutPrice = cashoutPrice;
	}
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getBuffUrl() {
		return buffUrl;
	}
	public void setBuffUrl(String buffUrl) {
		this.buffUrl = buffUrl;
	}
    
    
}
