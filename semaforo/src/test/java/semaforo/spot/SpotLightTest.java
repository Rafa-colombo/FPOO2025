package semaforo.spot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpotLightTest {

	@Test
	void shouldTurnOn() {
		AbstractLightE27 light = new E27LightBulb();
		SpotLight spot = new SpotLight(null);
		spot.setLight(light);
	}

}
