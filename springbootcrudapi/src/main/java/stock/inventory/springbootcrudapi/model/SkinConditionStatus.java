package stock.inventory.springbootcrudapi.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDateTime;

@Entity(name="skinConditionStatus")
@Table(name="tb_skin_condition_status")
public class SkinConditionStatus {

	@Id
	@Column(name="status_id")
	private int statusId;
	
	@Column(name="skin_condition")
	private String skinCondition;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getSkinCondition() {
		return skinCondition;
	}

	public void setSkinCondition(String skinCondition) {
		this.skinCondition = skinCondition;
	}


}
