package CISC3115_Deborah.hw4;

import java.util.Scanner;

class Point2D {
    private String label;
    private double x;
    private double y;

    public Point2D(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }
    public Point2D() {
            this("", 0, 0);
    }


     public Point2D(Scanner scanner) {
            this.label = scanner.next();
            this.x = scanner.nextDouble();
            this.y = scanner.nextDouble();
     }

    public Point2D(String label, Scanner scanner) {
            this.label = label;
            this.x = scanner.nextDouble();
            this.y = scanner.nextDouble();
        }

    public double distance(Point2D point) {
            return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
        }

    public String getLabel() {
            return label;
        }

 public String toString() {
            return label + "(" + this.x + "," + this.y + ")";
        }
}

class Path3 {
    private String label;
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;

    public Path3(String label, Point2D point1, Point2D point2, Point2D point3) {
        this.label = label;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Path3(Scanner scanner) {
        this.label = scanner.next();
        this.point1 = new Point2D("point1", scanner);
        this.point2 = new Point2D("point2", scanner);
        this.point3 = new Point2D("point3", scanner);

    }

    public String toString() {
        return point1.getLabel() + "-" + point2.getLabel() + "-" + point3.getLabel();
    }

    public double length() {
        return point1.distance(point2) + point2.distance(point3);
    }

    public String getLabel() {
        return label;
    }
}
public class BestRoute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Point2D start = new Point2D(scanner);
        Point2D optionA = new Point2D(scanner);
        Point2D optionB = new Point2D(scanner);
        Point2D end = new Point2D(scanner);

        String path1Label = start.getLabel()+"-"+optionA.getLabel()+"-"+end.getLabel();
        String path2Label = start.getLabel()+"-"+optionB.getLabel()+"-"+end.getLabel();

        Path3 path1 = new Path3(path1Label, start, optionA, end);
        Path3 path2 = new Path3(path2Label, start, optionB, end);

        System.out.println("Best Route: " + (path1.length() < path2.length() ? path1.getLabel() : path2.getLabel()));

    }


}
