package measure.volume;

import measure.MeasureTable;

public class VolumeMeasureTable extends MeasureTable
{
    public static final String TSP_CLASS_NAME = TSP.class.getName();

    public static final String TBSP_CLASS_NAME = TBSP.class.getName();

    public static final String OZ_CLASS_NAME = OZ.class.getName();

    public static final int TBSP_TO_TSP = 3;

    public static final int OZ_TO_TBSP = 2;

    public static final int PLCACE_HOLDER = 0;

    private static final String[] measureClassName = { TSP_CLASS_NAME, TBSP_CLASS_NAME, OZ_CLASS_NAME, };

    private static final int[] basicValue = { TBSP_TO_TSP, OZ_TO_TBSP, PLCACE_HOLDER };

    public VolumeMeasureTable()
    {
        super(measureClassName, new String[] { "", "", "" }, basicValue);
    }
}
