package semaforo.control.simple;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semaforo.trafficLight.control.TrafficLightControl;


public class OneWaySemaphoreControl implements SemaphoreControl {

	private List<TrafficLightControl> trafficLights = new ArrayList<>();
	
	private int greenMillis = 10_000;
	private int yellowMillis = 2_000;
	private int redMillis = 5_000;
	
	private LocalTime alertStart = LocalTime.of(0, 0);
	private LocalTime alertEnd = LocalTime.of(5, 30);
	
	private OnOff state = OnOff.OFF;
	
	public OneWaySemaphoreControl(List<TrafficLightControl> trafficLights) {
		
		this.trafficLights = trafficLights;
	}
	
	public OneWaySemaphoreControl(TrafficLightControl...trafficLights) {
		
		this(Arrays.asList(trafficLights));
	}
	
	private boolean isAlertPeriod() {
		
		boolean START_MIDNIGHT_END = alertStart.isAfter(alertEnd);
		
		LocalTime now = LocalTime.now();
		
		if(START_MIDNIGHT_END)
			return (now.isAfter(alertStart) || now.isBefore(alertEnd));
		
		return (now.isAfter(alertStart) && now.isBefore(alertEnd));
	}
	
	private void doAlert() throws InterruptedException {
		
		while(isAlertPeriod()) {
			
			trafficLights.forEach(e->e.turnAlert());
			Thread.sleep(1_000);
		}
	}
	
	private void doYellowRedGreen() throws InterruptedException {
		
		trafficLights.forEach(e->e.turnYellow());
		Thread.sleep(yellowMillis);
		
		trafficLights.forEach(e->e.turnRed());
		Thread.sleep(redMillis);
		
		trafficLights.forEach(e->e.turnGreen());
		Thread.sleep(greenMillis);
	}
	
	private void run() {
		
		Runnable runnable = ()->{
			
			while (state == OnOff.ON) {
				
				try {
					
					doAlert();
					doYellowRedGreen();
				}
				catch(InterruptedException exception) {
					
					trafficLights.forEach(e->e.turnAlert());
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOff() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setGreenSeconds(int seconds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYellowSeconds(int seconds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRedSeconds(int seconds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAlertPeriod(LocalTime start, LocalTime end) {
		// TODO Auto-generated method stub
		
	}

}
