package automail;

/**
 * Standard robot subclass, inherits from Robot.
 */
public class StandardRobot extends Robot {
	
	/** Standard robot tube capacity **/
	public static final int STANDARD_CAPACITY = 4;

	/**
     * Constructor for a standard robot
     * @param delivery governs the final delivery
     */
	public StandardRobot(IMailDelivery delivery) {
		super(delivery, true, false, STANDARD_CAPACITY);
	}
}