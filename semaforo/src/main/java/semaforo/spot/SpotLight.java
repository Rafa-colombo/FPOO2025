package semaforo.spot;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import semaforo.Light.Light;
import semaforo.Light.e27.AbstractLightE27;
import semaforo.util.TurnOnOff;

public class SpotLight implements TurnOnOff{
	
	private Point position = new Point(0,0);
	private Dimension dimension = new Dimension(20,20);
	
	private Light light;
	private Image mask;
	
	public SpotLight(Image mask) {
		this.mask = mask;
	}
	
	public void setPosition(int xLeft, int yTop) {
		this.position = new Point(xLeft, yTop);
	}
	
	public Point getPosition() {
		return (Point) this.position.clone();
	}
	

	public void setDimension(Dimension dimension) {
		this.dimension = new Dimension(dimension);
	}
	
	public Dimension getDimension() {
		return (Dimension) this.dimension.clone();
	}
	
	public void setSize(int width, int height) {
		this.dimension = new Dimension(width, height);
	}
	
	public void setLight(AbstractLightE27 light) {
		this.light = (Light) light;
	}
	
	@Override
	public void turnOn() {
		this.light.turnOn();	
	}
	
	@Override
	public void turnOff() {
		this.light.turnOff();	
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

}
