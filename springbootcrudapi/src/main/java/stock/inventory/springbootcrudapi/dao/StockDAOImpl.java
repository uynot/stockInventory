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

import stock.inventory.springbootcrudapi.CustomEntity.QuantityByItemType;
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
				   + "	s.stock_id, item.item_name, type.item_type, t.price as stock_in_price , p.current_price "
				   + "FROM item_stock s "
				   + "JOIN item item ON item.item_id = s.item_id_fk "
				   + "JOIN item_type type ON type.item_type_id = item.item_type_id_fk "
				   + "JOIN transaction t ON t.transaction_id = s.transaction_id_fk "
				   + "JOIN price p ON p.item_id_fk = item.item_id "
				   + "WHERE t.action = 'buy' "
				   + "	AND s.status = 'available' "
				   + "ORDER BY t.trade_time "
				   + "	AND s.stock_id";
	
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
	
	public QuantityByItemType getQuantityByItemTypeFull() {
		QuantityByItemType quantityByItemType = new QuantityByItemType();
		
		String capsuleCountSql = "SELECT COUNT(`type`.item_type_id) AS capsule_count "
							   + "FROM item_stock AS capsule "
							   + "JOIN item item ON item.item_id = capsule.item_id_fk "
							   + "JOIN item_type `type` ON `type`.item_type_id = item.item_type_id_fk "
							   + "WHERE `type`.item_type_id = '1'";
		Query capsuleQuery = em.createNativeQuery(capsuleCountSql);
		int capsuleCount = ((Number) capsuleQuery.getSingleResult()).intValue();
		quantityByItemType.setCapsule(capsuleCount);
		
		String caseCountSql = "SELECT COUNT(`type`.item_type_id) AS case_count "
							+ "FROM item_stock AS `case` "
							+ "JOIN item item ON item.item_id = `case`.item_id_fk "
							+ "JOIN item_type `type` ON `type`.item_type_id = item.item_type_id_fk "
							+ "WHERE `type`.item_type_id = '2'";
		Query caseQuery = em.createNativeQuery(caseCountSql);
		int caseCount = ((Number) caseQuery.getSingleResult()).intValue();
		quantityByItemType.setCase(caseCount);
		
		String skinCountSql = "SELECT COUNT(`type`.item_type_id) AS skin_count "
							+ "FROM item_stock AS skin "
							+ "JOIN item item ON item.item_id = skin.item_id_fk "
							+ "JOIN item_type `type` ON `type`.item_type_id = item.item_type_id_fk "
							+ "WHERE `type`.item_type_id = '3'";
		Query skinQuery = em.createNativeQuery(skinCountSql);
		int skinCount = ((Number) skinQuery.getSingleResult()).intValue();
		quantityByItemType.setSkin(skinCount);
		
		String stickerCountSql = "SELECT COUNT(`type`.item_type_id) AS sticker_count "
							   + "FROM item_stock AS sticker "
							   + "JOIN item item ON item.item_id = sticker.item_id_fk "
							   + "JOIN item_type `type` ON `type`.item_type_id = item.item_type_id_fk "
							   + "WHERE `type`.item_type_id = '4'";
		Query stickerQuery = em.createNativeQuery(stickerCountSql);
		int stickerCount = ((Number) stickerQuery.getSingleResult()).intValue();
		quantityByItemType.setSticker(stickerCount);
		
		return quantityByItemType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemStock> getCapsuleFull() {
		List<ItemStock> capsuleList = new ArrayList<ItemStock>();
		ItemStock capsule = null;
		String sql = "SELECT "
				   + "	s.stock_id, item.item_name, type.item_type, t.price as stock_in_price , p.current_price "
				   + "FROM item_stock s "
				   + "JOIN item item ON item.item_id = s.item_id_fk "
				   + "JOIN item_type type ON type.item_type_id = item.item_type_id_fk "
				   + "JOIN transaction t ON t.transaction_id = s.transaction_id_fk "
				   + "JOIN price p ON p.item_id_fk = item.item_id "
				   + "WHERE t.action = 'buy' "
				   + "	AND type.item_type_id = '1' "
				   + "	AND s.status = 'available' "
				   + "ORDER BY t.trade_time "
				   + "	AND s.stock_id";
	
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> results = query.getResultList();
		for (Object[] objects : results) {
			int i = 0;
			capsule = new ItemStock();
			capsule.setStockId((int)objects[i++]);
			capsule.setItemName((String) objects[i++]);
			capsule.setItemType((String)objects[i++]);
			capsule.setStockInPrice((float)objects[i++]);
			capsule.setCurrentPrice((float)objects[i++]);
			capsuleList.add(capsule);
		}

		return capsuleList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemStock> getCaseFull() {
		List<ItemStock> caseList = new ArrayList<ItemStock>();
		ItemStock cases = null;
		String sql = "SELECT "
				   + "	s.stock_id, item.item_name, type.item_type, t.price as stock_in_price , p.current_price "
				   + "FROM item_stock s "
				   + "JOIN item item ON item.item_id = s.item_id_fk "
				   + "JOIN item_type type ON type.item_type_id = item.item_type_id_fk "
				   + "JOIN transaction t ON t.transaction_id = s.transaction_id_fk "
				   + "JOIN price p ON p.item_id_fk = item.item_id "
				   + "WHERE t.action = 'buy' "
				   + "	AND type.item_type_id = '2' "
				   + "	AND s.status = 'available' "
				   + "ORDER BY t.trade_time "
				   + "	AND s.stock_id";
	
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> results = query.getResultList();
		for (Object[] objects : results) {
			int i = 0;
			cases = new ItemStock();
			cases.setStockId((int)objects[i++]);
			cases.setItemName((String) objects[i++]);
			cases.setItemType((String)objects[i++]);
			cases.setStockInPrice((float)objects[i++]);
			cases.setCurrentPrice((float)objects[i++]);
			caseList.add(cases);
		}

		return caseList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemStock> getSkinFull() {
		List<ItemStock> skinList = new ArrayList<ItemStock>();
		ItemStock skin = null;
		String sql = "SELECT "
				   + "	s.stock_id, item.item_name, type.item_type, t.price as stock_in_price , p.current_price "
				   + "FROM item_stock s "
				   + "JOIN item item ON item.item_id = s.item_id_fk "
				   + "JOIN item_type type ON type.item_type_id = item.item_type_id_fk "
				   + "JOIN transaction t ON t.transaction_id = s.transaction_id_fk "
				   + "JOIN price p ON p.item_id_fk = item.item_id "
				   + "WHERE t.action = 'buy' "
				   + "	AND type.item_type_id = '3' "
				   + "	AND s.status = 'available' "
				   + "ORDER BY t.trade_time "
				   + "	AND s.stock_id";
	
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> results = query.getResultList();
		for (Object[] objects : results) {
			int i = 0;
			skin = new ItemStock();
			skin.setStockId((int)objects[i++]);
			skin.setItemName((String) objects[i++]);
			skin.setItemType((String)objects[i++]);
			skin.setStockInPrice((float)objects[i++]);
			skin.setCurrentPrice((float)objects[i++]);
			skinList.add(skin);
		}

		return skinList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemStock> getStickerFull() {
		List<ItemStock> stickerList = new ArrayList<ItemStock>();
		ItemStock sticker = null;
		String sql = "SELECT "
				   + "	s.stock_id, item.item_name, type.item_type, t.price as stock_in_price , p.current_price "
				   + "FROM item_stock s "
				   + "JOIN item item ON item.item_id = s.item_id_fk "
				   + "JOIN item_type type ON type.item_type_id = item.item_type_id_fk "
				   + "JOIN transaction t ON t.transaction_id = s.transaction_id_fk "
				   + "JOIN price p ON p.item_id_fk = item.item_id "
				   + "WHERE t.action = 'buy' "
				   + "	AND type.item_type_id = '4' "
				   + "	AND s.status = 'available' "
				   + "ORDER BY t.trade_time "
				   + "	AND s.stock_id";
	
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> results = query.getResultList();
		for (Object[] objects : results) {
			int i = 0;
			sticker = new ItemStock();
			sticker.setStockId((int)objects[i++]);
			sticker.setItemName((String) objects[i++]);
			sticker.setItemType((String)objects[i++]);
			sticker.setStockInPrice((float)objects[i++]);
			sticker.setCurrentPrice((float)objects[i++]);
			stickerList.add(sticker);
		}

		return stickerList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemStock> getStockByItemType(String itemType) {
		List<ItemStock> stockByItemTypeList = new ArrayList<ItemStock>();
		ItemStock stock= null;
		String sql = "SELECT "
				+ "   s.stock_id, item.item_name, type.item_type, t.price as stock_in_price , p.current_price "
				+ "FROM item_stock s "
				+ "JOIN item item ON item.item_id = s.item_id_fk "
				+ "JOIN item_type type ON type.item_type_id = item.item_type_id_fk "
				+ "JOIN transaction t ON t.transaction_id = s.transaction_id_fk "
				+ "JOIN price p ON p.item_id_fk = item.item_id "
				+ "WHERE t.action = 'buy' "
				+ "	AND type.item_type = '" + itemType + "' "
				+ "	AND s.status = 'available' "
				+ "ORDER BY t.trade_time "
				+ "	AND s.stock_id";
	
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> results = query.getResultList();
		for (Object[] objects : results) {
			int i = 0;
			stock = new ItemStock();
			stock.setStockId((int)objects[i++]);
			stock.setItemName((String) objects[i++]);
			stock.setItemType((String)objects[i++]);
			stock.setStockInPrice((float)objects[i++]);
			stock.setCurrentPrice((float)objects[i++]);
			stockByItemTypeList.add(stock);
		}

		return stockByItemTypeList;
	}
	
	/*public String assignedToSSA(Elder elder) {

		Elder e = em.find(Elder.class, elder.getElderId());
		e.setResponsibleSSA(elder.getResponsibleSSA());
		em.merge(e);

		return "Applicant had been assigned.";
	} */
	
	//query.setParameter("elderId", elderId);
	
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
