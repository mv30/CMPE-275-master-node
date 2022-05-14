import org.json.simple.parser.ParseException;

import java.io.IOException;

public class UpdateDataInJsonFile {
    public static void main(String[] args) throws IOException, ParseException {
        UpdateDataService updateDataService = new UpdateDataService();
        updateDataService.updateDataForKey("test2", "some random data");
    }
}
