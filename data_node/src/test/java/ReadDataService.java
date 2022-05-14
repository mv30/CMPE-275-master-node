import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ReadDataService {
    JSONObject readDataForKey(String key) throws IOException, ParseException {
        Util util = new Util();
        JSONArray jsonArray = util.getArrayData();
        JSONObject jsonObject = new JSONObject();
        JSONObject tempJsonObject = new JSONObject();
        for(int i = 0; i < jsonArray.size(); i++) {
            tempJsonObject = (JSONObject)jsonArray.get(i);
            if((String) tempJsonObject.get(key) != null) return tempJsonObject;
        }

        return jsonObject;
    }
}
