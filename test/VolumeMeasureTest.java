import junit.framework.TestCase;
import measure.MeasureUtil;
import measure.volume.OZ;
import measure.volume.TBSP;
import measure.volume.TSP;
import measure.volume.VolumeMeasureTable;

public class VolumeMeasureTest extends TestCase
{

    protected void setUp() throws Exception
    {
        super.setUp();
        MeasureUtil.setMesaureTable(new VolumeMeasureTable());
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    public void testTSP()
    {
        assertTrue(MeasureUtil.compare(new TSP(3), new TSP(3)) == 0);
        assertFalse(MeasureUtil.compare(new TSP(3), new TSP(2)) > 0);
        assertFalse(MeasureUtil.compare(new TSP(3), new TSP(4)) < 0);
    }

    public void testTBSP()
    {
        assertTrue(MeasureUtil.compare(new TBSP(1), new TSP(3)) == 0);
        assertTrue(MeasureUtil.compare(new TBSP(3), new TBSP(3)) == 0);
        assertFalse(MeasureUtil.compare(new TBSP(1), new TSP(4)) < 0);
        assertFalse(MeasureUtil.compare(new TBSP(3), new TBSP(4)) < 0);

        assertTrue(MeasureUtil.compare(new TBSP(2), new TSP(3 * 2)) == 0);

    }

    public void testOZ()
    {
        assertTrue(MeasureUtil.compare(new OZ(1), new TBSP(2)) == 0);
        assertTrue(MeasureUtil.compare(new OZ(1), new TSP(6)) == 0);
    }

    public void testTransfer()
    {
        assertTrue(MeasureUtil.compare(MeasureUtil.add(new TSP(3), new TSP(2)), new TSP(5)) == 0);
        assertTrue(MeasureUtil.compare(MeasureUtil.add(new TSP(5), new TBSP(2)), new TBSP(3)) == 0);

    }

}
