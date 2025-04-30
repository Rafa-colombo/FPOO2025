package semaforo.trafficLight.simple;

import java.awt.Point;

import semaforo.spot.SpotLight;

import java.awt.Dimension;
import java.awt.Image;

public class SimpleTrafficLight {
	
    private Point position;
    private Dimension dimension;
    private Image mask;
    private SpotLight yellow;
    private SpotLight green;
    private SpotLight red;

    public SimpleTrafficLight() {
        this.position = new Point();
        this.dimension = new Dimension();
    }

    public SimpleTrafficLight(Point position, Dimension dimension) {
        this.position = position;
        this.dimension = dimension;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Dimension getDimension() {
        return this.dimension;
    }

    public void create() {
        // to do
    }
}
