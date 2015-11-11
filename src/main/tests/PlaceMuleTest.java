import game.model.GameInfo;
import game.model.GameMap;
import game.model.Player;
import game.model.tile.Tile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrew Pritchett on 11/2/2015.
 */
public class PlaceMuleTest {
    Player player;
    GameMap map;
    Tile tile;
    GameInfo info;

    @Before
    public void setUp() {
        info = new GameInfo();
        info.setMapType("Standard");
        info.setPlayerNumber(1);
        info.createNewPlayer("Tester", "Blue", "Humanoid");
        info.createRound(1);
        map = info.getMyGameMap();
        tile = map.getTile(2, 2);
        player = info.getPlayers().get(0);
    }

    @Test
    public void testWithMuleAndOwnership() {
        player.setMule("Food");
        player.purchaseTile(tile);
        tile.setOwner(player);
        assertEquals("", tile.getMuleType());
        //Method call
        info.placeMule(2, 2);
        assertEquals("", player.getMule());
        assertEquals("Food", tile.getMuleType());
    }

    @Test
    public void testWithMuleAndNoOwnership() {
        player.setMule("Food");
        assertEquals("", tile.getMuleType());
        //Method call
        info.placeMule(2, 2);
        assertEquals("", tile.getMuleType());
        assertEquals("", player.getMule());
    }

    @Test
    public void testWithoutMuleAndWithOwnership() {
        player.purchaseTile(tile);
        tile.setOwner(player);
        assertEquals("", tile.getMuleType());
        //Method call
        info.placeMule(2, 2);
        assertEquals("", tile.getMuleType());
        assertEquals("", player.getMule());
    }

    @Test
    public void testMuleReplacementWithOwnership() {
        player.setMule("Food");
        tile.setMule("Energy");
        player.purchaseTile(tile);
        tile.setOwner(player);
        assertEquals("Energy", tile.getMuleType());
        //Method call
        info.placeMule(2, 2);
        assertEquals("Food", tile.getMuleType());
        assertEquals("", player.getMule());
    }

    @Test
    public void testMuleReplacementWithoutOwnership() {
        player.setMule("Food");
        tile.setMule("Energy");
        assertEquals("Energy", tile.getMuleType());
        //Method call
        info.placeMule(2, 2);
        assertEquals("Energy", tile.getMuleType());
        assertEquals("", player.getMule());
    }
}
