package stock.inventory.springbootcrudapi.request;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class CapsuleROIRequest {
	
	private int tradeId;

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
}
