package stock.inventory.springbootcrudapi.response;

import java.util.List;
import java.util.Map;

import stock.inventory.springbootcrudapi.model.ItemStock;
import stock.inventory.springbootcrudapi.utility.ListByItemType;
import stock.inventory.springbootcrudapi.utility.QuantityByItemType;

//@data
public class StockGetResponse {
	
	private String code;
	private String status;
	private String error;
	private String msg;
	private int itemQuantity;
	private QuantityByItemType quantityByItemType;
//  private List<ItemStock> data;
    private ListByItemType data;
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
//	public List<ItemStock> getData() {
//		return data;
//	}
//	public void setData(List<ItemStock> data) {
//		this.data = data;
//	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	public ListByItemType getData() {
		return data;
	}
	
	public void setData(ListByItemType data) {
		this.data = data;
	}
	
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	public QuantityByItemType getQuantityByItemType() {
		return quantityByItemType;
	}
	
	public void setQuantityByItemType(QuantityByItemType quantityByItemType) {
		this.quantityByItemType = quantityByItemType;
	}
}
