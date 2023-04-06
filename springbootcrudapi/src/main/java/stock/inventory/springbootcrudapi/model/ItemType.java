package stock.inventory.springbootcrudapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="itemType")
@Table(name = "item_type")
public class ItemType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "item_type_id")
    private int itemTypeId;

    @Column(name = "item_type")
    private String itemType;

	public int getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(int itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

    
}
