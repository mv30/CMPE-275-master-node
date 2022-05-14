import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;

public class UpdateDataService {
    void updateDataForKey(String key, String updatedValue) throws IOException, ParseException {
        Util util = new Util();
        JSONArray jsonArray = util.getArrayData();

        JSONObject tempJsonObject = new JSONObject();
        for (int i = 0; i < jsonArray.size(); i++) {
            tempJsonObject = (JSONObject) jsonArray.get(i);
            if ((String) tempJsonObject.get(key) != null) {
                jsonArray.remove(i);
                tempJsonObject.put(key, updatedValue);
                jsonArray.add(tempJsonObject);
            }
        }

        util.writeArrayData(jsonArray);
    }
}
