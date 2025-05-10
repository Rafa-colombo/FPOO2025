package semaforo.trafficLight;

import semaforo.util.TurnOnOff;

public interface TrafficLight {

	TurnOnOff spotGreen();
	TurnOnOff spotYellow();
	TurnOnOff spotRed();
}
