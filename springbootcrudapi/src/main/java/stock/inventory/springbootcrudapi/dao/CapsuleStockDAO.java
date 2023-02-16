package stock.inventory.springbootcrudapi.dao;
import java.util.List;

import stock.inventory.springbootcrudapi.model.CapsuleStock;

public interface CapsuleStockDAO {
	
	List<CapsuleStock> get();
	
	CapsuleStock get(int tradeId);
	
	void save(CapsuleStock capsuleStock);
	
	void delete(int tradeId);
	
}
