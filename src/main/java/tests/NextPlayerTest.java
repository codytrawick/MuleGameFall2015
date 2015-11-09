
import game.model.GameInfo;
import game.model.IModel;
import game.model.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * This test will see if the nextPlayer method functions correctly
 */
public class NextPlayerTest {

    IModel gameInfo;

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
    }

    @Test
    public void cycleRound() {
        for (int i = 0; i < 4; i++) {
            assertTrue("All players are in round one", gameInfo.getCurrentRound() == 1);
            gameInfo.nextPlayer();
        }
        assertTrue("The current round is now Round 2", gameInfo.getCurrentRound() == 2);
    }
}
