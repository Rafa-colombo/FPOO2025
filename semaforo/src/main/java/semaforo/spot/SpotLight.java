package semaforo.spot;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import semaforo.Light.AbstractLight;
import semaforo.Light.Light;
import semaforo.Light.e27.AbstractLightE27;
import semaforo.util.TurnOnOff;
import semaforo.util.gui.Paintable;

public class SpotLight implements TurnOnOff, Paintable{
	
	private Point position = new Point(0,0);
	private Dimension dimension = new Dimension(20,20);
	
	private AbstractLight light;
	private Image maskOn;
	private Image maskOff;
	
	public SpotLight( Image maskOn, Image maskOff) {
		this.maskOn = maskOn;
		this.maskOff= maskOff;
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
		this.light = light;
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
		return this.light != null && this.light.isOn();
	}

	@Override
	public boolean isOff() {
		return this.light != null && this.light.isOff();
	}

	@Override
	public void paint(Graphics g) {
		
		int xLeft = position.x;
		int yTop = position.y;
		int width = dimension.width;
		int height = dimension.height;
		
		if(this.isOn())
			g.drawImage(maskOn, xLeft, yTop,
					width, height, null);
		else
			g.drawImage(maskOn, xLeft, yTop,
					width, height, null);
		
	}

}
