package pack;

public class Side implements Area {
    final private int x, y;

    Side(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int countAreaSize() {
        return x * y;
    }
}
