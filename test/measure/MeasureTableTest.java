package measure;

import junit.framework.TestCase;
import measure.length.Inch;
import measure.length.LengthMeasureTable;

public class MeasureTableTest extends TestCase
{

    protected void setUp() throws Exception
    {
        super.setUp();
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    public void testGetTable()
    {
        MeasureTable table = new LengthMeasureTable();
        TableEntry[] tabelEntry = table.getTableEntry();
        assertEquals(tabelEntry[0].measureClassName, Inch.class.getName());
    }
}
