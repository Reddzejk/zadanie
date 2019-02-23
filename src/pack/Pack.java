package pack;

import java.util.stream.IntStream;

public class Pack implements Area {
    private final Area front, bottom, side;

    Pack(Side front, Side bottom, Side side) {
        this.front = front;
        this.bottom = bottom;
        this.side = side;
    }

    int getSmallestAreaSize() {
        return IntStream
                .of(front.countAreaSize(), bottom.countAreaSize(), side.countAreaSize())
                .min()
                .getAsInt();
    }

    @Override
    public int countAreaSize() {
        return 2 * front.countAreaSize() + 2 * bottom.countAreaSize() + 2 * side.countAreaSize();
    }
}
