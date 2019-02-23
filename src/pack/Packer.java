package pack;

public class Packer {

    public int countPaperQuantityCounter(Packs packs) {
        return packs.getPacks()
                .stream()
                .map(box -> box.getSmallestAreaSize() + box.countAreaSize())
                .mapToInt(x -> x)
                .sum();
    }
}
