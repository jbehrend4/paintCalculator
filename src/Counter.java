
public class Counter implements Paintable {
    
    private double width;
    private double height;
    private double length;
    private String surfaceMaterial;

    public Counter(double width, double height, double length, String surfaceMaterial) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.surfaceMaterial = surfaceMaterial;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    public double getArea() {
        double area = width * height * length;
        return area;
    }

    public String getSurfaceMaterial() {
        return surfaceMaterial;
    }

    public void setSurfaceMaterial(String surfaceMaterial) {
        this.surfaceMaterial = surfaceMaterial;
    }
    
    public double getStandardCost() {
        double cost = STANDARD_PAINT_COST_PER_GALLON;
        return cost;
    }
    
    public double getPremiumCost() {
        double cost = PREMIUM_PAINT_COST_PER_GALLON;
        return cost;
    }  
}
