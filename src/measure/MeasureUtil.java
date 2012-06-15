package measure;

public class MeasureUtil
{
    private static MeasureTable measureTable;

    public static void setMesaureTable(MeasureTable pmeasureTable)
    {
        measureTable = pmeasureTable;
    }

    public static int compare(Measure m1, Measure m2)
    {
        return getValueInMinimumUnit(m2.getValue(), m2.getClass().getName())
                - getValueInMinimumUnit(m1.getValue(), m1.getClass().getName());
    }

    public static int getValueInMinimumUnit(int value, String measureClassName)
    {
        int unitValue = value;
        TableEntry[] tableEntry = measureTable.getTableEntry();
        for (int i = 0; i < tableEntry.length; i++)
        {
            if (!tableEntry[i].measureClassName.equals(measureClassName))
            {
                unitValue = unitValue * tableEntry[i].basicValue;
            }
            else
            {
                return unitValue;
            }
        }
        return unitValue;
    }

    public static Measure add(Measure m1, Measure m2)
    {
        //相加后的返回值使用两者中大的度量衡,因此先获取较大的度量衡
        Measure biggerMeasure = getBiggerMeasure(m1, m2);

        int sumInMinimunUnit = getValueInMinimumUnit(m1.getValue(), m1.getClass().getName())
                + getValueInMinimumUnit(m2.getValue(), m2.getClass().getName());
        int oneUnitValueInMinimumUnit = getValueInMinimumUnit(1, biggerMeasure.getClass().getName());

        Measure result;
        try
        {
            result = (Measure) biggerMeasure.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException("", e);
        }
        result.setValue(sumInMinimunUnit / oneUnitValueInMinimumUnit);

        return result;
    }

    private static Measure getBiggerMeasure(Measure m1, Measure m2)
    {
        if (measureTable.getMeasureIndex(m1) > measureTable.getMeasureIndex(m2))
        {
            return m1;
        }
        else
        {
            return m2;
        }

    }

    public static String getDisplayString(Measure m)
    {
        String displayStr = "";

        TableEntry[] tableEntry = measureTable.getTableEntry();

        displayStr = getDisplayStrDealing(displayStr, getValueInMinimumUnit(m.getValue(), m.getClass().getName()),
                tableEntry.length - 1);
        if (displayStr.equals(""))
        {
            displayStr = "0 " + measureTable.getMeasureDisplayName(m.getClass().getName());

        }

        return displayStr;
    }

    public static String getDisplayStrDealing(String displayStr, int length, int index)
    {
        int quotient = 0;
        int extra = 0;
        TableEntry[] tableEntry = measureTable.getTableEntry();
        for (int i = index; i >= 1;)
        {
            quotient = length / getValueInMinimumUnit(1, tableEntry[i].measureClassName);
            extra = length % getValueInMinimumUnit(1, tableEntry[i].measureClassName);

            if (quotient > 0)
            {
                if (!displayStr.equals(""))
                {
                    displayStr += " ";
                }
                displayStr += quotient + " " + tableEntry[i].measureDisplayName;
            }
            if (extra > 0)
            {
                displayStr = getDisplayStrDealing(displayStr, extra, --i);
                break;
            }
            else
            {
                return displayStr;
            }

        }
        if (index == 0)
        {
            displayStr = displayStr + " " + length + " " + tableEntry[0].measureDisplayName;
        }
        return displayStr;

    }

    public static String getDisplayString(Measure m, String displayMeasureClassName)
    {

        return getValueInMinimumUnit(m.getValue(), m.getClass().getName())
                / getValueInMinimumUnit(1, displayMeasureClassName) + " "
                + measureTable.getMeasureDisplayName(displayMeasureClassName);

    }
}
