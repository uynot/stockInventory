package stock.inventory.springbootcrudapi.dao;
import java.util.List;

import stock.inventory.springbootcrudapi.model.CapsuleStock;

public interface CapsuleStockDAO {
	
	List<CapsuleStock> getCapsuleStockFull();
	
	CapsuleStock get(int tradeId);
	
	void saveCapsuleStock(CapsuleStock capsuleStock);
	
	void delete(int tradeId);
	
}
