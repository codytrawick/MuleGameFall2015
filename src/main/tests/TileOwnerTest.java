import game.model.GameInfo;
import game.model.GameMap;
import game.model.Player;
import game.model.tile.Tile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Jarred Aultman M10 JUnit Test
 *
 * Testing to see if setTileOwner properly assigns ownership to corresponding player.
 */
public class TileOwnerTest {

    Player tester1, tester2, tester3;
    GameMap map;
    Tile ownedTile1, ownedTile2, ownedTile3;
    GameInfo info;

    @Before
    public void setUp() {

        info = new GameInfo();
        info.setMapType("Standard");
        info.setDifficulty("Normal");
        info.setPlayerNumber(3);
        info.createNewPlayer("Tester1", "Red", "Humanoid");
        info.createNewPlayer("Tester2", "Green", "Mechanoid");
        info.createNewPlayer("Tester3", "Yellow", "Bonzoid");
        info.createRound(1);
        map = info.getMyGameMap();

        ownedTile1 = map.getTile(1, 1);
        ownedTile2 = map.getTile(3, 1);
        ownedTile3 = map.getTile(2, 4);

        tester1 = info.getPlayers().get(0);
        tester2 = info.getPlayers().get(1);
        tester3 = info.getPlayers().get(2);

    }

    @Test
    public void testTester1Ownership(){
        assertFalse("", ownedTile1.isOwned());
        tester1.purchaseTile(ownedTile1);
        ownedTile1.setOwner(tester1);

        assertTrue(ownedTile1.isOwned());
        assertEquals("Red", ownedTile1.getOwner());

    }

    @Test
    public void testTester1WithSetTileOwner() {
        info.setTileOwner(1, 1, tester1);

        assertTrue(ownedTile1.isOwned());
        assertEquals("Red", ownedTile1.getOwner());
    }

    @Test
    public void testTester2Ownership(){
        assertFalse("", ownedTile2.isOwned());
        tester2.purchaseTile(ownedTile2);
        ownedTile2.setOwner(tester2);

        assertTrue(ownedTile2.isOwned());
        assertEquals("Green", ownedTile2.getOwner());
    }

    @Test
    public void testTester2WithSetTileOwner() {
        info.setTileOwner(3, 1, tester2);

        assertTrue(ownedTile2.isOwned());
        assertEquals("Green", ownedTile2.getOwner());
    }

    @Test
    public void testTester3Ownership(){
        assertFalse("", ownedTile3.isOwned());
        tester3.purchaseTile(ownedTile3);
        ownedTile3.setOwner(tester3);

        assertTrue(ownedTile3.isOwned());
        assertEquals("Yellow", ownedTile3.getOwner());
    }

    @Test
    public void testTester3WithSetTileOwner() {
        info.setTileOwner(2, 4, tester3);

        assertTrue(ownedTile3.isOwned());
        assertEquals("Yellow", ownedTile3.getOwner());
    }

}
