public class Circle implements Measurable {
    protected double r;
    protected double area;

    public Circle(double radius) {
       this.r = radius;
       this.area = Math.PI * Math.pow(this.r,2);
    }

    @Override
    public double getArea() {
        return area;
    }

    public double getRadius() {
        return r;
    }
}
