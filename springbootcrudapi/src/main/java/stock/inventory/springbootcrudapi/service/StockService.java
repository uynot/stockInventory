package stock.inventory.springbootcrudapi.service;

import java.util.List;
import stock.inventory.springbootcrudapi.model.ItemStock;

public interface StockService {
	
	List<ItemStock> getStockFull();
	
	//ItemStock getCapsuleStockSingle(int tradeId);
	
	//String saveOrUpdateCapsuleStock(ItemStock capsuleStock);
	
	//String deleteCapsuleStock(int tradeId);
	
	//Object[] getCapsuleROIHybrid(int tradeId);
}
