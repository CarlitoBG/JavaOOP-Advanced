package p01_shapes_drawing;

public class Rectangle implements Drawable{

    private Integer width;
    private Integer height;

    Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        drawLine(this.width, "*");
        for (int i = 1; i < this.height - 1; i++) {
            drawLine(this.width, " ");
        }
        drawLine(this.width, "*");
    }

    private void drawLine(Integer length, String fill) {
        System.out.print("*" + " ");
        for (int j = 1; j < length - 1; j++) {
            System.out.print(fill + " ");
        }
        System.out.println("*");
    }
}