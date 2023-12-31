package backEnd.BrainBuddySpring.Entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="scores")
public class Scores {
	
	@Id
	@Column(name="score_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scoreId;
	 
	@Column(name="timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;
	
	@Column
	private Integer level;
	
	@Column
	private Integer timer;
	
	@Column(name="nb_mistake")
	private Integer nbMistake;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="game_id")
	private Games game;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Games getGames() {
		return game;
	}

	public void setGames(Games games) {
		this.game = games;
	}

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getTimer() {
		return timer;
	}

	public void setTimer(Integer timer) {
		this.timer = timer;
	}

	public Integer getNbMistake() {
		return nbMistake;
	}

	public void setNbMistake(Integer nbMistake) {
		this.nbMistake = nbMistake;
	}


	
	
}