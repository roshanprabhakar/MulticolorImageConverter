public class Main {

    public static void main(String[] args) {
        ClusterFinder finder = new ClusterFinder("testImage.jpg");
        finder.colorizeImage(5);
        finder.displayImage();
    }
}