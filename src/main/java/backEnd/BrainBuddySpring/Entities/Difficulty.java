package backEnd.BrainBuddySpring.Entities;



import jakarta.persistence.*;

@Entity
@Table(name="difficulty")
public class Difficulty {
    
    @Id
	@Column(name="difficulty_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer difficultyId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="game_id")
	private Games gameId;
	
	@Column(name="point")
	private Integer point;
	@Column(name="nb_mistake")
	private Integer nbMistake;
	@Column(name="nb_lifes")
	private Integer nbLifes;
	@Column(name="timer")
	private Integer timer;
	
	public Integer getDifficultyId() {
		return difficultyId;
	}
	public void setDifficultyId(Integer difficultyId) {
		this.difficultyId = difficultyId;
	}
	public Games getGameId() {
		return gameId;
	}
	public void setGameId(Games gameId) {
		this.gameId = gameId;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Integer getNbMistake() {
		return nbMistake;
	}
	public void setNbMistake(Integer nbMistake) {
		this.nbMistake = nbMistake;
	}
	public Integer getNbLifes() {
		return nbLifes;
	}
	public void setNbLifes(Integer nbLifes) {
		this.nbLifes = nbLifes;
	}
	public Integer getTimer() {
		return timer;
	}
	public void setTimer(Integer timer) {
		this.timer = timer;
	}
}
