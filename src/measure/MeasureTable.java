package measure;

public class MeasureTable
{
    private TableEntry[] table;

    public MeasureTable(String[] measureClassName, String[] measureDisplayName, int[] basicValue)
    {
        if (measureClassName == null || basicValue == null || measureClassName.length != basicValue.length)
        {
            throw new IllegalArgumentException();
        }
        table = new TableEntry[measureClassName.length];
        for (int i = 0; i < measureClassName.length; i++)
        {
            TableEntry entry = new TableEntry();
            entry.measureClassName = measureClassName[i];
            entry.measureDisplayName = measureDisplayName[i];
            entry.basicValue = basicValue[i];
            table[i] = entry;
        }

    }

    public TableEntry[] getTableEntry()
    {
        return table;
    }

    public int getMeasureIndex(Measure m)
    {
        TableEntry[] tableEntry = getTableEntry();
        for (int i = 0; i < tableEntry.length; i++)
        {
            if (tableEntry[i].measureClassName.equals(m.getClass().getName()))
            {
                return i;

            }
        }
        return -1;
    }

    public String getMeasureDisplayName(String measureClassName)
    {
        TableEntry[] tableEntry = getTableEntry();
        for (int i = 0; i < tableEntry.length; i++)
        {
            if (tableEntry[i].measureClassName.equals(measureClassName))
            {
                return tableEntry[i].measureDisplayName;

            }
        }
        return "";

    }
}

class TableEntry
{
    public String measureClassName;

    public String measureDisplayName;

    public int basicValue;
}