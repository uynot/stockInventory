package stock.inventory.springbootcrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stock.inventory.springbootcrudapi.dao.StockDAO;
import stock.inventory.springbootcrudapi.model.ItemStock;
import stock.inventory.springbootcrudapi.utility.QuantityByItemType;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	private StockDAO stockDAO;
	
	@Override
	public List<ItemStock> getStockFull() {
		return stockDAO.getStockFull();
	}
	
	public QuantityByItemType getQuantityByItemTypeFull() {
		return stockDAO.getQuantityByItemTypeFull();
	}
	
	@Override
	public List<ItemStock> getCapsuleFull() {
		return stockDAO.getCapsuleFull();
	}
	
	@Override
	public List<ItemStock> getCaseFull() {
		return stockDAO.getCaseFull();
	}
	
	@Override
	public List<ItemStock> getSkinFull() {
		return stockDAO.getSkinFull();
	}
	
	@Override
	public List<ItemStock> getStickerFull() {
		return stockDAO.getStickerFull();
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
