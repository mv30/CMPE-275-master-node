//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class DeleteDataFromJsonFile {
//    public static void main(String[] args) throws IOException, ParseException {
//        JSONParser jsonParser = new JSONParser();
//        FileReader reader = new FileReader("/Users/aravindthonupunuri/Downloads/275final/CMPE-275-master-node/data_node/jsonfiles/employee.json");
//        Object obj = jsonParser.parse(reader);
//        JSONObject empsjsonobj = (JSONObject) obj;
//
//        JSONArray jsonArray = (JSONArray)empsjsonobj.get("address");
//        jsonArray.remove(jsonArray);
//
//        FileWriter file = new FileWriter("emps.json");
//        try {
//            file.write(prettyJsonString);
//            System.out.println("Successfully wrote JSON object to file.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } finally {
//            file.flush();
//            file.close();
//        }
//    }
//}
