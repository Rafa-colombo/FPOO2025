package appTest;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ticTacToe.component.button.ImageButton;
import ticTacToe.component.button.ButtonClickEvent;
import ticTacToe.component.button.ButtonClickListener;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;


public class AppImageButtonTest {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Teste ImageButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        ImageButton imageButton = new ImageButton("D:\\POO\\tic-tac-toe\\src\\main\\resources\\ticTacToe\\images\\button_png", 100, 100, 100, 100);
        imageButton.addButtonClickListener(new ButtonClickListener() {
            @Override
            public void onClick(ButtonClickEvent e) {
                System.out.println("Botão com imagem clicado!");
            }
        });

        JPanel panel = new JPanel() {
            {
                addMouseListener(imageButton.mouseListener());
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                imageButton.paint(g);
            }
        };

        panel.setPreferredSize(new Dimension(400, 300));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

