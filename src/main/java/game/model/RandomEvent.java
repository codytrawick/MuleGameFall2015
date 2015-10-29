package game.model;

import java.io.Serializable;
import java.util.Random;

public final class RandomEvent implements Serializable {

    private RandomEvent() {

    }

    private static Random rng = new Random();
    private static String[] goodEvents = new String[] {
            "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.&Food~3&Energy~2",
            "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING 2 BARS OF ORE.&Ore~2",
            "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $%d.&Money~%+d+8",
            "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $%d.&Money~%+d+2"
    };
    private static String[] allEvents = new String[] {
            "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.&Food~3&Energy~2",
            "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING 2 BARS OF ORE.&Ore~2",
            "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $%d.&Money~%+d+8",
            "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $%d.&Money~%+d+2",
            "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE! REPAIRS COST $%d.&Money~%+d-4",
            "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.&Food~/2",
            "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $%d TO CLEAN IT UP.&Money~%+d-6"
    };

    static String generateEvent(boolean isLast, int m) {
        String output;
        if (isLast) {
            output = generateGoodEvent();
        } else {
            output = generateAnyEvent();
        }
        return parseEvent(output, m);
    }

    private static String generateGoodEvent() {
        if (rng.nextInt(100) < 27) {
            return goodEvents[rng.nextInt(goodEvents.length)];
        } else {
            return "None";
        }
    }

    private static String generateAnyEvent() {
        if (rng.nextInt(100) < 27) {
            return allEvents[rng.nextInt(allEvents.length)];
        } else {
            return "None";
        }
    }

    private static String parseEvent(String event, int round) {
        if (event.contains("$")) {
            int multiplier = Integer.parseInt(event.substring(event.length() - 2));

            String eventText = event.substring(0, event.length() - 2);
            return String.format(eventText, round * multiplier, round * multiplier);
        } else {
            return event;
        }
    }
}
