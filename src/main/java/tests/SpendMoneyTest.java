package tests;

import game.model.GameInfo;
import game.model.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * Jesse Hayes M10 JUnit 11/4/15
 */

public class SpendMoneyTest {
    Player player;
    GameInfo info;

    @Before
    public void setUp() {
        info = new GameInfo();
        info.setPlayerNumber(1);
        info.createNewPlayer("Bob", "Red", "Mechanoid");
        //this player gets $1000 to start by virtue of being a mechanoid
        player = info.getPlayers().get(0);
    }

    @Test
    public void testValidPurchase() {
        assertTrue(player.spendMoney(600));
        assertEquals(400, player.getMoney());
    }

    @Test
    public void testInvalidPurchase() {
        assertFalse(player.spendMoney(1001));
        assertEquals(1000, player.getMoney());
    }

    @Test
    public void testExactCash() {
        assertTrue(player.spendMoney(1000));
        assertEquals(0, player.getMoney());
    }
}
