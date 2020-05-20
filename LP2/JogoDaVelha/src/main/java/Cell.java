public class Cell {
    int x;
    int y;
    Point point;

    public Cell(int x, int y, Point point) {
        this.x = x;
        this.y = y;
        this.point = point;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", point=" + point +
                '}';
    }
}
