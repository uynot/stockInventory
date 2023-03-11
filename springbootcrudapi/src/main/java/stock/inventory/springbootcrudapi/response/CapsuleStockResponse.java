package stock.inventory.springbootcrudapi.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import stock.inventory.springbootcrudapi.model.CapsuleStock;

//@data
public class CapsuleStockResponse {
	
	private String code;
	private String status;
	private String error;
	private String msg;
    private CapsuleStock data;
    
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
	
	public CapsuleStock getData() {
		return data;
	}
	public void setData(CapsuleStock data) {
		this.data = data;
	}
}
