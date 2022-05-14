import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class WriteDataService {
    void writeDataForKey(JSONObject obj) throws IOException, ParseException {
        Util util = new Util();
        JSONArray jsonArray = util.getArrayData();
        jsonArray.add(obj);

        util.writeArrayData(jsonArray);
    }
}
