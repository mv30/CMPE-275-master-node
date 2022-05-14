import org.json.simple.parser.ParseException;

import java.io.IOException;

public class DeleteDataFromJsonFile {
    public static void main(String[] args) throws IOException, ParseException {
        DeleteDataService deleteDataService = new DeleteDataService();
        deleteDataService.deleteDataForKey("test1");
    }
}
