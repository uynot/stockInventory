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
public class CapsuleStockROIResponse {
	
	private String code;
	private String status;
	private String error;
	private String msg;
    private List<String> items;
	private int quantity;
	private double profit;
	private double totalBuyInPrice;
    private double totalCurrentPrice;
    private double averageProfit;
    private String averageROI;
    private int recordInput;
    private int recordFound;
    
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
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public double getAverageProfit() {
		return averageProfit;
	}
	public void setAverageProfit(double averageProfit) {
		this.averageProfit = averageProfit;
	}
	public String getAverageROI() {
		return averageROI;
	}
	public void setAverageROI(String averageROI) {
		this.averageROI = averageROI;
	}
	public double getTotalBuyInPrice() {
		return totalBuyInPrice;
	}
	public void setTotalBuyInPrice(double totalBuyInPrice) {
		this.totalBuyInPrice = totalBuyInPrice;
	}
	public double getTotalCurrentPrice() {
		return totalCurrentPrice;
	}
	public void setTotalCurrentPrice(double totalCurrentPrice) {
		this.totalCurrentPrice = totalCurrentPrice;
	}
	public int getRecordInput() {
		return recordInput;
	}
	public void setRecordInput(int recordInput) {
		this.recordInput = recordInput;
	}
	public int getRecordFound() {
		return recordFound;
	}
	public void setRecordFound(int recordFound) {
		this.recordFound = recordFound;
	}
	
}
