
/**
 * The Trail class is used to
 * store an array of all nature features
 * on the trail.
 *
 * @author Miji Kim
 * @version 2019.04.18
 */
public class Trail
{
    private NatureFeature[] features;

    /**
     * Default constructor; it creates a Trail.
     * It initializes the initial default values for fields.
     */
    public Trail()
    {
        features = new NatureFeature[4];
        features[0] = new NatureFeature();
        features[1] = new NatureFeature();
        features[2] = new NatureFeature();
        features[3] = new NatureFeature();
    }
    
    /**
     * Non-default Constructor; it creates a Trail.
     * 
     * @param i An integer indicates the number of elements.
     */
    public Trail(NatureFeature[] newFeatures)
    {
        features = newFeatures;
    }
    
    /**
     * Get the position of the feature.
     * 
     * @return The array of integers indicating the position of the feature
     */
    public int[] getFeaturePosition()
    {
        int[] featurePosition = {features[0].getFeaturePosition(), features[1].getFeaturePosition(), features[2].getFeaturePosition(), features[3].getFeaturePosition()};
        return featurePosition;
    }
    
    /**
     * Get the position of the feature.
     * 
     * @param i An integer to indicate the index.
     * 
     * @return The position of the feature
     */
    public int getFeaturePosition(int i)
    {
        return features[i].getFeaturePosition();
    }
    
    /**
     * Get features.
     * 
     * @return The array of nature feature
     */
    public NatureFeature[] getFeatures()
    {
        return features;
    }
    
    /**
     * Get the space penalty.
     * 
     * @param i An integer to indicatge the index.
     * 
     * @return The space penalty associated with the feature
     */
     public int getSpacePenalty(int i)
    {
        return features[i].getSpacePenalty();
    }
    
    /**
     * Set feature's index, position,type, and space penalty.
     * 
     * @param index An integer to indicate the index.
     * @param position An integer to indicate feature's position.
     * @param type A String to indicate feature's type.
     * @param penalty An integer to indicate the space penalty.
     */
    public void setFeatureDetails(int index, int position, String type, int penalty)
    {
        for (index = 0; index < features.length; index++)
        {
            features[index].setFeaturePosition(position);
            features[index].setFeatureType(type);
            features[index].setSpacePenalty(penalty);
            break;            
        }
    }
    
    /**
     * Set feature's position.
     * 
     * @param position An array of integers to indicate feature's position.
     */
    public void setFeaturePosition(int[] position)
    {
        for (int index = 0; index < features.length; index++)
        {
            switch (index)
            {
                case 0: features[0].setFeaturePosition(position[0]); break;
                case 1: features[1].setFeaturePosition(position[1]); break;
                case 2: features[2].setFeaturePosition(position[2]); break;
                case 3: features[3].setFeaturePosition(position[3]); break;
                default: System.out.println("ERROR - POSITION NOT FOUND");
                break;
            }
        }
    }
    
    /**
     * Set features.
     * 
     * @param i An integer to indicate the index.
     * @param newFeature A nature feature to indicate the a new feature. 
     */
    public void setFeatures(int i, NatureFeature newFeature)
    {
        features[i] = newFeature;
    }
    
    /**
     * Set feature's type.
     * 
     * @param type An integer to indicate the type of the feature.
     */
    public void setFeatureType(int index)
    {
        for (index = 0; index < features.length; index++)
        {
            switch (index)
            {
                case 0: features[0].setFeatureType("Creek"); break;
                case 1: features[1].setFeatureType("Bridge"); break;
                case 2: features[2].setFeatureType("Fallen tree"); break;
                case 3: features[3].setFeatureType("Landslide"); break;
                default: System.out.println("ERROR - TYPE NOT FOUND");
                break;
            }
        }
    }
    
    /**
     * Set space penalty.
     * 
     * @param penalty An integer to indicate the space penalty associated with the feature.
     */
    public void setSpacePenalty(int index)
    {
        for (index = 0; index < features.length; index++)
        {
            switch (index)
            {
                case 0: features[0].setSpacePenalty(-2); break;
                case 1: features[1].setSpacePenalty(4); break;
                case 2: features[2].setSpacePenalty(-3); break;
                case 3: features[3].setSpacePenalty(-5); break;
                default: System.out.println("ERROR - PENALTY NOT FOUND");
                break;
            }
        }
    }
}
