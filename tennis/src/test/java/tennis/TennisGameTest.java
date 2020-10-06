package tennis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tennis.common.Constants;
import tennis.game.Game;
import tennis.models.player.Player;
import tennis.models.player.PointEnum;

public class TennisGameTest {
	Player player1 = new Player("Federer", 0, PointEnum.LOVE);
	Player player2 = new Player("Nadal", 0, PointEnum.LOVE);

	Game game = new Game();

	@Test
	public void testGameScoreWithNewRule() {
		game.setPlayer1(player1);
		game.setPlayer2(player2);

		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();

		assertEquals(player2, game.winnerWithNewRule());

	}

	@Test
	public void testGameScoreWithAdvantage() {
		game.setPlayer1(player1);
		game.setPlayer2(player2);

		player1.winPoint(); // 15,0
		player2.winPoint();// 15,15
		assertTrue(game.getScore().contains(Constants.ALL.name()));
		
		player1.winPoint();// 30,15
		player1.winPoint();// 40,15
		player2.winPoint();// 40,30
		player2.winPoint();// 40,40 = deuce
		player2.winPoint();// Advantage Player 2
		assertTrue(game.getScore().contains(Constants.ADVANTAGE.name()));
		player1.winPoint();// Deuce

		assertTrue(Constants.DEUCE.name().equals(game.getScore()));

		player1.winPoint();// Advantage Player 1
		player1.winPoint(); // Game Player 1
		assertEquals(player2, game.winnerWithNewRule());

	}

}
