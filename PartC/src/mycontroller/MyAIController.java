package mycontroller;

import mycontroller.Pathway;
import controller.CarController;
import world.Car;
import utilities.Coordinate;
import mycontroller.strategy.StrategyManager;

public class MyAIController extends CarController{
	
	private StrategyManager stManager;
	
	private Pathway pathway;
	
	private Coordinate lastPosition;

	/**
	 * constructor for MyAIController
	 * @param car Car object
	 */
	public MyAIController(Car car) {
		super(car);
		MapRecorder.loadMap(super.getMap());
		stManager = new StrategyManager();
	}

	@Override
	public void update() {
		
		// may check if the car moves first?
		MapRecorder.updateCarView(super.getView());
		
		if(checkUpdateManager()) {
			pathway = stManager.findNewPathway(this);
		}
		
		// when pathway.desti is (-1, -1), stays the same
		// only appears when standing in health area
		if(Pathway.STAYS.equals(pathway.getDesti())) {
			// stays
		} else {
			drive();
		}
		
		// use pipeline to decide path.. drive on path..
		// consider the situation when target hasn't changed
	}
	
	private boolean checkUpdateManager() {
		return pathway.getPath().size() == 0 || stManager.checkAndTakeover(this);
	}
	
	public void drive() {
		
	}

}
