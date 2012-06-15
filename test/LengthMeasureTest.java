import junit.framework.TestCase;
import measure.MeasureUtil;
import measure.length.Feet;
import measure.length.Inch;
import measure.length.LengthMeasureTable;
import measure.length.Mile;
import measure.length.Yard;

public class LengthMeasureTest extends TestCase
{

    protected void setUp() throws Exception
    {
        super.setUp();
        MeasureUtil.setMesaureTable(new LengthMeasureTable());
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    public void testMile()
    {
        assertTrue(MeasureUtil.compare(new Mile(3), new Mile(3)) == 0);
        assertFalse(MeasureUtil.compare(new Mile(3), new Mile(2)) > 0);
        assertFalse(MeasureUtil.compare(new Mile(3), new Mile(4)) < 0);
    }

    public void testYard()
    {
        assertTrue(MeasureUtil.compare(new Mile(1), new Yard(1760)) == 0);
        assertTrue(MeasureUtil.compare(new Yard(3), new Yard(3)) == 0);
        assertFalse(MeasureUtil.compare(new Mile(1), new Yard(1761)) < 0);
        assertFalse(MeasureUtil.compare(new Yard(3), new Yard(4)) < 0);

        assertTrue(MeasureUtil.compare(new Mile(2), new Yard(1760 * 2)) == 0);

    }

    public void testFeet()
    {
        assertTrue(MeasureUtil.compare(new Yard(1), new Feet(3)) == 0);
        assertTrue(MeasureUtil.compare(new Feet(1), new Inch(12)) == 0);
    }

    public void testTransferLength()
    {
        assertTrue(MeasureUtil.compare(MeasureUtil.add(new Inch(13), (new Inch(11))), new Inch(24)) == 0);
        assertTrue(MeasureUtil.compare(MeasureUtil.add(new Feet(3), (new Yard(2))), new Yard(3)) == 0);
    }

    public void testLengthMeasureDisplay()
    {
        assertEquals(MeasureUtil.getDisplayString(new Inch(14)), "1 FEET 2 INCH");
        assertEquals(MeasureUtil.getDisplayString(new Inch(24)), "2 FEET");
        assertEquals(MeasureUtil.getDisplayString(new Inch(39)), "1 YARD 3 INCH");
        assertEquals(MeasureUtil.getDisplayString(new Yard(1762)), "1 MILE 2 YARD");
        assertEquals(MeasureUtil.getDisplayString(new Yard(0)), "0 YARD");
        assertEquals(MeasureUtil.getDisplayString(new Feet(5281)), "1 MILE 1 FEET");
    }

    public void testFreeLengthMeasureDisplay()
    {
        assertEquals(MeasureUtil.getDisplayString(new Inch(14), Feet.class.getName()), "1 FEET");
        assertEquals(MeasureUtil.getDisplayString(new Feet(2), Inch.class.getName()), "24 INCH");
        assertEquals(MeasureUtil.getDisplayString(new Feet(2), Yard.class.getName()), "0 YARD");
        assertEquals(MeasureUtil.getDisplayString(new Mile(1), Feet.class.getName()), "5280 FEET");
    }

}
