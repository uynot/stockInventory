package stock.inventory.springbootcrudapi.model;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;


@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "price_id")
    private int priceId;

    @ManyToOne
    @JoinColumn(name = "item_id_fk")
    private Item item;

    @Column(name = "current_price")
    private float currentPrice;

    @Column(name = "lowest_record")
    private Float lowestRecord;

    @Column(name = "highest_record")
    private Float highestRecord;

    @Column(name = "last_updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastUpdatedTime;

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Float getLowestRecord() {
		return lowestRecord;
	}

	public void setLowestRecord(Float lowestRecord) {
		this.lowestRecord = lowestRecord;
	}

	public Float getHighestRecord() {
		return highestRecord;
	}

	public void setHighestRecord(Float highestRecord) {
		this.highestRecord = highestRecord;
	}

	public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

    
}