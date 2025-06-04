package ticTacToe.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import ticTacToe.gui.Paintable;
import ticTacToe.util.MouseListenerAdapter;

public class Button extends AbstractComponent{

	
	public Button() {
		super();
	}
	
	public Button(int x, int y) {
		super(x, y);
	}
	
	public Button(int x, int y,int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public void paint(Graphics g) {
		

		g.drawRect(position.x, position.y, 
				   dimension.width, dimension.height);
		
		if (mouseOver == true) {
			doMouseOverDecoration(g);
		}
	}
	
	private void doMouseOverDecoration(Graphics g) {
		
		Color corOriginal = g.getColor();
		
        g.setColor(Color.RED);
        g.drawRect(position.x + 2, position.y + 2, dimension.width - 4, dimension.height - 4);
        g.setColor(corOriginal);
       
	}
	
	//--reacting to mouse click---------------------------------------------------------------

	 public MouseListener mouseMouseListener() {
	        return new MouseListenerAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                mouseOver = true;
	                e.getComponent().repaint();
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                mouseOver = false;
	                e.getComponent().repaint();
	            }
	        };
	    }
}
