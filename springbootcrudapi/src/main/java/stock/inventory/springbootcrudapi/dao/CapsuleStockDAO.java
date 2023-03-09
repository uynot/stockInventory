package stock.inventory.springbootcrudapi.dao;
import java.util.List;

import stock.inventory.springbootcrudapi.model.CapsuleStock;

public interface CapsuleStockDAO {
	
	List<CapsuleStock> getCapsuleStockFull();
	
	//CapsuleStock get(int tradeId); 	//get 1 record only
	
	String saveOrUpdateCapsuleStock(CapsuleStock capsuleStock);
	
	void delete(int tradeId);
	
}
