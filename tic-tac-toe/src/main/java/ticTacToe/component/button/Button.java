package ticTacToe.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.ButtonClickEvent.MouseButton;
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

	public MouseListener mouseListener() {
		
		return new MouseListenerAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent me) {
				
				if(!isOver(me.getPoint()))
					return;
				
				onMouseClick(me);
			}
		};
	}
	 
	 //--Observer Pattern
	 Set<ButtonClickListener> buttonClickListeners = new HashSet();
	 
	 public void addButtonClickListener(ButtonClickListener listener) {
		 buttonClickListeners.add(listener);
	 }
	 
	 public void removeButtonClickListener(ButtonClickListener listener) {
		 buttonClickListeners.remove(listener);
	 }
	 
	 private void dispatchButtonClickEvent(MouseEvent me) {
		 
		 MouseButton button = ((me.getButton() == MouseEvent.BUTTON1) ? MouseButton.LEFT :
			 				  (me.getButton() == MouseEvent.BUTTON2) ? MouseButton.MIDLE :
			 					  MouseButton.RIGHT );
		 
		 ButtonClickEvent event = new ButtonClickEvent(this, button);
		 buttonClickListeners.forEach(listener->listener.onClick(event));
	 }
	 
	 protected void onMouseClick(MouseEvent me) {
			dispatchButtonClickEvent(me);
		}
}
