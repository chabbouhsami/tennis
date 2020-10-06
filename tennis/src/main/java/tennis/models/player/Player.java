/**
 * 
 */
package tennis.models.player;

/**
 * @author Chabbouh
 *
 */
public class Player {

	private String name;
	private int score;
	private PointEnum point;

	public Player() {
		super();
	}

	public Player(String name, int score, PointEnum point) {
		super();
		this.name = name;
		this.score = score;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public PointEnum getPoint() {
		return point;
	}

	public void setPoint(PointEnum point) {
		this.point = point;
	}

	public void winPoint() {
		this.setPoint(PointEnum.getPoint(point.getPoint() + 1));
	}

	public boolean isInAdvantage() {
		return PointEnum.ADVANTAGE.equals(point);
	}

}
