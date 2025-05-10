package semaforo.trafficLight.control;

import java.util.Timer;
import java.util.TimerTask;

import semaforo.trafficLight.TrafficLight;

public class SimpleTrafficLightControl implements TrafficLightControl {

	final TrafficLight trafficLight = null;
	State state = State.OFF;
	private Timer timer;
	
	private void configureAlert() {
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
		        if (trafficLight.spotYellow().isOn()) {
		           trafficLight.spotYellow().turnOff();
		        } else {
		           trafficLight.spotYellow().turnOn();
		        }
			}
		};
				
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	private void stopAlert() {
		
		if (timer != null) {
            timer.cancel();
            timer.purge();
        }
        if (trafficLight.spotYellow().isOn()) {
            trafficLight.spotYellow().turnOff();
        }
    }
	
	@Override
	public void turnAlert() {
		
		state = State.ALERT;
		trafficLight.spotRed().turnOff();
		trafficLight.spotGreen().turnOff();
		configureAlert();
		
	}
	
	@Override
	public void turnGreen() {
			stopAlert();
			trafficLight.spotYellow().turnOff();
			trafficLight.spotRed().turnOff();
			trafficLight.spotGreen().turnOn(); 
			state = State.GREEN;
			// função timer
			// trafficLight.spotGreen().turnOff();
		}
	
	@Override
	public void turnYellow() {
		stopAlert();
		trafficLight.spotRed().turnOff();
		trafficLight.spotGreen().turnOff();
		trafficLight.spotYellow().turnOn();
		state = State.YELLOW;
		
		// trafficLight.spotYellow().turnOff();
	}
	
	@Override
	public void turnRed() {
		stopAlert();
		trafficLight.spotYellow().turnOff();
		trafficLight.spotGreen().turnOff();
		trafficLight.spotRed().turnOn();
		state = State.RED;
		
		// trafficLight.spotRed().turnOff();
	}
	
	@Override
	public void turnOff() {
		stopAlert();
		trafficLight.spotYellow().turnOff();
		trafficLight.spotGreen().turnOff();
		trafficLight.spotRed().turnOff();
		state = State.OFF;
	}
	

}
