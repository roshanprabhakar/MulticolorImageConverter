import java.awt.*;

public class ColorPoint {

    private Cluster cluster;

    private int r;
    private int g;
    private int b;

    private int x;
    private int y;

    public Cluster getCluster() {
        return this.cluster;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setCluster(Cluster c) {
        cluster = c;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public ColorPoint(int r, int g, int b, int x, int y) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.x = x;
        this.y = y;
    }

    public double distanceTo(ColorPoint other) {
        double xs = (other.getR() - this.r) * (other.getR() - this.r);
        double ys = (other.getG() - this.g) * (other.getG() - this.g);
        double zs = (other.getB() - this.b) * (other.getB() - this.b);
        return Math.sqrt(xs + ys + zs);
    }

    public double distanceTo(Cluster other) {
        return distanceTo(other.getCenter());
    }

    public Color getColor() {
        return new Color(r, g, b);
    }
}