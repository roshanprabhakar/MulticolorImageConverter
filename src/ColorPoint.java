public class ColorPoint {
    private int x;
    private int y;
    private int z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public ColorPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceTo(ColorPoint other) {
        double xs = (other.getX() - this.x) * (other.getX() - this.x);
        double ys = (other.getY() - this.y) * (other.getY() - this.y);
        double zs = (other.getZ() - this.z) * (other.getZ() - this.z);
        return Math.sqrt(xs + ys + zs);
    }

    public double distanceTo(Cluster other) {
        return distanceTo(other.getCenter());
    }
}
