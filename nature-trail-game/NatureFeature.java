
/**
 * The Nature Feature class is used to
 * provide the attributes and 
 * behaviours of a nature feature.
 *
 * @author Miji Kim
 * @version 2019.04.18
 */
public class NatureFeature
{
    private int featurePosition;
    private String featureType;
    private int spacePenalty;

    /**
     * Default constructor; it creates a NatureFeature.
     * It initializes the initial default values for fields.
     */
    public NatureFeature()
    {
        featurePosition = 0;
        featureType = "";
        spacePenalty = 0;
    }
    
    /**
     * Non-default Constructor; it creates a Nature Feature.
     * 
     * @param newPosition An integer to indicate nature feature's position.
     * @param newType An String to indicate nature feature's type.
     * @param newPenalty An integer to indicate nature feature's space penalty.
     */
    public NatureFeature(int newPosition, String newType, int newPenalty)
    {
        featurePosition = newPosition;
        featureType = newType;
        spacePenalty = newPenalty;
    }
    
    /**
     * Get nature feature's position.
     * 
     * @return The position of the nature feature
     */
    public int getFeaturePosition()
    {
        return featurePosition;
    }
    
    /**
     * Get nature feature's type.
     * 
     * @return The type of the nature feature
     */
    public String getFeatureType()
    {
        return featureType;
    }
    
    /**
     * Get nature feature's space penalty.
     * 
     * @return The space penalty of the nature feature
     */
    public int getSpacePenalty()
    {
        return spacePenalty;
    }
    
    /**
     * Set nature feature's position.
     * 
     * @param newPosition A String to indicate nature feature's new position.
     */
    public void setFeaturePosition(int newPosition)
    {
        featurePosition = newPosition; 
    }
    
    /**
     * Set nature feature's type.
     * 
     * @param newType A String to indicate nature feature's new type.
     */
    public void setFeatureType(String newType)
    {
        featureType = newType;
    }
    
    /**
     * Set nature feature's space penalty.
     * 
     * @param newSpacePenalty A String to indicate nature feature's new space penalty.
     */
    public void setSpacePenalty(int newSpacePenalty)
    {
        spacePenalty = newSpacePenalty;
    }
}
