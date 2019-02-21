import dimensions.Dimensions;
import dimensions.FileParser;
import pack.Packer;
import pack.Packs;

import java.util.List;

public class Main {
    private static final String SAMOUCZEK_PROGRAMISTY_FILE_ADDRESS = "https://raw.githubusercontent.com/SamouczekProgramisty/StrefaZadaniowaSamouka/master/test_input.txt";

    public static void main(String[] args) {
        FileParser fileReader = new FileParser(SAMOUCZEK_PROGRAMISTY_FILE_ADDRESS);
        List<Dimensions> dimensions = fileReader.parseFileLinesToDimensions();
        Packs packs = Packs.getPacksFromDimensions(dimensions);
        Packer packer = new Packer();
        int quantity = packer.countPaperQuantityCounter(packs);
        System.out.println(quantity + " dm2");
    }
}
