package stock.inventory.springbootcrudapi.CustomEntity;

import java.util.List;
import java.util.Map;

import stock.inventory.springbootcrudapi.model.ItemStock;

//@data
public class QuantityByItemType {
	
	private int Capsule = 0;
	private int Case = 0;
	private int Sticker = 0;
	private int Skin = 0;
	
	public int getCapsule() {
		return Capsule;
	}
	public void setCapsule(int capsule) {
		Capsule = capsule;
	}
	public int getCase() {
		return Case;
	}
	public void setCase(int case1) {
		Case = case1;
	}
	public int getSticker() {
		return Sticker;
	}
	public void setSticker(int sticker) {
		Sticker = sticker;
	}
	public int getSkin() {
		return Skin;
	}
	public void setSkin(int skin) {
		Skin = skin;
	}
}
