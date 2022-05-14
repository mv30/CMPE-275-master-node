import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class WriteDataIntoJsonFile {
    public static void main(String[] args) throws IOException, ParseException {
        JSONObject emp = new JSONObject();
        emp.put("test4", "Amy");

        WriteDataService writeDataService = new WriteDataService();
        writeDataService.writeDataForKey(emp);
    }
}
