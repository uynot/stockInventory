package stock.inventory.springbootcrudapi.service;

import java.util.List;
import stock.inventory.springbootcrudapi.model.CapsuleStock;

public interface CapsuleStockService {
	
	List<CapsuleStock> getCapsuleStockFull();
	
	CapsuleStock getCapsuleStockSingle(int tradeId);
	
	String saveOrUpdateCapsuleStock(CapsuleStock capsuleStock);
	
	String deleteCapsuleStock(int tradeId);
	
	Object[] getCapsuleROIHybrid(int tradeId);
}
