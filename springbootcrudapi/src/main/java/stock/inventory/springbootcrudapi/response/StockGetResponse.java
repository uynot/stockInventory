package stock.inventory.springbootcrudapi.response;

import java.util.List;
import java.util.Map;

import stock.inventory.springbootcrudapi.model.ItemStock;

//@data
public class StockGetResponse {
	
	private String code;
	private String status;
	private String error;
	private String msg;
//    private List<ItemStock> data;
    private List<Map<String,Object>> data;
    
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
	
	public List<Map<String,Object>> getData() {
		return data;
	}
	public void setData(List<Map<String,Object>> data) {
		this.data = data;
	}
}