import java.awt.Point;
import java.awt.Rectangle;

public class RectMoveLeft {

    public static void main(String[] args) {
        Point p = new Point(3, 4);
        Rectangle box = new Rectangle(0, 0, 100, 200);

        try {
            rectmoveleft(p, box);
            System.out.println("New box attributes: " +
                    "x=" + box.x + ", " +
                    "y=" + box.y + ", " +
                    "width=" + box.width + ", " +
                    "height=" + box.height
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void rectmoveleft(Point p, Rectangle box) {
        if (p.x < 0) {
            throw new IllegalArgumentException("Usage: input x is not legal");
        }

        box.x = box.x + p.x;
        box.y = box.y + p.y;
    }
}
