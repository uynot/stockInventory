package stock.inventory.springbootcrudapi.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import stock.inventory.springbootcrudapi.model.CapsuleStock;

@Repository
public class CapsuleStockDAOImpl implements CapsuleStockDAO {

	@Autowired
	private EntityManager em;
	
	@Transactional
	@Override
	public List<CapsuleStock> get() {
		Session currentSession = em.unwrap(Session.class);
		Query<CapsuleStock> query = currentSession.createQuery("from CapsuleStock", CapsuleStock.class);
		List<CapsuleStock> capsuleList = query.getResultList();
		return capsuleList;
	}

	@Override
	public CapsuleStock get(int tradeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CapsuleStock capsuleStock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int tradeId) {
		// TODO Auto-generated method stub
		
	}

}
