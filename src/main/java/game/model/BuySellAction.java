package game.model;

import game.model.Player;

import java.util.HashMap;

/**
 * Created by matthew38 on 10/7/15.
 */
public class BuySellAction {
    private String resourceType;
    private boolean buy;

    public BuySellAction(String type, boolean buy) {
        this.buy = buy;
        this.resourceType = type;
    }

    /**
     * Performs the action defined by this class's state on the given player.  Returns true if the action executed
     * sucessfully: the player had more than 1 unit of the resource (if selling) or enough money to buy 1 resource
     * (if buying)
     * @param player
     * @return
     */
    public boolean performAction(Player player, HashMap<String, Integer> prices, Store store) {
        int price = prices.get(resourceType);
        if (buy) {
            if (player.spendMoney(price)) {
                switch (resourceType) {
                    case "Food":
                        player.addFood(1); break;
                    case "Ore":
                        player.addOre(1); break;
                    case "Energy":
                        player.addEnergy(1); break;
                }
                return true;
            } else {
                return false;
            }
        } else {
            switch (resourceType) {
                case "Food":
                    if (player.getFood() > 0) {
                        player.addFood(-1);
                        player.earnMoney(price);
                        return true;
                    } else {
                        return false;
                    }
                case "Ore":
                    if (player.getOre() > 0) {
                        player.addOre(-1);
                        player.earnMoney(price);
                        return true;
                    } else {
                        return false;
                    }
                case "Energy":
                    if (player.getEnergy() > 0) {
                        player.addEnergy(-1);
                        player.earnMoney(price);
                        return true;
                    } else {
                        return false;
                    }
                default: return false;
            }
        }
    }

}
