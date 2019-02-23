package pack;

import dimensions.Dimensions;

import java.util.ArrayList;
import java.util.List;

public class Packs {
    private final List<Pack> packs;

    private Packs(List<Pack> packs) {
        this.packs = packs;
    }

    public static Packs getPacksFromDimensions(List<Dimensions> dimensionsList) {
        List<Pack> packs = new ArrayList<>(dimensionsList.size());
        for (Dimensions dimensions : dimensionsList) {
            Side front = new Side(dimensions.getX(), dimensions.getZ());
            Side bottom = new Side(dimensions.getX(), dimensions.getY());
            Side side = new Side(dimensions.getY(), dimensions.getZ());

            packs.add(new Pack(front, bottom, side));
        }
        return new Packs(packs);
    }

    List<Pack> getPacks() {
        return packs;
    }
}
