import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class WriteDataService {
    void writeDataForKey(JSONObject obj) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("/Users/aravindthonupunuri/Downloads/275final/CMPE-275-master-node/newemps.json");
        Object oldObj = jsonParser.parse(reader);
        JSONObject empjsonobj = (JSONObject) oldObj;
        JSONArray jsonArray = (JSONArray)empjsonobj.get("employees");
        jsonArray.add(obj);

        JSONObject mainObj = new JSONObject();
        mainObj.put("employees", jsonArray);

        try(FileWriter file = new FileWriter("newemps.json")){
            file.write(mainObj.toJSONString());
            file.flush();
        }
        catch(IOException e) {e.printStackTrace();}
    }
}
