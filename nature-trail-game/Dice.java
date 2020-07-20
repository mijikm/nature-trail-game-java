
import java.util.Arrays;
import java.util.Random;

/**
 * The Dice class is used to
 * generate a random number.
 *
 * @author Miji Kim
 * @version 2019.04.18
 */
public class Dice
{
    private int maximumValue;
    private int minimumValue;

    /**
     * Default constructor; it creates a Dice.
     * It initializes the initial default values for fields.
     */
    public Dice()
    {
        maximumValue = 4;
        minimumValue = 1;
    }

    /**
     * Non-default Constructor; it creates a Dice.
     * 
     * @param maxValue An integer to indicate a maximumvalue for a Dice.
     * @param minValue An integer to indicate a minimumvalue for a Dice.
     */
    public Dice(int maxValue, int minValue)
    {
        maximumValue = maxValue;
        minimumValue = minValue;
    }
    
    /**
     * Generate four random numbers
     * based on the length of the trail.
     * 
     * @return An array of random numbers for trail position
     */
    public int[] generateRandomTP() 
    {                                                         
        Random rd = new Random();
        int[] randomTP = new int[4];  // randomTP indicates a random trail position
        boolean isFlag = true;
        do
        {
            int a = rd.nextInt(((maximumValue - 2) - minimumValue) + 1) + minimumValue;
            int b = rd.nextInt(((maximumValue - 2) - minimumValue) + 1) + minimumValue;
            int c = rd.nextInt(((maximumValue - 2) - minimumValue) + 1) + minimumValue;
            int d = rd.nextInt(((maximumValue - 2) - minimumValue) + 1) + minimumValue;
            if (b != a)      
            {
                if (c != b && c != a)
                {
                    if (d != c && d != b && d != a)
                    {
                        randomTP[0] = a;
                        randomTP[1] = b;
                        randomTP[2] = c;
                        randomTP[3] = d;
                        isFlag = false;
                    }
                }
            }
        } while (isFlag);        
        return randomTP;
    }
    
    /**
     * Get the maximum value.
     * 
     * @return The maximum value
     */
    public int getMaximumValue()
    {
        return maximumValue;
    }
    
    /**
     * Get the minimum value.
     * 
     * @return The minimum value
     */
    public int getMinimumValue()
    {
        return minimumValue;
    }
    
    /**
     * Roll the dice for eacy player.
     * 
     * @param turn An integer to indicate the player.
     * 
     * @return The number of the dice rolled
     */
    public int roll(int turn)
    {
        if (turn == 1)  // 1 indicates player1
        {
            int rolled = (int)(Math.random() * ((maximumValue - minimumValue) + 1) + minimumValue);
            int pRolled = rolled;
            return pRolled;
        }
        else if (turn == 2)  // 2 indicates player2
        {
            int rolled = (int)(Math.random() * ((maximumValue - minimumValue) + 1) + minimumValue);
            int cRolled = rolled;
            return cRolled;
        }
        else
        {
            int rolled = (int)(Math.random() * ((maximumValue - minimumValue) + 1) + minimumValue);
            return rolled;
        }
    }
    
    /**
     * Set the maximum value.
     * 
     * @param newMaxValue An integer to indicate the new maximum value.
     */
    public void setMaximumValue(int newMaxValue)
    {
        maximumValue = newMaxValue;
    }
    
    /**
     * Set the minimum value.
     * 
     * @param newMinValue An integer to indicate the new minimum value.
     */
    public void setMinimumValue(int newMinValue)
    {
        minimumValue = newMinValue;
    }
}
    


