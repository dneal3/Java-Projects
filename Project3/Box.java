public class Box extends Rectangle implements Measurable {
    protected double h;
    public Box( double length, double width, double height){
        super(length,width);
        this.h = height;
        this.area = (((this.l * this.h) * 2) + ((this.h * this.w) * 4));
    }

    @Override
    public double getArea() {
        return area;
    }

    public double getLength() {
        return l;
    }

    public double getWidth() {
        return w;
    }
}

