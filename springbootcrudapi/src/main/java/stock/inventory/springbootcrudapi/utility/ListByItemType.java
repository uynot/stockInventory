package stock.inventory.springbootcrudapi.utility;

import java.util.List;
import java.util.Map;

import stock.inventory.springbootcrudapi.model.ItemStock;

//@data
public class ListByItemType {
	
	private List<Map<String,Object>> Capsule;
	private List<Map<String,Object>> Case;
	private List<Map<String,Object>> Sticker;
	private List<Map<String,Object>> Skin;
	
	public List<Map<String, Object>> getCapsule() {
		return Capsule;
	}
	public void setCapsule(List<Map<String, Object>> capsule) {
		Capsule = capsule;
	}
	public List<Map<String, Object>> getCase() {
		return Case;
	}
	public void setCase(List<Map<String, Object>> case1) {
		Case = case1;
	}
	public List<Map<String, Object>> getSticker() {
		return Sticker;
	}
	public void setSticker(List<Map<String, Object>> sticker) {
		Sticker = sticker;
	}
	public List<Map<String, Object>> getSkin() {
		return Skin;
	}
	public void setSkin(List<Map<String, Object>> skin) {
		Skin = skin;
	}
	
	
}
