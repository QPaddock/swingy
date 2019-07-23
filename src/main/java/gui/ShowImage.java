package gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShowImage extends Panel {
    BufferedImage image;
    String file = "Footsoldier.png";

    public ShowImage() {
        File in = new File(file);
        try {
            image = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Toolkit t = Toolkit.getDefaultToolkit();
        g.drawImage(image, 0, 0, 100, 100, this);
    }
}
