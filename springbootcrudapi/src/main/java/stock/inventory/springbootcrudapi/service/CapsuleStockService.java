package stock.inventory.springbootcrudapi.service;

import java.util.List;
import stock.inventory.springbootcrudapi.model.CapsuleStock;

public interface CapsuleStockService {
	
	List<CapsuleStock> get();
	
	CapsuleStock get(int tradeId);
	
	void save(CapsuleStock capsuleStock);
	
	void delete(int tradeId);
	
}
