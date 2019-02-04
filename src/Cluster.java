import java.awt.*;
import java.util.ArrayList;

public class Cluster {

    private ArrayList<ColorPoint> points;
    private ColorPoint center;
    private int color;

    public Cluster() {
        points = new ArrayList<>();
        color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)).getRGB();
    }

    public ColorPoint getCenter() {
        return this.center;
    }

    public void setCenter(ColorPoint p) {
        this.center = p;
    }

    public void clear() {
        points.clear();
    }

    public void add(ColorPoint p) {
        points.add(p);
    }

    public void recalculateCenter() {
        int sumx = 0, sumy = 0, sumz = 0;
        for (ColorPoint cp : points) {
            sumx += cp.getX();
            sumy += cp.getY();
            sumz += cp.getZ();
        }
        center.setX(sumx / points.size());
        center.setY(sumy / points.size());
        center.setZ(sumz / points.size());
    }
}
