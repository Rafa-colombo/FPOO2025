package semaforo.Light.e27;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import semaforo.Light.Light;

class E27LightBulbTest {

	@Test
	void shouldTurnOn() {
		
		Light light = new E27LightBulb();
		
		light.turnOff();
		light.turnOn();
		
		assertTrue(light.isOn());		
		
	}
	
	void shouldTurnOff() {
		
		Light light = new E27LightBulb();
		
		light.turnOn();
		light.turnOff();
		
		assertFalse(light.isOff());	
		
	}

}

