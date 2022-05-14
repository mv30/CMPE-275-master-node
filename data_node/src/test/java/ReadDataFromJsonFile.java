import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ReadDataFromJsonFile {
    public static void main(String[] args) throws IOException, ParseException {
        ReadDataService readDataService = new ReadDataService();
        System.out.println(readDataService.readDataForKey("test2"));
    }
}
