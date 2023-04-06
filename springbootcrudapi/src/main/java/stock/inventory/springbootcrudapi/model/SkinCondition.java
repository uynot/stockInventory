package stock.inventory.springbootcrudapi.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="skinCondition")
@Table(name = "skin_condition")
public class SkinCondition {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "skin_condition_id")
    private int skinConditionId;

    @Column(name = "skin_condition")
    private String skinCondition;

	public int getSkinConditionId() {
		return skinConditionId;
	}

	public void setSkinConditionId(int skinConditionId) {
		this.skinConditionId = skinConditionId;
	}

	public String getSkinCondition() {
		return skinCondition;
	}

	public void setSkinCondition(String skinCondition) {
		this.skinCondition = skinCondition;
	}

    
}

