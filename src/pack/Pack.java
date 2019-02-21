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
                .of(front.countAreaSuze(), bottom.countAreaSuze(), side.countAreaSuze())
                .min()
                .getAsInt();
    }

    @Override
    public int countAreaSuze() {
        return 2 * front.countAreaSuze() + 2 * bottom.countAreaSuze() + 2 * side.countAreaSuze();
    }
}
