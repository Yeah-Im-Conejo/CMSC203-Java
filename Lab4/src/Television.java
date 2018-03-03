/** 
 *The purpose of this class is to model a television
 *@author Josue Ponce 
 *Date:2/26/18
 */
public class Television {

    /** Attribute MANUFACTURER holds the name of the T.V's MANUFACTURER*/
    private final String MANUFACTURER;

    /** Attribute SCREEN_SIZE holds the size of the T.V's screen*/
    private final int SCREEN_SIZE;

    /** Attribute powerOn determines whether the T.V is powered on or not. */
    private boolean powerOn;

    /** Attribute channel holds the channel the T.V is currently set to*/
    private int channel;

    /** Attribute volume holds the T.V's current volume*/
    private int volume;


    /** Constructor class that initiates the MANUFACTURER and SCREEN_SIZE with the value in parameters.
     * The remaining properties are assigned default values
     * @param MANUFACTUER represents the final brand name of the T.V
     * @param SCREEN_SIZE represents the final screen size of the T.V will display. 
     */


    public Television(String MANUFACTURER, int SCREEN_SIZE) {

        this.MANUFACTURER = MANUFACTURER;

        this.SCREEN_SIZE = SCREEN_SIZE;

        this.powerOn = false;

        this.volume = 20;

        this.channel = 2;
    }

    /**mutator method stores the desired T.V channel. 
     * @param station will hold the desired T.V channel. 
     */
    public void setChannel(int station) {
        this.channel = station;
    }

    /** Mutator Method toggles the power on and off. changes the boolean state from false to true 
     * in other words, powerOn will be set to true by declaring powerOn = !powerOn
     * 
     */
    public void power() {

        this.powerOn = !powerOn;
    }

    /**sets and increases the T.V's volume by one*/
    public void increaseVolume() {
        this.volume = volume + 1;
    }


    /**sets and decreases the T.V's volume by one*/
    public void decreaseVolume() {
        this.volume = volume - 1;
    }


    /** accessor method returns the current channel
     * @return the T.V's current channel
     */
    public int getChannel() {
        return channel;
    }

    /** accessor method returns the current volume
     * @return the T.V's current volume
     */

    public int getVolume() {
        return volume;
    }

    /** accessor method returns the name of the T.V's manufacturer.
     * @return the name of the T.V's manufacturer.
     */
    public String getManufacturer() {
        return MANUFACTURER;
    }

    /** accessor method returns the T.V's Screensize.
     * @return the T.V's Screensize.
     */
    public int getScreenSize() {
        return SCREEN_SIZE;
    }

}