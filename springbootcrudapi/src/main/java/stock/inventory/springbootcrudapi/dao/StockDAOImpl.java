package stock.inventory.springbootcrudapi.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
//import org.hibernate.query.Query;

import org.hibernate.Session;
import stock.inventory.springbootcrudapi.model.ItemStock;

@Repository
public class StockDAOImpl implements StockDAO {

	@Autowired
	private EntityManager em;
	
	//@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemStock> getStockFull() {
//		hibernate
//		Query query = em.createQuery("from capsuleStock", ItemStock.class);
//		List<ItemStock> capsuleList = query.getResultList();
		
		List<ItemStock> itemStockList = new ArrayList<ItemStock>();
		ItemStock itemStock = null;
		String sql = "SELECT "
				   + "s.stock_id, item.item_name, type.item_type, t.price as stock_in_price , p.current_price "
				   + "FROM item_stock s "
				   + "JOIN item item ON item.item_id = s.item_id_fk "
				   + "JOIN item_type type ON type.item_type_id = s.item_type_id_fk "
				   + "JOIN transaction t ON t.transaction_id = s.transaction_id_fk "
				   + "JOIN price p ON p.item_id_fk = item.item_id "
				   + "WHERE t.action = 'buy' "
				   + "AND s.status = 'available'";
	
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> results = query.getResultList();
		for (Object[] objects : results) {
			int i = 0;
			itemStock = new ItemStock();
			itemStock.setStockId((int)objects[i++]);
			itemStock.setItemName((String) objects[i++]);
			itemStock.setItemType((String)objects[i++]);
			itemStock.setStockInPrice((float)objects[i++]);
			itemStock.setCurrentPrice((float)objects[i++]);
			itemStockList.add(itemStock);
		}

		return itemStockList;
	}

//	@Override
//	public ItemStock getCapsuleStockSingle(int tradeId) {
//		Session currentSession = em.unwrap(Session.class);
//		ItemStock capsuleStock = currentSession.get(ItemStock.class, tradeId);
//		
//		return capsuleStock;
//	}

//	@SuppressWarnings("deprecation")
//	@Override
//	public String saveOrUpdateCapsuleStock(ItemStock capsuleStock) {
//		String result = "";
//		Session currentSession = em.unwrap(Session.class);
//		
//		try {
//			currentSession.saveOrUpdate(capsuleStock);
//			result = "save or update success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = "save or update failed";
//		}
//		
//		return result;
//	}

//	@SuppressWarnings("deprecation")
//	@Override
//	public String deleteCapsuleStock(int tradeId) {
//		String result = "";
//		Session currentSession = em.unwrap(Session.class);
//		ItemStock capsuleStock = currentSession.get(ItemStock.class, tradeId);
//		
//		try {
//			currentSession.delete(capsuleStock);
//		    result = "deletion success";
//		} catch (Exception e) {
//			result = "deletion failed";
//		}
//		
//		return result;
//	}

//	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
//	@Override
//	public Object[] getCapsuleROIHybrid(int tradeId) {
//		Session session = em.unwrap(Session.class);
//
//		String sql = "SELECT "
//					+ "	`name`.item_name, "
//				   + "	capsule.quantity, capsule.buy_in_price, capsule.cashout_price, "
//			       + "	currentPrice.current_price "
//			       + "FROM tb_capsule_stock capsule "
//			       + "LEFT JOIN tb_current_price currentPrice ON currentPrice.item_id = capsule.item_id "
//			       + "JOIN tb_item_name `name` ON `name`.item_id = capsule.item_id "
//			       + "WHERE capsule.trade_id = :tradeId";
//
//		Query query = session.createNativeQuery(sql);
//		query.setParameter("tradeId", tradeId);
//
//		Object[] rowValues = null;
//	    List<Object[]> results = query.list();
//	    if(!results.isEmpty()) {
//	        Object[] row = results.get(0);
//	        List<Object> rowList = Arrays.asList(row);
//	        rowValues = rowList.toArray(new Object[rowList.size()]);
//	    }
//
//	    return rowValues;
//	}
}
