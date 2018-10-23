public class Sphere extends Circle implements Measurable{

    public Sphere(double radius) {
        super(radius);
        this.area = this.area * 4;
    }

    @Override
    public double getArea() {
        return area;
    }
}

