package stock.inventory.springbootcrudapi.response;

import java.util.List;
import java.util.Map;

import stock.inventory.springbootcrudapi.model.ItemStock;

//@data
public class StockGetByItemTypeResponse {
	
	private String code;
	private String status;
	private String error;
	private String msg;
	private String itemType;
	private int itemQuantity;
    private List<Map<String,Object>> dataByItemType;
    
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
	
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	public List<Map<String,Object>> getDataByItemType() {
		return dataByItemType;
	}
	public void setDataByItemType(List<Map<String,Object>> dataByItemType) {
		this.dataByItemType = dataByItemType;
	}
}
