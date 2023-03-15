package stock.inventory.springbootcrudapi.dao;
import java.util.List;

import stock.inventory.springbootcrudapi.model.CapsuleStock;

public interface CapsuleStockDAO {
	
	List<CapsuleStock> getCapsuleStockFull();
	
	CapsuleStock getCapsuleStockSingle(int tradeId);
	
	String saveOrUpdateCapsuleStock(CapsuleStock capsuleStock);
	
	String deleteCapsuleStock(int tradeId);

	Object[] getCapsuleROIHybrid(int tradeId);
	
}
