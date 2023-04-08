package stock.inventory.springbootcrudapi.dao;
import java.util.List;

import stock.inventory.springbootcrudapi.model.ItemStock;
import stock.inventory.springbootcrudapi.utility.QuantityByItemType;

public interface StockDAO {
	
	List<ItemStock> getStockFull();

	QuantityByItemType getQuantityByItemTypeFull();
	
	//ItemStock getCapsuleStockSingle(int tradeId);
	
	//String saveOrUpdateCapsuleStock(ItemStock capsuleStock);
	
	//String deleteCapsuleStock(int tradeId);

	//Object[] getCapsuleROIHybrid(int tradeId);
	
}
