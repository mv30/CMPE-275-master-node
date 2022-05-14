import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;

public class DeleteDataService {
    void deleteDataForKey(String key) throws IOException, ParseException {
        Util util = new Util();
        JSONArray jsonArray = util.getArrayData();

        JSONObject tempJsonObject = new JSONObject();
        for(int i = 0; i < jsonArray.size(); i++) {
            tempJsonObject = (JSONObject)jsonArray.get(i);
            if((String) tempJsonObject.get(key) != null) jsonArray.remove(i);
        }

        util.writeArrayData(jsonArray);
    }
}
