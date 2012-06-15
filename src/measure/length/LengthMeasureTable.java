package measure.length;

import measure.MeasureTable;

public class LengthMeasureTable extends MeasureTable
{
    public static final String INCH_CLASS_NAME = Inch.class.getName();

    public static final String FEET_CLASS_NAME = Feet.class.getName();

    public static final String YARD_CLASS_NAME = Yard.class.getName();

    public static final String MILE_CLASS_NAME = Mile.class.getName();

    public static final String INCH_DISPLAY_NAME = "INCH";

    public static final String FEET_DISPLAY_NAME = "FEET";

    public static final String YARD_DISPLAY_NAME = "YARD";

    public static final String MILE_DISPLAY_NAME = "MILE";

    public static final int MILE_TO_YARD = 1760;

    public static final int YARD_TO_FEET = 3;

    public static final int FEET_TO_INCH = 12;

    public static final int PLCACE_HOLDER = 0;

    private static final String[] measureClassName = { INCH_CLASS_NAME, FEET_CLASS_NAME, YARD_CLASS_NAME,
            MILE_CLASS_NAME };

    private static final String[] measureDisplayName = { INCH_DISPLAY_NAME, FEET_DISPLAY_NAME, YARD_DISPLAY_NAME,
            MILE_DISPLAY_NAME };

    private static final int[] basicValue = { FEET_TO_INCH, YARD_TO_FEET, MILE_TO_YARD, PLCACE_HOLDER };

    public LengthMeasureTable()
    {
        super(measureClassName, measureDisplayName, basicValue);
    }

}