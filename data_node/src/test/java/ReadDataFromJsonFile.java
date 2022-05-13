import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJsonFile {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("/Users/aravindthonupunuri/Downloads/275final/CMPE-275-master-node/data_node/jsonfiles/employee.json");
        Object obj = jsonParser.parse(reader);
        JSONObject empjsonobj = (JSONObject) obj;
        String firstName = (String) empjsonobj.get("firstName");
        String lastName = (String) empjsonobj.get("lastName");
        System.out.println("first name " + firstName);
        System.out.println("last name " + lastName);
    }
}
