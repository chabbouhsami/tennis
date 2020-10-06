/**
 * 
 */
package tennis.models.player;

/**
 * @author Chabbouh
 *
 */
public enum PointEnum {

	LOVE(0, "love"), FIFTEEN(1, "fifteen"), THIRTY(2, "thirty"), FORTY(3, "forty"), ADVANTAGE(4, "advantage");

	private int point;
	private String name;

	PointEnum(int point, String name) {
		this.point = point;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPoint() {
		return this.point;
	}

	public static PointEnum getPoint(int score) {

		for (PointEnum scoreEnum : PointEnum.values()) {
			if (score >= 4) {
				return ADVANTAGE;
			} else if (scoreEnum.point == score) {
				return scoreEnum;
			}
		}

		throw new UnsupportedOperationException();
	}

}
