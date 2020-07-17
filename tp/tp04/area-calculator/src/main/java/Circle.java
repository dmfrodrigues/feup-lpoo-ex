public class Circle implements AreaShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
