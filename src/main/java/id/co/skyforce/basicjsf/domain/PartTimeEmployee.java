package id.co.skyforce.basicjsf.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PT")

public class PartTimeEmployee extends Employee{
	
	@Column(name = "work_per_hour")
	private int workPerHour;

	public int getWorkPerHour() {
		return workPerHour;
	}

	public void setWorkPerHour(int workPerHour) {
		this.workPerHour = workPerHour;
	}
	
	

}
