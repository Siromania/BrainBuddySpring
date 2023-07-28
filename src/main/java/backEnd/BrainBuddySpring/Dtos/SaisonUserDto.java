package backEnd.BrainBuddySpring.Dtos;

import java.util.Date;

import backEnd.BrainBuddySpring.Entities.Saison;
import backEnd.BrainBuddySpring.Entities.Users;

public class SaisonUserDto {
	private Integer placement;
	private Date dateTime;
	private Users user;
	private Saison saison;
	
	public SaisonUserDto() {}

	public Integer getPlacement() {
		return placement;
	}

	public void setPlacement(Integer placement) {
		this.placement = placement;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Saison getSaison() {
		return saison;
	}

	public void setSaison(Saison saison) {
		this.saison = saison;
	}
	
}
