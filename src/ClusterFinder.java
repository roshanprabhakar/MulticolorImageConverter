import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ClusterFinder {

    BufferedImage image;
    ArrayList<Cluster> clusters;

    //DESCRIPTION:
    //red is the 1D
    //green is the 1D inside red
    //blue is the 1D inside green
    ColorPoint[][][] CUBE;

    public ClusterFinder(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CUBE = new ColorPoint[255][255][255];
        clusters = new ArrayList<>();

        for (int row = 0; row < image.getHeight(); row++) {
            for (int col = 0; col < image.getWidth(); col++) {
                Color color = new Color(image.getRGB(col, row));
                CUBE[color.getRed()][color.getGreen()][color.getBlue()] =
                        new ColorPoint(color.getRed(), color.getBlue(), color.getGreen());
            }
        }
    }

    public void assignPointsToClusters() {
        for (int r = 0; r < image.getHeight(); r++) {
            for (int c = 0; c < image.getWidth(); c++) {
                Color color = new Color(image.getRGB(c, r));
                ColorPoint p = new ColorPoint(color.getRed(), color.getGreen(), color.getBlue());
                findClosestClusterTo(p).add(p);
            }
        }
    }

    private Cluster findClosestClusterTo(ColorPoint p) {
        Cluster closestCluster = new Cluster();
        closestCluster.setCenter(new ColorPoint(255 / 2, 255 / 2, 255 / 2));
        for (Cluster c : clusters) {
            if (p.distanceTo(c) < p.distanceTo(closestCluster)) {
                closestCluster = c;
            }
        }
        return closestCluster;
    }
}
