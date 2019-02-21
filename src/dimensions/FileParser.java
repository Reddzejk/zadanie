package dimensions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileParser {

    private URL url = null;

    public FileParser(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException ex) {
            System.out.println("URL to file is incorrect");
            System.exit(-1);
        }
    }

    public List<Dimensions> parseFileLinesToDimensions(){
        return readLinesFromRemoteFile()
                .stream()
                .map(fileLine -> fileLine.split("x"))
                .map(dimensionsStrings -> {
                    int x = Integer.parseInt(dimensionsStrings[0]);
                    int y = Integer.parseInt(dimensionsStrings[1]);
                    int z = Integer.parseInt(dimensionsStrings[2]);
                    return new Dimensions(x, y, z);
                })
                .collect(Collectors.toList());
    }

    private List<String> readLinesFromRemoteFile() {
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }

        return lines;
    }

}
