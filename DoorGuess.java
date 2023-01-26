import java.util.Scanner;
import java.util.Random;

/* Doors of Deceit by Logan May
 * Made for CSC 220
 * A word dungeon game with items & chance!
 * This game probably took ~30 hours with how many conditions there are & brainstorming
 * It was fun to make once I got to actually coding it, it was a good challenge for me
 * 40 random things to occur with 6 items, there are ways to gain lives & lose them
 * The goal is 10 "doors passed" without getting your lives to 0
 * Has randomness, colors, and fun (hopefully)
*/

public class DoorGuess {

    // items
    static int sword = 0;
    static int food = 0;
    static int coin = 0;
    static int flashlight = 0;
    static int tnt = 0;
    static int crowbar = 0;

    // game stats
    static int lives = 3;
    static int doorsPassed = 1;

    // lifetime stats
    static int totalDoors = 1;
    static int totalLives = 0;
    static int wins = 0;
    static int loss = 0;

    // This is creating the color strings (color codes not created by me)
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001b[30;1m";
    static final String ANSI_RED = "\u001b[31;1m";
    static final String ANSI_GREEN = "\u001b[32;1m";
    static final String ANSI_YELLOW = "\u001b[33;1m";
    static final String ANSI_BLUE = "\u001b[34;1m";
    static final String ANSI_PURPLE = "\u001b[35;1m";
    static final String ANSI_WHITE = "\u001b[37;1m";

    // this string is used throughout the code to seperate words for readability
    static String lines = ANSI_RED + "---------------------------------------" + ANSI_RESET;

    // allows this to continuously get called
    public static void printmenu() {

        System.out.println(lines);
        System.out.println(ANSI_YELLOW + "Stats | Doors Passed: " + doorsPassed + " | Lives: " + lives + ANSI_RESET);
        System.out.println(
                ANSI_GREEN + "Items | Swords: " + sword + " | Meat: " + food + " | Coins: " + coin + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Items | Flashlights " + flashlight + " | TNT: " + tnt + " | Crowbars: "
                + crowbar + ANSI_RESET);
        System.out.println(lines);
    }

    public static void main(String[] args) {

        try (Scanner scnr = new Scanner(System.in)) {

            // This is just asking the user yes/no to see if they want to play or not, might
            // be over complicated.
            System.out.println(ANSI_BLACK + "Would you like to play Doors of Deceit? Yes/No");
            String input1 = scnr.nextLine();
            boolean i1 = input1.equalsIgnoreCase("Yes") || input1.equalsIgnoreCase("No");

            // loop for typing yes/no for the player incase they type something wrong
            while (!i1) {
                System.out.println(ANSI_BLACK + "Please type Yes/No. Try again.");
                input1 = scnr.nextLine();
                i1 = input1.equalsIgnoreCase("Yes") || input1.equalsIgnoreCase("No");
            }
            if (input1.equalsIgnoreCase("yes") || input1.equals("Yes")) {
                System.out.println(lines);
                System.out.println(ANSI_BLUE + "Welcome to Doors of Deceit! ");
            } else {
                System.out.println(lines);
                System.out.println(ANSI_BLUE + "Doors of Deceit by Logan May CSC 220");
                System.out.println("Thank you for Playing!" + ANSI_RESET);
                System.out.println(lines);
                System.exit(0);
            }

            // Talking about the games "rules"
            System.out.println(ANSI_BLUE + "A Word Dungeon Game by Logan May | CSC 220 Project" + ANSI_RESET);
            System.out.println(lines);
            System.out.println(ANSI_BLUE + "Doors of Deceit Is Simple! There are four doors.");
            System.out.println("Each door can provide something, take it away, or kill you.");
            System.out.println("Will you be able to survive throughout the house? You need to get through 10 doors.");
            System.out.println("Seems easy right? You only have 3 lives.");
            System.out.println("Remember, the doors won't go easy on you.");
            System.out.println("Good luck." + ANSI_RESET);
            System.out.println(lines + ANSI_RESET);

            // I was going to use strings for the item & stat list but realized it wouldn't
            // update properly
            // so I decided against it, even if it's less readable

            // entire loop for the game (game restarts here)
            while (true) {

                // loop to see if the user has passed 10 doors
                while (doorsPassed < 10) {

                    // repeat of asking the user what door they want to enter into
                    System.out.println(ANSI_BLACK
                            + "Are you ready for the deceitful door? Type 1, 2, 3, or 4 and then hit ENTER when you're ready.");
                    int guess1 = scnr.nextInt();
                    while (guess1 < 1 || guess1 > 4) {
                        System.out.println(ANSI_BLACK + "Please Type 1, 2 , 3, 4. Try Again.");
                        guess1 = scnr.nextInt();
                    }

                    // four if statements for whatever door the player chooses. (Get it? Deceitful
                    // doors.)
                    if (guess1 == 1 || guess1 == 2 || guess1 == 3 || guess1 == 4) {
                        System.out.println(ANSI_BLACK + "Opening...");
                        System.out.println(lines);

                        /*
                         * This chooses a random number for the switch statement (Currently 43
                         * Condititons the game can choose)
                         * Each condition has a "good" and "bad" side to it, so it's completely random
                         * per option the player chooses.
                         * Could either kill you or let you go through to the next door
                         * Didn't comment out each condition, I have a google doc for each condition
                         */
                        Random random1 = new Random();
                        int conditions1 = random1.nextInt(43);

                        switch (conditions1) {
                            case 0: 
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(
                                        ANSI_PURPLE + "You see light at the end of the hallway. Easy as that.");
                                printmenu();
                                break;

                            case 1:
                                lives--;
                                totalLives++;
                                System.out
                                        .println(ANSI_PURPLE + "You trip over a hidden wire and fall down the stairs.");
                                printmenu();
                                break;

                            case 2:
                                doorsPassed = 1;
                                System.out.println(ANSI_PURPLE
                                        + "You find yourself in a windy hallway, and end up back at where you started.");
                                printmenu();
                                break;

                            case 3:
                                lives++;
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(ANSI_PURPLE
                                        + "You find a bed, and decide to take a nap. You feel rejuvinated.");
                                printmenu();
                                break;

                            case 4:
                                sword++;
                                doorsPassed++;
                                totalDoors++;
                                System.out.print(ANSI_PURPLE
                                        + "You walk down a hallway to find a sword at the end of the hallway, this seems");
                                System.out.println(" like a good way to protect yourself. ");
                                printmenu();
                                break;

                            case 5:
                                System.out.println(
                                        ANSI_PURPLE + "You walk into the room to see a hungry lion staring at you.");
                                if (food > 0) {
                                    doorsPassed++;
                                    totalDoors++;
                                    food--;
                                    System.out.println(
                                            ANSI_PURPLE + "You quickly throw the meat you found and run away!");
                                    printmenu();
                                } else {
                                    System.out.println(ANSI_PURPLE
                                            + "The lion pounces on you.. maybe if you had some food to distract it next time.");
                                    lives--;
                                    totalLives++;
                                    printmenu();
                                }
                                break;

                            case 6:
                                food++;
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(ANSI_PURPLE
                                        + "You see a fire with some cooked meat near it. You decide to pick it up for later.");
                                printmenu();
                                break;

                            case 7:
                                System.out.println(ANSI_PURPLE
                                        + "You see a strange liquid in a bottle on a table. Do you want to drink it?");
                                String potionTake1 = scnr.nextLine();
                                boolean p1 = potionTake1.equalsIgnoreCase("Yes") || potionTake1.equalsIgnoreCase("No");

                                while (!p1) {
                                    System.out.println(ANSI_BLACK + "Please type Yes/No.");
                                    potionTake1 = scnr.nextLine();
                                    p1 = potionTake1.equalsIgnoreCase("Yes") || potionTake1.equalsIgnoreCase("No");
                                }
                                if (potionTake1.equalsIgnoreCase("Yes") || potionTake1.equals("yes")) {
                                    doorsPassed++;
                                    totalDoors++;
                                    lives++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE + "You feel rejuvinated from the potion!");
                                    printmenu();

                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE + "I guess you'll never know...");
                                    printmenu();

                                }
                                break;

                            case 8:
                                System.out.println(ANSI_PURPLE
                                        + "You see a strange liquid in a bottle on a table. Do you want to drink it?");
                                String potionTake2 = scnr.nextLine();
                                boolean p2 = potionTake2.equalsIgnoreCase("Yes") || potionTake2.equalsIgnoreCase("No");

                                while (!p2) {
                                    System.out.println(ANSI_BLACK + "Please type Yes/No.");
                                    potionTake2 = scnr.nextLine();
                                    p2 = potionTake2.equalsIgnoreCase("Yes") || potionTake2.equalsIgnoreCase("No");
                                }
                                if (potionTake2.equalsIgnoreCase("Yes") || potionTake2.equals("yes")) {
                                    lives--;
                                    totalLives++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE + "You slowly fall to the ground.");
                                    printmenu();
                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_WHITE + "I guess you'll never know...");
                                    printmenu();
                                }
                                break;

                            case 9:
                                System.out.println(ANSI_PURPLE
                                        + "You hear armor clanking behind the wall, you open it up to see a knight.");
                                System.out.println(ANSI_PURPLE + "The knight points his sword towards you.");
                                if (sword > 0) {
                                    sword--;
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(ANSI_PURPLE
                                            + "You use your sword to defend yourself, and slay the knight.");
                                    System.out.println(ANSI_WHITE + "\"You're pretty lucky you had that sword huh?\"");
                                    printmenu();
                                } else {
                                    lives--;
                                    totalLives++;
                                    System.out.println(ANSI_PURPLE
                                            + "You have nothing to defend yourself! Maybe if you had a sword...");
                                    System.out.println(ANSI_PURPLE + "The knight puts his sword through your chest.");
                                    printmenu();
                                }
                                break;

                            case 10:
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(ANSI_PURPLE + "Nothing happens, a quick walk to the next door.");
                                printmenu();
                                break;

                            case 11:
                                System.out.println(ANSI_PURPLE
                                        + "A fork in the middle of a room? Another guess in a guessing game?");
                                System.out.println(ANSI_PURPLE + "Where do you want to go?");
                                String left = scnr.nextLine();
                                boolean l1 = left.equalsIgnoreCase("Left") || left.equalsIgnoreCase("Right");

                                while (!l1) {
                                    System.out.println(ANSI_BLACK + "*Choose Left/Right*");
                                    left = scnr.nextLine();
                                    l1 = left.equalsIgnoreCase("Left") || left.equalsIgnoreCase("Right");
                                }

                                if (left.equalsIgnoreCase("Right") || left.equals("right")) {
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE
                                            + "You walk to the right, you realize that it's a dead end. You start to walk back.");
                                    System.out.println(ANSI_PURPLE
                                            + "While walking back to the fork you realize someone is waiting there in the dark.");
                                    System.out.println(ANSI_PURPLE + "The last thing you hear is your own scream.");
                                    lives--;
                                    totalLives++;
                                    printmenu();
                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE
                                            + "You walk left, was this the right choice? You'll never know.");
                                    printmenu();
                                }
                                break;
                            case 12:
                                System.out.println(ANSI_PURPLE
                                        + "A fork in the middle of a room? Another guess in a guessing game?");
                                System.out.println(ANSI_PURPLE + "Where do you want to go?");
                                String right = scnr.nextLine();
                                boolean r1 = right.equalsIgnoreCase("Left") || right.equalsIgnoreCase("Right");

                                while (!r1) {
                                    System.out.println(ANSI_BLACK + "*Choose Left/Right*");
                                    right = scnr.nextLine();
                                    r1 = right.equalsIgnoreCase("Left") || right.equalsIgnoreCase("Right");
                                }

                                if (right.equalsIgnoreCase("Left") || right.equals("left")) {
                                    lives--;
                                    totalLives++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE
                                            + "You walk to the left, you slowly begin to realize this is a trap.");
                                    System.out.println(ANSI_PURPLE
                                            + "You look behind you to find that there has been a parade of clowns following you.");
                                    System.out.println(ANSI_PURPLE + "The last thing you hear is a laugh.");
                                    printmenu();
                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_WHITE
                                            + "You walk right, was this the right choice? You'll never know.");
                                    printmenu();
                                }
                                break;

                            case 13:
                                doorsPassed++;
                                totalDoors++;
                                coin++;
                                System.out.println(ANSI_PURPLE
                                        + "You walk into the room and see a goblin run off, he seems to have dropped some coins.");
                                System.out
                                        .println(ANSI_PURPLE + "You decide to pick them up, maybe they'll be useful.");
                                printmenu();
                                break;

                            case 14:
                                System.out.println(
                                        ANSI_PURPLE + "You slowly open the door to see a shady figure in the room.");

                                if (coin > 0) {
                                    System.out.println(
                                            ANSI_PURPLE + "It leans in towards you and asks if you need anything");
                                    System.out.println(ANSI_WHITE
                                            + "\"I trade goods for coins. Would you like meat or a sword?\"");
                                    String trade1 = scnr.nextLine();
                                    boolean t1 = trade1.equalsIgnoreCase("Meat") || trade1.equalsIgnoreCase("Sword")
                                            || trade1.equalsIgnoreCase("None");

                                    while (!t1) {
                                        System.out.println(ANSI_BLACK + "*Choose Meat / Sword / None*");
                                        trade1 = scnr.nextLine();
                                        t1 = trade1.equalsIgnoreCase("Sword") || trade1.equalsIgnoreCase("Meat")
                                                || trade1.equalsIgnoreCase("None");
                                    }

                                    if (trade1.equalsIgnoreCase("sword") || trade1.equals("Sword")) {
                                        sword++;
                                        doorsPassed++;
                                        totalDoors++;
                                        coin--;
                                        System.out.println(lines);
                                        System.out.println(ANSI_WHITE + "\"Enjoy your new weapon.\"");
                                        printmenu();
                                    } else if (trade1.equalsIgnoreCase("meat") || trade1.equals("Meat")) {
                                        food++;
                                        doorsPassed++;
                                        totalDoors++;
                                        coin--;
                                        System.out.println(lines);
                                        System.out.println(
                                                ANSI_WHITE + "\"Enjoy the meat. What can you even use this for?\"");
                                        printmenu();
                                    } else if (trade1.equalsIgnoreCase("none") || trade1.equals("None")) {
                                        doorsPassed++;
                                        totalDoors++;
                                        System.out.println(lines);
                                        System.out
                                                .println(ANSI_WHITE + "\"You really dont want anything? Your loss.\"");
                                        printmenu();
                                    }
                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(
                                            ANSI_WHITE + "\"You seem to not have any coins on you, what a shame.\"");
                                    printmenu();
                                }
                                break;
                            case 15:
                                lives--;
                                totalLives++;
                                System.out.println(ANSI_PURPLE
                                        + "You walk into a dark room, you hear a 'click' when opening the door.");
                                System.out.println(ANSI_PURPLE
                                        + "You hear a barrage of bullets go off, it's the last thing you hear.");
                                printmenu();
                                break;

                            case 16:
                                System.out.println(ANSI_PURPLE
                                        + "This room seems safe. You slowly begin to walk forward into it and the lights shut off...");
                                System.out.println(ANSI_WHITE + "\"Fast! What do you do?\"");
                                String duck1 = scnr.nextLine();
                                boolean d1 = duck1.equalsIgnoreCase("Duck") || duck1.equalsIgnoreCase("Run");

                                while (!d1) {
                                    System.out.println(ANSI_BLACK + "*Choose Duck/Run*");
                                    duck1 = scnr.nextLine();
                                    d1 = duck1.equalsIgnoreCase("Duck") || duck1.equalsIgnoreCase("Run");
                                }
                                if (duck1.equalsIgnoreCase("duck") || duck1.equals("Duck")) {
                                    lives--;
                                    totalLives++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE + "You decide to duck, why would you ever do that?");
                                    System.out.println(ANSI_PURPLE + "I guess you should of made a dash for the exit");
                                    printmenu();
                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(lines);
                                    System.out.println(
                                            ANSI_PURPLE + "You make a mad dash for the exit. Phew. That was close.");
                                    printmenu();
                                }
                                break;
                            case 17:
                                System.out.println(ANSI_PURPLE
                                        + "This room seems safe. You slowly begin to walk forward into it and the lights shut off...");
                                System.out.println(ANSI_PURPLE + "Fast! What do you do?");
                                String duck2 = scnr.nextLine();
                                boolean d2 = duck2.equalsIgnoreCase("Duck") || duck2.equalsIgnoreCase("Run");

                                while (!d2) {
                                    System.out.println(ANSI_BLACK + "*Choose Duck/Run*");
                                    duck2 = scnr.nextLine();
                                    d2 = duck2.equalsIgnoreCase("Duck") || duck2.equalsIgnoreCase("Run");
                                }
                                if (duck2.equalsIgnoreCase("duck") || duck2.equals("Duck")) {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(lines);
                                    System.out.println("You decide to duck, somehow you're unseen and can crawl out.");
                                    printmenu();
                                } else {
                                    lives--;
                                    totalLives++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE
                                            + "You run pretty loud, you're heard and stopped before you can reach the exit.");
                                    System.out.println(ANSI_PURPLE + "Maybe you should of ducked down and been quiet.");
                                    printmenu();
                                }
                                break;
                            case 18:
                                coin++;
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(
                                        ANSI_PURPLE + "You walk into a room and see some old coins on a table.");
                                System.out.println(ANSI_PURPLE + "You pick them up.");
                                printmenu();
                                break;

                            case 19:
                                sword++;
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(
                                        ANSI_PURPLE + "You see a corpse in the room, you decide to take their sword.");
                                System.out.println(
                                        ANSI_PURPLE + "You wonder if this was another person trapped in this place...");
                                printmenu();
                                break;

                            case 20:
                                food++;
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(ANSI_PURPLE
                                        + "The room smells phenominal, you can smell it before opening the door.");
                                System.out.println(
                                        ANSI_PURPLE + "You see some meat and decide to pick it up before walking out.");
                                printmenu();
                                break;

                            case 21:
                                System.out.println(ANSI_PURPLE + "You walk into a room with a pack of hungry wolves.");
                                if (food > 0) {
                                    doorsPassed++;
                                    totalDoors++;
                                    food--;
                                    System.out.println(ANSI_PURPLE
                                            + "You toss the meat into the middle of the pack and run passed them unscathed.");
                                    printmenu();
                                } else {
                                    lives--;
                                    totalLives++;
                                    System.out.println(ANSI_PURPLE + "The hungry wolves find you a fitting meal.");
                                    System.out.println(ANSI_PURPLE + "If only you had some food to use.");
                                    printmenu();
                                }
                                break;

                            case 22:
                                System.out
                                        .println(ANSI_PURPLE + "You walk into a room, hundreds of red eyes light up.");
                                if (food > 0) {
                                    doorsPassed++;
                                    totalDoors++;
                                    food--;
                                    System.out.println(ANSI_PURPLE
                                            + "You toss the meat, all of the eyes turn and you bolt past them.");
                                    printmenu();
                                } else {
                                    lives--;
                                    totalLives++;
                                    System.out.println(ANSI_PURPLE + "You get eaten apart.");
                                    System.out.println(ANSI_PURPLE + "If only you had some meat to distract them.");
                                    printmenu();
                                }
                                break;

                            case 23:
                                System.out.println(ANSI_PURPLE
                                        + "The second you swing the door open you hear arrows flying towards you.");
                                if (sword > 0) {
                                    sword--;
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(ANSI_PURPLE + "You use the sword to deflect the arrows.");
                                    System.out.println(ANSI_PURPLE + "The sword seems broken, you decide to drop it.");
                                    printmenu();
                                } else {
                                    lives--;
                                    totalLives++;
                                    System.out.println(ANSI_PURPLE + "The arrows come flying at you and pierce you.");
                                    System.out.println(ANSI_PURPLE + "If only you had something to deflect them.");
                                    printmenu();
                                }
                                break;

                            case 24:
                                System.out.println(
                                        ANSI_PURPLE + "You slowly open the door to see a short man with a top hat.");

                                if (coin > 0) {
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE + "He shouts asking if you want a potion.");
                                    System.out.println(
                                            ANSI_WHITE + "\"I trade goods for coins. Would you like a potion?\"");
                                    System.out.println(ANSI_WHITE + "\"The catch is, I'm not sure what it does!!\"");
                                    System.out.println(ANSI_PURPLE + "He laughs at his own joke.");
                                    String trade2 = scnr.nextLine();
                                    boolean t2 = trade2.equalsIgnoreCase("Yes") || trade2.equalsIgnoreCase("No");

                                    while (!t2) {
                                        System.out.println(ANSI_BLACK + "*Choose Yes/No*");
                                        trade2 = scnr.nextLine();
                                        t2 = trade2.equalsIgnoreCase("Yes") || trade2.equalsIgnoreCase("No");
                                    }

                                    if (trade2.equalsIgnoreCase("Yes")) {
                                        lives++;
                                        doorsPassed++;
                                        totalDoors++;
                                        coin--;
                                        System.out.println(lines);
                                        System.out.println(ANSI_WHITE + "\"Hopefully this is useful!\"");
                                        System.out.println(ANSI_PURPLE + "You feel good, did you gain a life?");
                                        printmenu();
                                    }

                                    else {
                                        doorsPassed++;
                                        totalDoors++;
                                        System.out.println(lines);
                                        System.out.println(ANSI_WHITE
                                                + "\"You really dont want anything?\" He turns around laughing.");
                                        printmenu();
                                    }
                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(ANSI_WHITE
                                            + "\"You seem to not have any coins on you, maybe you should get on that.\"");
                                    printmenu();
                                }
                                break;

                            case 25:

                                System.out.println(
                                        ANSI_PURPLE + "You slowly open the door to see a short man with a top hat.");

                                if (coin > 0) {
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE + "He shouts asking if you want a potion.");
                                    System.out.println(
                                            ANSI_WHITE + "\"I trade goods for coins. Would you like a potion?\"");
                                    System.out.println(ANSI_WHITE + "\"The catch is, I'm not sure what it does!!\"");
                                    System.out.println(ANSI_PURPLE + "He laughs at his own joke.");
                                    String trade2 = scnr.nextLine();
                                    boolean t2 = trade2.equalsIgnoreCase("Yes") || trade2.equalsIgnoreCase("No");

                                    while (!t2) {
                                        System.out.println(ANSI_BLACK + "*Choose Yes/No*");
                                        trade2 = scnr.nextLine();
                                        t2 = trade2.equalsIgnoreCase("Yes") || trade2.equalsIgnoreCase("No");
                                    }

                                    if (trade2.equalsIgnoreCase("Yes")) {
                                        lives--;
                                        totalLives++;
                                        coin--;
                                        System.out.println(lines);
                                        System.out.println(ANSI_WHITE + "\"Hopefully this is useful!\"");
                                        System.out.println(
                                                ANSI_PURPLE + "You quickly fall to the ground, he smiles at you.");
                                        printmenu();
                                    }

                                    else {
                                        doorsPassed++;
                                        totalDoors++;
                                        System.out.println(lines);
                                        System.out.println(ANSI_WHITE
                                                + "\"You really dont want anything?\" He turns around laughing.");
                                        printmenu();
                                    }
                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(ANSI_WHITE
                                            + "\"You seem to not have any coins on you, maybe you should get on that.\"");
                                    printmenu();
                                }
                                break;

                            case 26:
                                lives--;
                                totalLives++;
                                System.out.println(ANSI_PURPLE + "You seem to have entered a dangerous room.");
                                System.out.println(ANSI_PURPLE + "You tried to jump across the pit...");
                                System.out.println(ANSI_WHITE
                                        + "\"You didn't think you were actually going to make that jump did you?\"");
                                printmenu();
                                break;

                            case 27:
                                lives--;
                                totalLives++;
                                System.out.println(ANSI_PURPLE + "You quickly run into the room.");
                                System.out.println(ANSI_PURPLE + "There seems to be a different person in the room.");
                                System.out.println(ANSI_PURPLE + "You quickly realize that \"person\" isn't human.");
                                System.out.println(ANSI_PURPLE + "It quickly takes care of you.");
                                printmenu();
                                break;

                            case 28:
                                lives--;
                                totalLives++;
                                System.out
                                        .println(ANSI_PURPLE + "You open the door hastily and an anvil falls on you.");
                                System.out.println(ANSI_WHITE + "\"Tough way to go out.\"");
                                printmenu();
                                break;

                            case 29:
                                lives++;
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(ANSI_PURPLE + "You walk in and see a nun.");
                                System.out.println(ANSI_PURPLE + "She blesses you with safe travels.");
                                printmenu();
                                break;

                            case 30:
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(ANSI_PURPLE + "Nothing happens.");
                                System.out.println(ANSI_PURPLE + "Weird...");
                                printmenu();
                                break;

                            case 31:
                                lives--;
                                totalLives++;
                                System.out.println(ANSI_PURPLE + "Nothing seems dangerous in the room.");
                                System.out.println(
                                        ANSI_PURPLE + "While strolling through the room you step set off a trip wire.");
                                System.out.println(ANSI_PURPLE
                                        + "A cannon fires from the distants and hits you straight in the chest.");
                                System.out.println(ANSI_WHITE + "\"Not your day.\"");
                                printmenu();
                                break;
                            case 32:
                                System.out.println(
                                        ANSI_PURPLE + "You slowly open the door to see a shady figure in the room.");

                                if (coin > 0) {
                                    System.out.println(
                                            ANSI_PURPLE + "It leans in towards you and asks if you need anything.");
                                    System.out.println(ANSI_WHITE
                                            + "\"I trade goods for coins. Would you like TNT or a flashlight?\"");
                                    String trade4 = scnr.nextLine();
                                    boolean t4 = trade4.equalsIgnoreCase("tnt") || trade4.equalsIgnoreCase("flashlight")
                                            || trade4.equalsIgnoreCase("none");

                                    while (!t4) {
                                        System.out.println(ANSI_BLACK + "*Choose TNT / Flashlight / None*");
                                        trade4 = scnr.nextLine();
                                        t4 = trade4.equalsIgnoreCase("TNT") || trade4.equalsIgnoreCase("tnt");
                                    }

                                    if (trade4.equalsIgnoreCase("Flashlight") || trade4.equals("flashlight")) {
                                        flashlight++;
                                        doorsPassed++;
                                        totalDoors++;
                                        coin--;
                                        System.out.println(lines);
                                        System.out.println(ANSI_WHITE + "\"Enjoy your new flashlight\"");
                                        printmenu();
                                    } else if (trade4.equalsIgnoreCase("TNT") || trade4.equals("tnt")) {
                                        tnt++;
                                        doorsPassed++;
                                        totalDoors++;
                                        coin--;
                                        System.out.println(lines);
                                        System.out.println(ANSI_WHITE + "\"Enjoy the TNT, don't blow up anything.\"");
                                        printmenu();
                                    } else if (trade4.equalsIgnoreCase("none") || trade4.equals("None")) {
                                        doorsPassed++;
                                        totalDoors++;
                                        System.out.println(lines);
                                        System.out
                                                .println(ANSI_WHITE + "\"You really dont want anything? Your loss.\"");
                                        printmenu();
                                    }
                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(
                                            ANSI_WHITE + "\"You seem to not have any coins on you, what a shame.\"");
                                    printmenu();
                                }
                                break;

                            case 33:
                                System.out.println(ANSI_PURPLE
                                        + "You walk into a dark hallway and the lights shut off, you're unsure where to go.");
                                if (flashlight > 0) {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(ANSI_PURPLE
                                            + "You turn on your flashlight and traverse through the darkness");
                                    printmenu();
                                } else {
                                    lives--;
                                    totalLives++;
                                    System.out.println(
                                            ANSI_PURPLE + "You can't see where you're going, you fall into a trap.");
                                    System.out.println(ANSI_PURPLE + "Maybe if you had something to light your way.");
                                    printmenu();
                                }
                                break;

                            case 34:
                                System.out
                                        .println(ANSI_PURPLE + "You walk into a room, quickly you hear rocks falling");
                                System.out.println(ANSI_PURPLE
                                        + "It seemed to of caved in, how does that even happen in a house?");
                                if (tnt > 0) {
                                    ++doorsPassed;
                                    totalDoors++;
                                    tnt--;
                                    System.out.println("You use your TNT to blow a way out.");
                                    System.out.println("That was strangely convienient");
                                    printmenu();
                                } else {
                                    lives--;
                                    totalLives++;
                                    System.out.println(ANSI_PURPLE + "Not much you can do in this situation.");
                                    System.out.println(ANSI_PURPLE + "Maybe if you had a way to explode something");
                                    printmenu();
                                }
                                break;

                            case 35:
                                System.out.println(
                                        ANSI_PURPLE + "You see a safe in the middle of a room, what could this be?");

                                if (crowbar > 0) {
                                    doorsPassed++;
                                    totalDoors++;
                                    food++;
                                    coin++;
                                    System.out.println(ANSI_PURPLE + "You use your crowbar to crack open the safe");
                                    System.out.println("There was some coins and meat in there!" + ANSI_RESET);
                                    System.out.println(ANSI_WHITE + "\"That's a good find\"");
                                    printmenu();
                                } else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(ANSI_PURPLE + "If only you had something to open up the safe");
                                    System.out.println(ANSI_WHITE + "\"Maybe a crowbar?\"");
                                    printmenu();
                                }
                                break;

                            case 36:
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(ANSI_PURPLE + "This room is completely empty.");
                                System.out.println(ANSI_WHITE + "\"Why are you tiptoeing through it?\"");
                                System.out.println(ANSI_WHITE + "\"The game-master would never lie.\"");
                                printmenu();
                                break;

                            case 37:
                                System.out.println(
                                        ANSI_PURPLE + "You walk into a room to see an adventurer on the ground");
                                System.out.println(ANSI_WHITE + "\"Are you going to scavenge through his goods?\"");
                                String adv1 = scnr.nextLine();
                                boolean a1 = adv1.equalsIgnoreCase("Yes") || adv1.equalsIgnoreCase("No");

                                while (!a1) {
                                    System.out.println(ANSI_BLACK + "*Choose Yes/No*");
                                    adv1 = scnr.nextLine();
                                    a1 = adv1.equalsIgnoreCase("Yes") || adv1.equalsIgnoreCase("No");
                                }

                                if (adv1.equalsIgnoreCase("Yes") || adv1.equals("yes")) {
                                    doorsPassed++;
                                    totalDoors++;
                                    flashlight++;
                                    crowbar++;
                                    tnt++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_WHITE + "\"He seemed to have plenty of items for you.\"");
                                    System.out.println(
                                            ANSI_PURPLE + "Looting seemed to work out in your favor this time.");
                                    printmenu();
                                }

                                else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_WHITE + "\"You decide to leave his corpse untouched.");
                                    printmenu();
                                }
                                break;

                            case 38:
                                System.out.println(
                                        ANSI_PURPLE + "You walk into a room to see an adventurer on the ground");
                                System.out.println(ANSI_WHITE + "\"Are you going to scavenge through his goods?\"");
                                String adv2 = scnr.nextLine();
                                boolean a2 = adv2.equalsIgnoreCase("Yes") || adv2.equalsIgnoreCase("No");

                                while (!a2) {
                                    System.out.println(ANSI_BLACK + "*Choose Yes/No*");
                                    adv2 = scnr.nextLine();
                                    a2 = adv2.equalsIgnoreCase("Yes") || adv2.equalsIgnoreCase("No");
                                }

                                if (adv2.equalsIgnoreCase("Yes") || adv2.equals("yes")) {
                                    lives--;
                                    totalLives++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_PURPLE
                                            + "As you go to loot the adventurer he springs up, he seems to be a zombie!");
                                    System.out.println(
                                            ANSI_PURPLE + "He grabs you and bites you, turning you into a zombie.");
                                    System.out.println(ANSI_WHITE + "\"Looting seemed to have killed you!\"");
                                    printmenu();
                                }

                                else {
                                    doorsPassed++;
                                    totalDoors++;
                                    System.out.println(lines);
                                    System.out.println(ANSI_WHITE + "\"You decide to leave his corpse untouched.");
                                    printmenu();
                                }
                                break;

                            case 39:
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(ANSI_PURPLE + "You decide to mad dash through the door.");
                                System.out.println(
                                        ANSI_PURPLE + "Nothing even touches you, you ran right past all of the traps");
                                System.out.println(ANSI_WHITE + "\"Why don't you always do that?\"");
                                printmenu();
                                break;

                            case 40:
                                lives--;
                                totalLives++;
                                System.out.println(ANSI_PURPLE + "You walk into a room, the lights dim.");
                                System.out.println(ANSI_PURPLE
                                        + "You continue to walk forward, a skeleton falls from the ceiling.");
                                System.out.println(ANSI_PURPLE + "You have a heart attack.");
                                System.out.println(ANSI_WHITE + "\"How did you even make it this far\"");
                                printmenu();
                                break;

                            case 41:
                                doorsPassed++;
                                totalDoors++;
                                System.out.println(ANSI_PURPLE + "Nothing happens, a quick walk to the next door.");
                                printmenu();
                                break;

                            case 42:
                                doorsPassed++;
                                totalDoors++;
                                coin++;
                                System.out.println(ANSI_PURPLE + "You see something shimmering in the distance.");
                                System.out.println(ANSI_PURPLE
                                        + "More coins? Lucky you. Hopefully you find somewhere to use them");
                                printmenu();
                                break;

                            default:
                                break;

                            // Detects if you're under 1 life to end the game. (game over)
                            // asks the player if they want to play again, which resets stats, or quit
                        }
                        if (lives < 1) {
                            loss++;
                            System.out.println(ANSI_BLUE + "GAME OVER, YOU HAVE LOST.");
                            System.out
                                    .println("You seem to have died. Maybe you'll be luckier next time." + ANSI_RESET);
                            System.out.println(lines);
                            System.out.println(ANSI_YELLOW + "Life Time Doors Passed: " + totalDoors);
                            System.out.println(ANSI_YELLOW + "Life Time Lives Lost: " + totalLives);
                            System.out.println("Life Time Wins: " + wins);
                            System.out.println("Life Time Losses: " + loss + ANSI_RESET);
                            System.out.println(lines);
                            System.out.println(ANSI_BLACK + "Would you like to play again? Yes/No");
                            String input2 = scnr.nextLine();
                            boolean i2 = input2.equalsIgnoreCase("Yes") || input2.equalsIgnoreCase("No");

                            while (!i2) {
                                System.out.println(ANSI_BLACK + "Please type Yes/No.");
                                input2 = scnr.nextLine();
                                i2 = input2.equalsIgnoreCase("Yes") || input2.equalsIgnoreCase("No");
                            }
                            if (input2.equalsIgnoreCase("yes") || input2.equals("Yes")) {
                                lives = 3;
                                doorsPassed = 1;
                                coin = 0;
                                food = 0;
                                sword = 0;
                                flashlight = 0;
                                crowbar = 0;
                                tnt = 0;
                                totalDoors++;
                                System.out.println(lines);
                                System.out.println(
                                        ANSI_BLUE + "Hopefully you remember the rules.. Get to 10 Doors Passed.");
                                System.out.println("Remember, the doors won't go easy on you.");
                                System.out.println("Good luck! May the doors be with you." + ANSI_RESET);
                                System.out.println(lines);
                            } else {
                                System.out.println(lines);
                                System.out.println(ANSI_BLUE + "Doors of Deceit by Logan May CSC 220");
                                System.out.println("Thank you for Playing!" + ANSI_RESET);
                                System.out.println(lines);
                                System.exit(0);
                            }

                        }
                    }
                }

                // winning conditions & restarting the game
                if (doorsPassed >= 10) {
                    wins++;
                    System.out.println(ANSI_BLUE + "You open the final door, you have finally reached the exit!");
                    System.out.println("You finally have escaped the Doors of Deceit!");
                    System.out.println("Congrats on winning!" + ANSI_RESET);
                    System.out.println(lines);
                    System.out.println(ANSI_YELLOW + "Life Time Doors Passed: " + totalDoors);
                    System.out.println("Life Time Lives Lost: " + totalLives);
                    System.out.println("Life Time Wins: " + wins);
                    System.out.println("Life Time Losses: " + loss + ANSI_RESET);
                    System.out.println(lines);
                }
                System.out.println(ANSI_BLACK + "Would you like to play again? Yes/No" + ANSI_RESET);
                String input3 = scnr.nextLine();
                boolean i3 = input3.equalsIgnoreCase("Yes") || input3.equalsIgnoreCase("No");

                while (!i3) {
                    System.out.println(ANSI_BLACK + "Please type Yes/No.");
                    input3 = scnr.nextLine();
                    i3 = input3.equalsIgnoreCase("Yes") || input3.equalsIgnoreCase("No");
                }

                // restarts the game at 3 lives & resets all items to 0, but keeps the "total"
                // stats
                if (input3.equalsIgnoreCase("yes") || input3.equals("Yes")) {
                    lives = 3;
                    doorsPassed = 1;
                    coin = 0;
                    food = 0;
                    sword = 0;
                    flashlight = 0;
                    crowbar = 0;
                    tnt = 0;
                    totalDoors++;
                    System.out.println(lines);
                    System.out.println(ANSI_BLUE + "Hopefully you remember the rules.. Get to 10 Doors Passed.");
                    System.out.println("Remember, the doors won't go easy on you.");
                    System.out.println("Good luck! May the doors be with you." + ANSI_RESET);
                    System.out.println(lines);
                }
                // ends the game if user chooses "no"
                else {
                    System.out.println(lines);
                    System.out.println(ANSI_BLUE + "Doors of Deceit by Logan May CSC 220");
                    System.out.println("Thank you for Playing!" + ANSI_RESET);
                    System.out.println(lines);
                    System.exit(0);
                }
            }
        }
    }
}