
import game.model.GameInfo;
import game.model.IModel;
import game.model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This test will see if the nextPlayer method functions correctly
 */
public class NextPlayerTest {

    IModel gameInfo;
    IModel fastGame;

    @Before
    public void setUp() {
        gameInfo = new GameInfo();
        gameInfo.setMapType("Standard");
        gameInfo.setDifficulty("Normal");
        gameInfo.setPlayerNumber(4);
        gameInfo.createNewPlayer("Blossom", "Red", "Humanoid");
        gameInfo.createNewPlayer("Bubbles", "Blue", "Humanoid");
        gameInfo.createNewPlayer("Buttercup", "Green", "Humanoid");
        gameInfo.createNewPlayer("John Cena", "Yellow", "Humanoid");
        gameInfo.createRound(1);

        fastGame = new GameInfo();
        fastGame.setMapType("Standard");
        fastGame.setDifficulty("Normal");
        fastGame.setPlayerNumber(1);
        fastGame.createNewPlayer("John Cena", "Green", "Humanoid");
        fastGame.createRound(1);
    }

    @Test
    public void testPlayerIncrement() {
        for (int i = 0; i < 4; i++) {
            assertTrue("Current Player was not incremented", gameInfo.getCurrentPlayerNumber() == i);
            gameInfo.nextPlayer();
        }
    }

    @Test
    public void cycleRound() {
        for (int i = 0; i < 4; i++) {
            assertTrue("All players are in round one", gameInfo.getCurrentRound() == 1);
            gameInfo.nextPlayer();
        }
        assertTrue("The current round is now Round 2", gameInfo.getCurrentRound() == 2);
    }

    @Test
    public void countRounds() {
        for (int i = 1; i < 13; i++) {
            assertTrue("Current round number is incorrect", fastGame.getCurrentRound() == i);
            fastGame.nextPlayer();
        }
        for (int i = 0; i < 5; i++) {
            assertTrue("Game should not have more than 12 rounds", fastGame.getCurrentRound() < 13);
            fastGame.nextPlayer();
        }
    }
}
