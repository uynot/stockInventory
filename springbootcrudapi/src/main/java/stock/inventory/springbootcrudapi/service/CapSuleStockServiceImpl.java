package stock.inventory.springbootcrudapi.service;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import stock.inventory.springbootcrudapi.model.CapsuleStock;

@Service
public class CapSuleStockServiceImpl implements CapsuleStockService{

	@Autowired
	private EntityManager em;
	
	@Transactional
	@Override
	public List<CapsuleStock> get() {
		return null;
	}

	@Transactional
	@Override
	public CapsuleStock get(int tradeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void save(CapsuleStock capsuleStock) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(int tradeId) {
		// TODO Auto-generated method stub
		
	}

}
