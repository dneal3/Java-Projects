public class Rectangle implements Measurable {

    protected double l;
    protected double w;
    protected double area;

    public Rectangle( double length, double width){
        this.l = length;
        this.w = width;
        this.area = length*width;
    }

    @Override
    public double getArea(){
        return area;
    }

    public double getLength() {
        return l;
    }

    public double getWidth() {
        return w;
    }
}
