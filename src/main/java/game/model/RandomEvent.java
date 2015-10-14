package game.model;

import java.util.Random;

public class RandomEvent {

    private static Random rng = new Random();
    private static String[] goodEvents = new String[] {
            "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.&FOOD~3&ENERGY~2",
            "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING 2 BARS OF ORE.&ORE~2",
            "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $[8~m].&MONEY~8*m",
            "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $[2*m].&MONEY~8*m"
    };
    private static String[] allEvents = new String[] {
            "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.&FOOD~3&ENERGY~2",
            "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING 2 BARS OF ORE.&ORE~2",
            "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $[8~m].&MONEY~8*m",
            "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $[2*m].&MONEY~8*m",
            "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $[4*m].&MONEY~-4*m",
            "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.&FOOD~f/2",
            "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $[6*m] TO CLEAN IT UP.&MONEY~6*m"
    };

    static void generateEvent(boolean isLast, int m) {
        if (isLast) {
            generateGoodEvent();
        } else {
            generateAnyEvent();
        }
    }

    private static void generateGoodEvent() {
        if (rng.nextInt(100) < 27) {
            System.out.println(goodEvents[rng.nextInt(goodEvents.length)]);
        }
    }

    private static void generateAnyEvent() {
        if (rng.nextInt(100) < 27) {
            System.out.println(allEvents[rng.nextInt(allEvents.length)]);
        }
    }
}
