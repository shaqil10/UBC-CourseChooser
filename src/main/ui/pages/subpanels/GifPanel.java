package ui.pages.subpanels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

//represents the panel containing the GIF animation
public class GifPanel extends JPanel {
    ArrayList<Image> frames;

    public GifPanel() {
        super(new BorderLayout());
        frames = new ArrayList<>();
        createAnimation();
    }

    //EFFECTS: creates the GIF animation and adds it to the panel
    private void createAnimation() {
        try {
            makeFrames();
        } catch (Exception e) {
            //
        }
        final JLabel animation = new JLabel(new ImageIcon(frames.get(0)));
        add(animation, BorderLayout.CENTER);

        ActionListener animate = new ActionListener() {
            private int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < frames.size() - 1) {
                    index++;
                } else {
                    index = 0;
                }
                animation.setIcon(new ImageIcon(frames.get(index)));
            }
        };
        final Timer timer = new Timer(70, animate);
        timer.start();
    }

    //The following 27 methods are all simple methods that retrieve each individual frame of the GIF saved locally
    // in the project and return the image so it can be accessed by methods in this class
    public static Image getFrame1() throws Exception {
        File file = new File("./data/frame_00_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame2() throws Exception {
        File file = new File("./data/frame_01_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame3() throws Exception {
        File file = new File("./data/frame_02_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame4() throws Exception {
        File file = new File("./data/frame_03_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame5() throws Exception {
        File file = new File("./data/frame_04_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame6() throws Exception {
        File file = new File("./data/frame_05_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame7() throws Exception {
        File file = new File("./data/frame_06_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame8() throws Exception {
        File file = new File("./data/frame_07_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame9() throws Exception {
        File file = new File("./data/frame_08_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame10() throws Exception {
        File file = new File("./data/frame_09_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame11() throws Exception {
        File file = new File("./data/frame_10_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame12() throws Exception {
        File file = new File("./data/frame_11_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame13() throws Exception {
        File file = new File("./data/frame_12_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame14() throws Exception {
        File file = new File("./data/frame_13_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame15() throws Exception {
        File file = new File("./data/frame_14_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame16() throws Exception {
        File file = new File("./data/frame_15_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame17() throws Exception {
        File file = new File("./data/frame_16_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame18() throws Exception {
        File file = new File("./data/frame_17_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame19() throws Exception {
        File file = new File("./data/frame_18_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame20() throws Exception {
        File file = new File("./data/frame_19_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame21() throws Exception {
        File file = new File("./data/frame_20_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame22() throws Exception {
        File file = new File("./data/frame_21_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame23() throws Exception {
        File file = new File("./data/frame_22_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame24() throws Exception {
        File file = new File("./data/frame_23_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame25() throws Exception {
        File file = new File("./data/frame_24_delay-0.07s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame26() throws Exception {
        File file = new File("./data/frame_25_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static Image getFrame27() throws Exception {
        File file = new File("./data/frame_26_delay-0.06s.png");
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    //EFFECTS: builds the list of Images that make up the GIF animation
    public void makeFrames() throws Exception {
        frames.add(getFrame1());
        frames.add(getFrame2());
        frames.add(getFrame3());
        frames.add(getFrame4());
        frames.add(getFrame5());
        frames.add(getFrame6());
        frames.add(getFrame7());
        frames.add(getFrame8());
        frames.add(getFrame9());
        frames.add(getFrame10());
        frames.add(getFrame11());
        frames.add(getFrame12());
        frames.add(getFrame13());
        frames.add(getFrame14());
        frames.add(getFrame15());
        frames.add(getFrame16());
        frames.add(getFrame17());
        makeRestFrames();
    }

    private void makeRestFrames() throws Exception {
        frames.add(getFrame18());
        frames.add(getFrame19());
        frames.add(getFrame20());
        frames.add(getFrame21());
        frames.add(getFrame22());
        frames.add(getFrame23());
        frames.add(getFrame24());
        frames.add(getFrame25());
        frames.add(getFrame26());
        frames.add(getFrame27());
    }
}
