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
        return getValueInMinimumUnit(m2) - getValueInMinimumUnit(m1);
    }

    public static Measure add(Measure m1, Measure m2)
    {
        //相加后的返回值使用两者中大的度量衡,因此先获取较大的度量衡
        Measure biggerMeasure = getBiggerMeasure(m1, m2);

        Measure result;
        try
        {
            result = (Measure) biggerMeasure.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException("", e);
        }
        result.setValue(getSumInMinimunUnit(m1, m2) / getOneUnitValueInMinimumUnit(biggerMeasure));

        return result;
    }

    private static int getSumInMinimunUnit(Measure m1, Measure m2)
    {
        return getValueInMinimumUnit(m1) + getValueInMinimumUnit(m2);
    }

    public static String getDisplayString(Measure m)
    {
        String displayStr = "";

        TableEntry[] tableEntry = measureTable.getTableEntry();

        displayStr = getDisplayStrDealing(displayStr, getValueInMinimumUnit(m), tableEntry.length - 1);
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
            quotient = length / getOneUnitValueInMinimumUnit(tableEntry[i].measureClassName);
            extra = length % getOneUnitValueInMinimumUnit(tableEntry[i].measureClassName);

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

        return getValueInMinimumUnit(m) / getOneUnitValueInMinimumUnit(displayMeasureClassName) + " "
                + measureTable.getMeasureDisplayName(displayMeasureClassName);

    }

    private static int getOneUnitValueInMinimumUnit(Measure biggerMeasure)
    {
        return getValueInMinimumUnit(1, biggerMeasure.getClass().getName());
    }

    private static int getOneUnitValueInMinimumUnit(String measureClassName)
    {
        return getValueInMinimumUnit(1, measureClassName);
    }

    private static int getValueInMinimumUnit(Measure m)
    {
        return getValueInMinimumUnit(m.getValue(), m.getClass().getName());
    }

    private static int getValueInMinimumUnit(int value, String measureClassName)
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
}
