import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Util {
    JSONArray getArrayData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("/Users/aravindthonupunuri/Downloads/275final/CMPE-275-master-node/newemps.json");
        Object obj = jsonParser.parse(reader);
        JSONObject empjsonobj = (JSONObject) obj;
        return (JSONArray)empjsonobj.get("employees");
    }

    void writeArrayData(JSONArray jsonArray) {
        JSONObject mainObj = new JSONObject();
        mainObj.put("employees", jsonArray);

        try(FileWriter file = new FileWriter("newemps.json")){
            file.write(mainObj.toJSONString());
            file.flush();
        }
        catch(IOException e) {e.printStackTrace();}
    }
}
