package id.co.skyforce.basicjsf.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue ("F")

public class FreelanceEmployee extends Employee{
	
	@Column(name = "rate_hour")
	private int rateHour;

	public int getRateHour() {
		return rateHour;
	}

	public void setRateHour(int rateHour) {
		this.rateHour = rateHour;
	}
	
	
	

}
