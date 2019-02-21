package pack;

public class Packer {

    public int countPaperQuantityCounter(Packs packs) {
        return packs.getBoxes()
                .stream()
                .map(box -> box.getSmallestAreaSize() + box.countAreaSuze())
                .mapToInt(x -> x)
                .sum();
    }


}
