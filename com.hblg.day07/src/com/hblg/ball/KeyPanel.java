package com.hblg.ball;

import javax.swing.*;
import java.awt.*;

public class KeyPanel extends JPanel {
    Ball ball ;

    KeyPanel(Ball ball ){
        this.ball = ball;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.RED);
        g.fillOval(ball.x,ball.y,ball.r*2,ball.r*2);
    }
}
