package stock.inventory.springbootcrudapi.request;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class SaveCapsuleStockRequest {
	
	private String itemOwner;
	private int itemId;
	private String tradeAction;
	private int quantity;
	private float buyInPrice;
	private float cashoutPrice;
	private LocalDateTime tradeTime;
	private String buffUrl;
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
