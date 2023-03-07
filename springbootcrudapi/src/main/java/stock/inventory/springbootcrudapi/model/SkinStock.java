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

@Entity(name="skinStock")
@Table(name="tb_skin_stock")
public class SkinStock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trade_id")
	private int tradeId;
	
	@Column(name="item_owner")
	private String itemOwner;
	
	@Column(name="skin_name")
	private int skinName;
	
	@Column(name="skin_condition_status_id")
	private int skinConditionStatusId;
	
	@Column(name="skin_float")
	private int skinFloat;
	
	@Column(name="skin_seed")
	private int skinSeed;
	
	@Column(name="remark") //buy or sell
	private String remark;
	
	@Column(name="buy_in_price")
	private float buyinPrice;
	
	@Column(name="cashout_price")
	private float cashoutPrice;
	
	@Column(name="trade_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tradeTime;
	
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

	public int getSkinName() {
		return skinName;
	}

	public void setSkinName(int skinName) {
		this.skinName = skinName;
	}

	public int getSkinConditionStatusId() {
		return skinConditionStatusId;
	}

	public void setSkinConditionStatusId(int skinConditionStatusId) {
		this.skinConditionStatusId = skinConditionStatusId;
	}

	public int getSkinFloat() {
		return skinFloat;
	}

	public void setSkinFloat(int skinFloat) {
		this.skinFloat = skinFloat;
	}

	public int getSkinSeed() {
		return skinSeed;
	}

	public void setSkinSeed(int skinSeed) {
		this.skinSeed = skinSeed;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getBuffUrl() {
		return buffUrl;
	}

	public void setBuffUrl(String buffUrl) {
		this.buffUrl = buffUrl;
	}
	
}
