package measure;

public abstract class Measure implements Cloneable
{
    private int value;

    public Measure(int value)
    {
        this.value = value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

}
