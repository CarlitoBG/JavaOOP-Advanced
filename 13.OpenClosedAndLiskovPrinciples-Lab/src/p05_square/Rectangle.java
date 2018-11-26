package p05_square;

class Rectangle {

    private int m_width;
    private int m_height;

    Rectangle(int width, int height) {
        this.m_width = width;
        this.m_height = height;
    }

    int getWidth() {
        return m_width;
    }

    int getHeight() {
        return m_height;
    }

    int getArea() {
        return m_width * m_height;
    }
}