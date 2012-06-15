package shape;
public class Rectangle implements Shape
{
    public int width;

    public int height;

    public Rectangle(int width, int height)
    {
        super();
        this.width = width;
        this.height = height;
    }

    /**
     * 参见父类或接口方法说明
     * @see Shape#getArea()
     * @return
     */
    public int getArea()
    {
        return width * height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

}
