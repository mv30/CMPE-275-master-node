import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteDataService {
    void deleteDataForKey(String key) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("/Users/aravindthonupunuri/Downloads/275final/CMPE-275-master-node/newemps.json");
        Object obj = jsonParser.parse(reader);
        JSONObject empsjsonobj = (JSONObject) obj;

        JSONArray jsonArray = (JSONArray)empsjsonobj.get("employees");

        JSONObject tempJsonObject = new JSONObject();
        for(int i = 0; i < jsonArray.size(); i++) {
            tempJsonObject = (JSONObject)jsonArray.get(i);
            if((String) tempJsonObject.get(key) != null) jsonArray.remove(i);
        }

        JSONObject mainObj = new JSONObject();
        mainObj.put("employees", jsonArray);

        try(FileWriter file = new FileWriter("newemps.json")){
            file.write(mainObj.toJSONString());
            file.flush();
        }
        catch(IOException e) {e.printStackTrace();}
    }
}
