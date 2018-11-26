package p03_graphic_editor;

public class GraphicEditor {

    private static void drawShape(Drawable drawable){
        drawable.draw();
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        GraphicEditor.drawShape(rectangle);
        GraphicEditor.drawShape(circle);
    }
}