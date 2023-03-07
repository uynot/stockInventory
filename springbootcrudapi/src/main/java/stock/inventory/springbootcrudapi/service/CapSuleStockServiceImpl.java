package stock.inventory.springbootcrudapi.service;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import stock.inventory.springbootcrudapi.dao.CapsuleStockDAO;
import stock.inventory.springbootcrudapi.dao.CapsuleStockDAOImpl;
import stock.inventory.springbootcrudapi.model.CapsuleStock;
import stock.inventory.springbootcrudapi.response.SaveCapsuleStockResponse;

@Service
public class CapSuleStockServiceImpl implements CapsuleStockService{

	@Autowired
	private CapsuleStockDAO capsuleStockDAO;
	
	@Transactional
	@Override
	public List<CapsuleStock> getCapsuleStockFull() {
		return capsuleStockDAO.getCapsuleStockFull();
	}

	@Transactional
	@Override
	public CapsuleStock get(int tradeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public String saveCapsuleStock(CapsuleStock capsuleStock) {
		return capsuleStockDAO.saveCapsuleStock(capsuleStock);
	}

	@Transactional
	@Override
	public void delete(int tradeId) {
		// TODO Auto-generated method stub
		
	}

}
