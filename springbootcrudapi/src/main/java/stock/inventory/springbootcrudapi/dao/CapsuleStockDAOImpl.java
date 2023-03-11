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
	public List<CapsuleStock> getCapsuleStockFull() {
		Session currentSession = em.unwrap(Session.class);
		Query<CapsuleStock> query = currentSession.createQuery("from capsuleStock", CapsuleStock.class);
		List<CapsuleStock> capsuleList = query.getResultList();
		
		return capsuleList;
	}

	@Override
	public CapsuleStock getCapsuleStockSingle(int tradeId) {
		Session currentSession = em.unwrap(Session.class);
		CapsuleStock capsuleStock = currentSession.get(CapsuleStock.class, tradeId);
		
		return capsuleStock;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String saveOrUpdateCapsuleStock(CapsuleStock capsuleStock) {
		String result = "";
		Session currentSession = em.unwrap(Session.class);
		
		try {
			currentSession.saveOrUpdate(capsuleStock);
			result = "save or update success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "save or update failed";
		}
		
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String deleteCapsuleStock(int tradeId) {
		String result = "";
		Session currentSession = em.unwrap(Session.class);
		CapsuleStock capsuleStock = currentSession.get(CapsuleStock.class, tradeId);
		
		try {
			currentSession.delete(capsuleStock);
		    result = "deletion success";
		} catch (Exception e) {
			result = "deletion failed";
		}
		
		return result;
	}
}
