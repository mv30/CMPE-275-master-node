import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadDataService {
    JSONObject readDataForKey(String key) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("/Users/aravindthonupunuri/Downloads/275final/CMPE-275-master-node/newemps.json");
        Object obj = jsonParser.parse(reader);
        JSONObject empjsonobj = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray)empjsonobj.get("employees");

        JSONObject jsonObject = new JSONObject();
        JSONObject tempJsonObject = new JSONObject();
        for(int i = 0; i < jsonArray.size(); i++) {
            tempJsonObject = (JSONObject)jsonArray.get(i);
            if((String) tempJsonObject.get(key) != null) return tempJsonObject;
        }

        return jsonObject;
    }
}
