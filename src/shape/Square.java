package shape;
public class Square implements Shape
{
    private int side;

    public Square(int side)
    {
        super();
        this.side = side;
    }

    public void setSide(int side)
    {
        this.side = side;
    }

    public int getArea()
    {
        return side * side;
    }

}
