package semaforo.trafficLight.control;

import java.util.Timer;
import java.util.TimerTask;

import semaforo.trafficLight.TrafficLight;
import semaforo.util.TurnOnOff;

public class SimpleTrafficLightControl implements TrafficLightControl {

	private final TrafficLight trafficLight;
	private final TurnOnOff green, yellow, red;
	
	private State state = State.OFF;
	private Timer timer;
	
	public SimpleTrafficLightControl (TrafficLight trafficLight) {
		
		this.trafficLight = trafficLight;
		
		this.green = trafficLight.spotGreen();
		this.yellow = trafficLight.spotYellow();
		this.red = trafficLight.spotRed();
	}
	
	public void reset() {
		
		if(state == State.ALERT)
			stopAlert();
		
		yellow.turnOff();
		green.turnOff();
		red.turnOff();
		
		state = State.OFF;
	}
	
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
		
		if(state == State.ALERT)
			return;
		
		this.reset();
		this.configureAlert();
		
		state = State.ALERT;
	}
	
	@Override
	public void turnGreen() {
		
		this.reset();
		trafficLight.spotGreen().turnOn(); 
		state = State.GREEN;
		
		}
	
	@Override
	public void turnYellow() {

		this.reset();
		trafficLight.spotYellow().turnOn(); 
		state = State.YELLOW;
		
	}
	
	@Override
	public void turnRed() {

		this.reset();
		trafficLight.spotRed().turnOn(); 
		state = State.RED;
		
	}
	
	@Override
	public void turnOff() {
		this.reset();
	}
	

}
