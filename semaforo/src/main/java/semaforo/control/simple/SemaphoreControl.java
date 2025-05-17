package semaforo.control.simple;

import java.time.LocalTime;

import semaforo.util.TurnOnOff;

public interface SemaphoreControl extends TurnOnOff {

	
	void setGreenSeconds(int seconds);
	void setYellowSeconds(int seconds);
	void setRedSeconds(int seconds);
	
	void setAlertPeriod(LocalTime start,
						LocalTime end);
}
