package stock.inventory.springbootcrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stock.inventory.springbootcrudapi.dao.StockDAO;
import stock.inventory.springbootcrudapi.model.ItemStock;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	private StockDAO stockDAO;
	
//	@Transactional
	@Override
	public List<ItemStock> getStockFull() {
		return stockDAO.getStockFull();
	}

//	@Transactional
//	@Override
//	public ItemStock getCapsuleStockSingle(int tradeId) {
//		return capsuleStockDAO.getCapsuleStockSingle(tradeId);
//	}

//	@Transactional
//	@Override
//	public String saveOrUpdateCapsuleStock(ItemStock capsuleStock) {
//		return capsuleStockDAO.saveOrUpdateCapsuleStock(capsuleStock);
//	}

//	@Transactional
//	@Override
//	public String deleteCapsuleStock(int tradeId) {
//		return capsuleStockDAO.deleteCapsuleStock(tradeId);
//	}

//	@Transactional
//	@Override
//	public Object[] getCapsuleROIHybrid(int tradeId) {
//		return capsuleStockDAO.getCapsuleROIHybrid(tradeId);
//	}
}
