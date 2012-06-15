import shape.Rectangle;
import shape.Square;
import junit.framework.TestCase;

public class ShapeTest extends TestCase
{

    public void testRectangleGetArea()
    {
        Rectangle r = new Rectangle(100, 200);
        assertEquals(20000, r.getArea());

        r.setHeight(200);
        r.setWidth(200);
        assertEquals(40000, r.getArea());

    }

    public void testSquareGetArea()
    {
        Square sqr = new Square(100);
        assertEquals(10000, sqr.getArea());
        sqr.setSide(9);
        assertEquals(81, sqr.getArea());
    }

}
