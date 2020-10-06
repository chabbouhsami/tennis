/**
 * 
 */
package tennis.game;

import java.util.Objects;

import tennis.common.Constants;
import tennis.models.player.Player;
import tennis.models.player.PointEnum;

/**
 * @author Chabbouh
 *
 */
public class Game {

	private Player player1;
	private Player player2;

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public String getPoint() {
		if (Objects.isNull(player1) || Objects.isNull(player2)) {
			return "Game not started yet";
		}

		return this.player1.getPoint().getName() + " " + this.player2.getPoint().getName();
	}

	public Player winnerWithNewRule() {
		if (hasWinnerWithNewRule()) {
			return winner();
		}
		return null;
	}

	private Player winner() {
		return this.player1.getPoint().compareTo(this.player2.getPoint()) > 0 ? this.player1 : this.player2;

	}

	private boolean hasWinnerWithNewRule() {
		return this.player1.isInAdvantage() || this.player2.isInAdvantage();
	}

	public String getScore() {

		if (hasWinner()) {
			return winner().getName() + " " + Constants.WINS.name();
		}

		if (isDeuce()) {
			return (isAdvantage()) ? Constants.DEUCE.name() : Constants.ALL.name();
		}

		if (isAdvantage()) {
			return Constants.ADVANTAGE.name() + " " + winner().getName();
		}

		return this.getPoint();
	}

	private boolean isDeuce() {
		return player1.getPoint().getPoint() - player2.getPoint().getPoint() == 0;
	}

	private boolean isAdvantage() {
		return PointEnum.ADVANTAGE.equals(player1.getPoint()) || PointEnum.ADVANTAGE.equals(player2.getPoint());
	}

	private boolean hasWinner() {
		return isAdvantage() && Math.abs(player1.getPoint().getPoint() - player2.getPoint().getPoint()) > 1;
	}

}
