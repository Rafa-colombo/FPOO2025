package semaforo.app;

import java.io.IOException;
import java.time.LocalTime;

import semaforo.control.simple.OneWaySemaphoreControl;
import semaforo.control.simple.SemaphoreControl;
import semaforo.trafficLight.simple.SimpleTrafficLight;
import semaforo.util.gui.MyWindow;
import semaforo.trafficLight.control.SimpleTrafficLightControl;
import semaforo.trafficLight.control.TrafficLightControl;

public class AppOneWaySimpleSemaphoreControlTest {
	
	static private
	void oneWaySimpleSemaphoreTest() throws IOException {
	
		SimpleTrafficLight defaultOne = new SimpleTrafficLight();
		TrafficLightControl trafficLightControl = new SimpleTrafficLightControl(defaultOne);
		SemaphoreControl semaphoreControl = new OneWaySemaphoreControl(trafficLightControl);
		
		semaphoreControl.setAlertPeriod(LocalTime.now(),
										LocalTime.now().plusSeconds(30));
		semaphoreControl.turnOn();
		
		MyWindow window = new MyWindow();
		window.add(defaultOne);
	}
	
	static public
	void main(String[] args) throws IOException {
		
		oneWaySimpleSemaphoreTest();
	}
	
}
