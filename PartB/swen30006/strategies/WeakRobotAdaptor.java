package strategies;

import automail.IMailDelivery;
import automail.WeakRobot;

/** Adaptor for weak robots **/
public class WeakRobotAdaptor implements RobotAdaptor {

	@Override
	public WeakRobot create(IMailDelivery delivery) {
		
		return new WeakRobot(delivery);
	}

}
