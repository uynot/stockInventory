package stock.inventory.springbootcrudapi.service;

import java.util.List;
import stock.inventory.springbootcrudapi.model.CapsuleStock;

public interface CapsuleStockService {
	
	List<CapsuleStock> getCapsuleStockFull();
	
	CapsuleStock get(int tradeId);
	
	void saveCapsuleStock(CapsuleStock capsuleStock);
	
	void delete(int tradeId);
	
}
