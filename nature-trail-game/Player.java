
/**
 * The Player class is used to
 * provide the attributes and 
 * behaviours of a player.
 *
 * @author Miji Kim
 * @version 2019.04.18
 */
public class Player
{
    private String name;
    private int position;
    private int score;

    /**
     * Default constructor; it creates a Player.
     * It initializes the initial default values for fields.
     */
    public Player()
    {
        name = "";
        position = 0;
        score = 0;
    }
    
    /**
     * Non-default Constructor; it creates a Player.
     * 
     * @param pName A String to indicate player's name.
     * @param pPosition An integer to indicate player's position.
     * @param pScore An integer to indicate player's score.
     */
    public Player(String pName, int pPosition, int pScore)
    {
        name = pName;
        position = pPosition;
        score = pScore;
    }

    /**
     * Get player's name.
     * 
     * @return The name of the player
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get player's state.
     * 
     * @return The name, position, and score of the player
     */
    public String getPlayerState()
    {
        return "name: " + name + ", position: " + position + ", score: " + score;
    }    
    
    /**
     * Get player's position.
     * 
     * @return The position of the player
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * Get player's score.
     * 
     * @return The score of the player
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Set player's name.
     * 
     * @param newName A String to indicate player's new name.
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Set player's state.
     * 
     * @param newName A String to indicate player's new name.
     * @param newPosition An integer to indicate player's new position.
     * @param newScore An integer to indicate player's new score.
     */
    public void setPlayer(String newName, int newPosition, int newScore)
    {
        name = newName;
        position = newPosition;
        score = newScore;
    }
    
    /**
     * Set player's position.
     * 
     * @param newPosition An integer to indicate player's new position.
     */
    public void setPosition(int newPosition)
    {
        position = newPosition;
    }
    
    /**
     * Set player's score.
     * 
     * @param newScore An integer to indicate player's new score.
     */
    public void setScore(int newScore)
    {
        score = newScore;
    }
}
