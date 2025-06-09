package ticTacToe.component.button;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageButton extends Button {

    private Image image;

    public ImageButton(String imagePath, int x, int y, int width, int height) throws IOException {
        super(x, y, width, height);
        loadImage(imagePath);
    }


    private void loadImage(String path) throws IOException {
        
    	image = ImageIO.read(new File(path));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (image != null) {
            g.drawImage(image, position.x, position.y, dimension.width, dimension.height, null);
        }
    }

    public void setImage(String imagePath) throws IOException {
        loadImage(imagePath);
    }
}
