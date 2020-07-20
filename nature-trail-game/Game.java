
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * The Game class has methods to control 
 * the playing of the Nature Trail Game.
 * It allows the user to enter the trail
 * length and the user name. 
 * 
 * @author Miji Kim
 * @version 2019.04.18
 */
public class Game
{
    private int trailLength;
    private Trail natureTrail;
    private Player playerOne;
    private Player playerTwo;
    
    /**
     * Default constructor; it creates a Game.
     * It initializes the initial default values for fields. 
     */
    public Game()
    {
        trailLength = 0;
        natureTrail = new Trail();
        playerOne = new Player();
        playerTwo = new Player();
    }
    
    /**
     * Non-default Constructor; it creates a Game.
     * It allows the user to input values for fields.
     * 
     * @param newTrailLength An integer to indicate new trail length.
     * @param newTrail A Trail to indicate new trail.
     * @param newPlayerOne A Player to indicate new player one.
     * @param newPlayerTwo A Player to indicate new player two.
     */
    public Game(int newTrailLength, Trail newTrail, Player newPlayerOne, Player newPlayerTwo)
    {
        trailLength = newTrailLength;
        natureTrail = newTrail;
        playerOne = newPlayerOne;
        playerTwo = newPlayerTwo;
    }
    
    /**
     * Check whether the player sights an animal
     * with a 50% of chance.
     * 
     * @return The points according to the type of animal
     */
    public int checkAnimal()
    {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        String[] animals = new String[10];
        animals[0] = "Koala";
        animals[1] = "Emu";
        animals[2] = "Wombat";
        animals[3] = "Kangaroo";
        animals[4] = "Redback spider";
        animals[5] = "no animal";
        animals[6] = "no animal";
        animals[7] = "no animal";
        animals[8] = "no animal";
        animals[9] = "no animal";
        int animalNum = rd.nextInt(animals.length); 
        switch (animalNum) 
        {
            case 0: System.out.println("Wow!!! An animal is found..., but can you guess which one?");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    System.out.println("It's " + animals[0] + " and it added 10 points!");
                    return 10;
            case 1: System.out.println("Wow!!! An animal is found..., but can you guess which one?");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    System.out.println("It's " + animals[1] + " and it added 7 points!");
                    return 7;
            case 2: System.out.println("Wow!!! An animal is found..., but can you guess which one?");
                    System.out.println("Press enter to continue");
                    sc.nextLine();    
                    System.out.println("It's " + animals[2] + " and it added 5 points!");
                    return 5;
            case 3: System.out.println("Wow!!! An animal is found..., but can you guess which one?");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    System.out.println("It's " + animals[3] + " and it added 2 points!");
                    return 2;
            case 4: System.out.println("Wow!!! An animal is found..., but can you guess which one?");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    System.out.println("Ooops... It's " + animals[4] + " and it deducted 5 points!");
                    return -5;
            case 5: System.out.println("Ooops... " + animals[5] + " found");
                    return 0;
            case 6: System.out.println("Ooops... " + animals[6] + " found");
                    return 0;
            case 7: System.out.println("Ooops... " + animals[7] + " found");
                    return 0;
            case 8: System.out.println("Ooops... " + animals[8] + " found");
                    return 0;
            case 9: System.out.println("Ooops... " + animals[9] + " found");
                    return 0;
            default:
                System.out.println("ERROR!!!"); 
                return 0;
        }
    }
    
    /**
     *  Check whether the player's position has
     *  an action due to a special feature.
     *  
     *  @param playerPosition An integer to indicate the player's position.
     *  @param featurePosition An array of integers to indicate feature position.
     *  @param player An integer to indicate the player.
     *  
     *  @return true or false
     */
    public boolean checkNatureFeature(int playerPosition, int[] featurePosition, int player)
    {
        if (playerPosition == featurePosition[0] && player == 1)  // 1 indicates player1
        {
            System.out.println("Unfortunately... here is Creek!!! Move back 2 places"); 
            if (playerPosition + natureTrail.getSpacePenalty(0) < 1)
            {  
                playerOne.setPosition(1);    
                return true;
            }
            else
            {
                playerOne.setPosition(playerOne.getPosition() + natureTrail.getSpacePenalty(0));
                return true;
            }
        }
        else if (playerPosition == featurePosition[0] && player == 2)  // 2 indicates player2
        {
            System.out.println("Unfortunately... here is Creek!!! Move back 2 places"); 
            if (playerPosition + natureTrail.getSpacePenalty(0) < 1)
            {  
                playerTwo.setPosition(1);    
                return true;
            }
            else
            {
                playerTwo.setPosition(playerTwo.getPosition() + natureTrail.getSpacePenalty(0));
                return true;
            }
        }
        else if (playerPosition == featurePosition[1] && player == 1)
        {
            System.out.println("Fortunately... here is Bridge!!! Move forward 4 places");
            if (playerPosition + natureTrail.getSpacePenalty(1) >= trailLength)
            {
                playerOne.setPosition(trailLength);
                reachFinish(playerOne.getPosition(), playerTwo.getPosition());
                return false;
            }
            else
            {   playerOne.setPosition(playerOne.getPosition() + natureTrail.getSpacePenalty(1));
                return true;
            }
        }
        else if (playerPosition == featurePosition[1] && player == 2)
        {
            System.out.println("Fortunately... here is Bridge!!! Move forward 4 places");
            if (playerPosition + natureTrail.getSpacePenalty(1) >= trailLength)
            {
                playerTwo.setPosition(trailLength);
                reachFinish(playerOne.getPosition(), playerTwo.getPosition());
                return false;
            }
            else
            {   playerTwo.setPosition(playerTwo.getPosition() + natureTrail.getSpacePenalty(1));
                return true;
            }
        }
        else if (playerPosition == featurePosition[2] && player == 1) 
        {
            System.out.println("Unfortunately... here is Fallen tree!!! Move back 3 places");
            if (playerPosition + natureTrail.getSpacePenalty(2) < 1)
            {    
                playerOne.setPosition(1);    
                return true;
            }
            else
            {
                playerOne.setPosition(playerOne.getPosition() + natureTrail.getSpacePenalty(2));
                return true;
            }
        }
        else if (playerPosition == featurePosition[2] && player == 2)
        {
            System.out.println("Unfortunately... here is Fallen tree!!! Move back 3 places");
            if (playerPosition + natureTrail.getSpacePenalty(2) < 1)
            {    
                playerTwo.setPosition(1);    
                return true;
            }
            else
            {
                playerTwo.setPosition(playerTwo.getPosition() + natureTrail.getSpacePenalty(2));
                return true;
            }
        }
        else if (playerPosition == featurePosition[3] && player == 1)
        {
            System.out.println("Unfortunately... here is Landslide!!! Move back 5 places");
            if (playerPosition + natureTrail.getSpacePenalty(3) < 1)
            {    
                playerOne.setPosition(1);    
                return true;
            }
            else
            {
                playerOne.setPosition(playerOne.getPosition() + natureTrail.getSpacePenalty(3));
                return true;
            }
        }
        else if (playerPosition == featurePosition[3] && player == 2)
        {
            System.out.println("Unfortunately... here is Landslide!!! Move back 5 places");
            if (playerPosition + natureTrail.getSpacePenalty(3) < 1)
            {    
                playerTwo.setPosition(1);    
                return true;
            }
            else
            {
                playerTwo.setPosition(playerTwo.getPosition() + natureTrail.getSpacePenalty(3));
                return true;
            }
        }
        else
            return true;
    }
    
    /**
     * Print a formfeed character (unicode 000C)
     * to clear the terminal.
     */
    public void clearTerminal()
    {
        System.out.print('\u000C'); 
    }
    
    /**
     * Display star, space,
     * and player's position.
     */
    public void displayNatureTrail()
    {
        displayStar();
        System.out.println(); 
        displaySpace();
        System.out.println(); 
        displayPosition();
        System.out.println(); 
        displayStar();
        System.out.println(); 
    }
    
    /**
     * Display player's position:
     * H for the human player,
     * C for computer.
     */
    public void displayPosition()
    {
        int[] trailSpace = new int[trailLength];
        for (int i = 1; i < trailLength; i++)
        {
            if (i == playerOne.getPosition() && i == playerTwo.getPosition())
                System.out.print(" HC ");
            else if (i == playerOne.getPosition())
                System.out.print("  H ");
            else if (i == playerTwo.getPosition())
                System.out.print("  C ");
            else
                System.out.print(" __ ");
        }
    }
    
    /**
     * Display the number for each trail space with
     * S for the start position,
     * F for the finish position.
     */
    public void displaySpace()
    {
        int[] trailSpace = new int[trailLength];
        for (int i = 1; i <= trailLength; i++)
        {
            if (i == 1)
                System.out.print("  S ");
            else if (i == trailLength)
                System.out.print("  F ");
            else if (i < 10)
                System.out.print("~0" + i + "~");
            else
                System.out.print("~" + i + "~");
        }
    }
    
    /**
     * Display the line of stars.
     */
    public void displayStar()
    {
        int[] trailSpace = new int[trailLength];
        for (int i = 1; i <= trailLength; i++)
        {
            System.out.print("****");
        }
    }
    
    /**
     * Display the welcome message. 
     */
    public void displayWelcome()
    {
        System.out.println("***********************************************");
        System.out.println("******** Welcome to Nature Trail Game *********");
        System.out.println("***********************************************");
        System.out.println();
    }
    
    /**
     * Get the length of the trail.
     * 
     * @return The length of the trail
     */
    public int getTrailLength()
    {
        return trailLength;
    }
    
    /**
     * Each player rolls a dice. 
     * 
     * @param roll An integer to indicate the player.
     * 
     * @return The number of the dice rolled by the player
     */
    public int playerRoll(int roll)
    {
        Scanner sc = new Scanner(System.in);
        Dice dice = new Dice();
        if (roll == 1)  // 1 indicates player1
        {
            System.out.println();
            System.out.println(playerOne.getName() + ", press enter to roll the dice");
            sc.nextLine();
            int pDiceRoll = dice.roll(1);
            System.out.println();
            System.out.println(playerOne.getName() + ", you rolled a ... " + pDiceRoll + "!");
            System.out.println("Press enter to continue");
            sc.nextLine();
            System.out.println();
            playerOne.setPosition(playerOne.getPosition() + pDiceRoll);
            return pDiceRoll;
        }
        else 
        {
            System.out.println();
            System.out.println("It's now " + playerTwo.getName() + "'s turn");
            System.out.println();
            System.out.println("..." + playerTwo.getName() + " rolling the dice...");
            int cDiceRoll = dice.roll(2);
            System.out.println();
            System.out.println(playerTwo.getName() + " just rolled a ... " + cDiceRoll + "!");
            System.out.println("Press enter to continue");
            sc.nextLine();
            System.out.println();
            playerTwo.setPosition(playerTwo.getPosition() + cDiceRoll);
            return cDiceRoll;
        }
    }
    
    /**
     * Each player takes turn until the game ends. 
     * 
     * @param turn An integer to indicate the player.
     */
    public void playerTurn(int turn)
    {
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        do
        {
            if (turn == 1)  // 1 indicates player1
            {
                displayNatureTrail();
                playerRoll(1);
                isValid = reachFinish(playerOne.getPosition(), playerTwo.getPosition());
                if (isValid == true)
                {
                    System.out.println(playerOne.getName() + ", you landed on tile " + playerOne.getPosition());
                    playerOne.setScore(checkAnimal() + playerOne.getScore());
                    isValid = checkNatureFeature(playerOne.getPosition(), natureTrail.getFeaturePosition(), 1);
                    if (isValid == true)
                    {
                        System.out.println(playerOne.getName() + ", you are on tile " + playerOne.getPosition() + " and have score of " + playerOne.getScore());
                        System.out.println();
                        System.out.println("Press enter to continue");
                        sc.nextLine();
                        clearTerminal();
                        displayNatureTrail();
                        playerRoll(2);
                        isValid = reachFinish(playerOne.getPosition(), playerTwo.getPosition());
                        if (isValid == true) 
                        {
                            System.out.println(playerTwo.getName() + " landed on tile " + playerTwo.getPosition());
                            playerTwo.setScore(checkAnimal() + playerTwo.getScore());
                            isValid = checkNatureFeature(playerTwo.getPosition(), natureTrail.getFeaturePosition(), 2);
                            
                            if (isValid == true)
                            {
                                System.out.println(playerTwo.getName() + " is on tile " + playerTwo.getPosition() + " and has score of " + playerTwo.getScore());
                                System.out.println();
                                System.out.println("Press enter to continue");
                                sc.nextLine();
                                clearTerminal();
                            }
                        } 
                    }
                }
            }
            else if (turn == 2)  // 2 indicates player2
            {
                displayNatureTrail();
                playerRoll(2);
                isValid = reachFinish(playerOne.getPosition(), playerTwo.getPosition());
                if (isValid == true)
                {
                    System.out.println(playerTwo.getName() + " landed on tile " + playerTwo.getPosition());
                    playerTwo.setScore(checkAnimal() + playerTwo.getScore());
                    isValid = checkNatureFeature(playerTwo.getPosition(), natureTrail.getFeaturePosition(), 2);
                    if (isValid == true)
                    {
                        System.out.println(playerTwo.getName() + " is on tile " + playerTwo.getPosition() + " and has score of " + playerTwo.getScore());
                        System.out.println();
                        System.out.println("Press enter to continue");
                        sc.nextLine();
                        clearTerminal();
                        displayNatureTrail();
                        playerRoll(1);
                        isValid = reachFinish(playerOne.getPosition(), playerTwo.getPosition());
                        if (isValid == true)
                        {
                            System.out.println(playerOne.getName() + ", you landed on tile " + playerOne.getPosition());
                            playerOne.setScore(checkAnimal() + playerOne.getScore());
                            isValid = checkNatureFeature(playerOne.getPosition(), natureTrail.getFeaturePosition(), 1);
                            if (isValid == true)
                            {
                                System.out.println(playerOne.getName() + ", you are on tile " + playerOne.getPosition() + " and have score of " + playerOne.getScore());
                                System.out.println();
                                System.out.println("Press enter to continue");
                                sc.nextLine();
                                clearTerminal();  
                            }
                        }
                    }
                }
            }   
        } while (isValid);
    }
    
    /**
     * Check whether the player
     * reaches the finish position.
     * 
     * @param pPosition An integer to indicate player one's position.
     * @param cPosition An integer to indicate player two's position.
     * 
     * @return The method to select the winner or true
     */
    public boolean reachFinish(int pPosition, int cPosition)
    {
        if (pPosition >= trailLength)
        {
            System.out.println(playerOne.getName() + " reached the finish point!");
            playerOne.setScore(playerOne.getScore() + 10);
            System.out.println(playerOne.getName() + " has score of " + playerOne.getScore() + " and " + playerTwo.getName() + " has score of " + playerTwo.getScore());
            return selectWinner();
        }
        else if (cPosition >= trailLength)
        {
            System.out.println(playerTwo.getName() + " reached the finish point!");
            playerTwo.setScore(playerTwo.getScore() + 10);
            System.out.println(playerTwo.getName() + " has score of " + playerTwo.getScore() + " and " + playerOne.getName() + " has score of " + playerOne.getScore());
            return selectWinner();
        }
        else 
            return true;
    }   
    
    /**
     * Determine which player takes the first turn.
     */
    public void selectFirstP() 
    {
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        do
        {
            int pDiceRoll = playerRoll(1);
            int cDiceRoll = playerRoll(2);
            playerOne.setPosition(1);
            playerOne.setScore(0);
            playerTwo.setPosition(1);
            playerTwo.setScore(0);
            if (pDiceRoll == cDiceRoll)
            {
                System.out.println("[" + playerOne.getName() + ": " + pDiceRoll + ", " + playerTwo.getName() + ": " + cDiceRoll + "]");
                System.out.println(playerOne.getName() + ", please roll again!");
                System.out.println("Press enter to continue");
                sc.nextLine();
                isValid = true;
            }
            else if (pDiceRoll > cDiceRoll)
            {
                System.out.println();
                System.out.println(playerOne.getName() + ", you will take the first turn!");
                System.out.println("Press enter to continue");
                sc.nextLine();
                clearTerminal();
                playerTurn(1);
                isValid = false;
            }
            else if (pDiceRoll < cDiceRoll)
            {
                System.out.println();
                System.out.println(playerTwo.getName() + " will take the first turn!");
                System.out.println("Press enter to continue");
                sc.nextLine();
                clearTerminal();
                playerTurn(2);
                isValid = false;
            }
        } while (isValid);
    }
    
    /**
     * Determine the winner and end the game.
     * 
     * @return false
     */
    public boolean selectWinner()
    {
        if (playerOne.getScore() > playerTwo.getScore())
        {
            System.out.println();
            System.out.println(playerOne.getName() + ", you won the game!");
            System.out.println();
            System.out.println("**************** THE GAME ENDS ****************");
            System.out.println();
            return false;
        }
        else if (playerTwo.getScore() > playerOne.getScore())
        {
            System.out.println();
            System.out.println(playerTwo.getName() + " won the game!");
            System.out.println();
            System.out.println("**************** THE GAME ENDS ****************");
            System.out.println();
            return false;
        }
        else
        {
            System.out.println();
            System.out.println(playerOne.getName() + " and " + playerTwo.getName() + " got the same score!");
            System.out.println();
            System.out.println("*********** THE GAME ENDS IN A DRAW ***********");
            System.out.println();
            return false;
        }
    }
    
    /**
     * Set nature features with
     * the random numbers generated.
     * 
     * @param randomTP An array of integers to indicate a random trail position.
     */
    public void setNatureFeature(int[] randomTP)
    {
        for (int i = 0; i < randomTP.length; i++)
        {
            natureTrail = new Trail();
            natureTrail.setFeaturePosition(randomTP);  // randomTP indicates a random trail position
            natureTrail.setFeatureType(i);
            natureTrail.setSpacePenalty(i);         
        }
    }
    
    /**
     * Request the human player
     * to enter the name.
     */
    public void setPlayerName()
    {
        Scanner sc = new Scanner(System.in);
        playerTwo.setName("Computer");
        boolean isValid = true;
        do
        {
            System.out.println("Please enter your name");
            String name = sc.next().trim();
            if (name.length() > 0 && name.length() < 7)
            {  
                playerOne.setName(name);
                isValid = false;
            }
            else
            {
                System.out.println("--- ERROR ---");
                System.out.println("Your name must be between 1 and 6 characters");
                System.out.println();
                isValid = true;
            }
        } while (isValid);
    }
    
    /**
     * Request the human player
     * to enter the length of the trail.
     */
    public void setTrailLength()
    {
        Scanner sc = new Scanner(System.in);
        boolean isCorrect = true;
        do
        {
            System.out.println("Please enter the trail length between 10 and 20");
            int testLength = sc.nextInt();
            if (testLength < 10 || testLength > 20)
            {
                System.out.println();
                System.out.println("--- ERROR ---");
                System.out.println("Please enter the correct number");
                isCorrect = false;
            }
            else
            {
                trailLength = testLength;
                isCorrect = true;
            }
        } while (!isCorrect);
    }
    
    /**
     * Start the game.
     */
    public void startGame()
    {
        Scanner sc = new Scanner(System.in);
        displayWelcome();
        setTrailLength();
        Dice dice = new Dice(trailLength, 2);
        int[] randomTP = dice.generateRandomTP();
        setNatureFeature(randomTP);  // randomTP indicates a random trail position
        setPlayerName();
        System.out.println();
        System.out.println("Hi " + playerOne.getName());
        System.out.println();
        System.out.println("You will be competing with the computer");
        System.out.println("Press enter to continue");
        sc.nextLine(); 
        System.out.println("Along a nature trail, each player will gather some points for animal sightings");
        System.out.println("The first player to reach the finish position gets 10 points and the game ends\n" + "The player with the highest points wins the game");
        System.out.println("Press enter to continue");
        sc.nextLine();
        System.out.println("The natural trail will be displayed on the screen with the letters below");
        System.out.println("S: Start position\n" + "F: Finish position \n" + "H: " + playerOne.getName() + "\n" + "C: " + playerTwo.getName());
        System.out.println("Are you ready for the Nature Trail Game? Press enter to start!");
        sc.nextLine();
        System.out.println("...wait for a moment...");
        System.out.println("...setting up the game...");
        System.out.println("Press enter to continue");
        sc.nextLine();
        System.out.println();
        System.out.println("The game is now ready");
        System.out.println();
        System.out.println("Let's roll the dice!");
        System.out.println("The player with the higher number takes first turn");
        System.out.println("Please keep in mind: if the numbers are equal, the dice will be rolled again by both players");
        System.out.println();
        System.out.println("Press enter to continue");
        selectFirstP();
    }
}
