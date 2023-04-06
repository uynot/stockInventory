package stock.inventory.springbootcrudapi.service;

import java.util.List;
import stock.inventory.springbootcrudapi.model.ItemStock;

public interface CapsuleStockService {
	
	List<ItemStock> getCapsuleStockFull();
	
	ItemStock getCapsuleStockSingle(int tradeId);
	
	String saveOrUpdateCapsuleStock(ItemStock capsuleStock);
	
	String deleteCapsuleStock(int tradeId);
	
	Object[] getCapsuleROIHybrid(int tradeId);
}
