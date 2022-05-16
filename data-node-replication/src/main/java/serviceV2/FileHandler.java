package serviceV2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import serviceV2.DataEntry;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    private final String filePath;

    private final JSONParser jsonParser;

    private final ObjectMapper objectMapper;

    public FileHandler(String filePath) {
        this.filePath = filePath;
        this.jsonParser = new JSONParser();
        this.objectMapper = new ObjectMapper();
        try {
            FileWriter fw = new FileWriter(this.filePath);
            fw.write("[]");
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DataEntry> getFileContent() throws Exception{
        FileReader fr = new FileReader(this.filePath);
        Object dataOb = jsonParser.parse(fr);
        fr.close();
        List<DataEntry> dataEntryList = objectMapper.convertValue(dataOb, new TypeReference<List<DataEntry>>() {});
        if(dataEntryList==null) {
            return new ArrayList<>();
        }
        return dataEntryList;
    }

    public void writeData( List<DataEntry> dataEntryList) throws Exception{
        String value = objectMapper.writeValueAsString(dataEntryList);
        FileWriter fw = new FileWriter(this.filePath);
        fw.write(value);
        fw.close();
    }

    public List<String> get( String key) throws Exception {
        List<DataEntry> dataEntryList = getFileContent();
        for(DataEntry dataEntry: dataEntryList) {
            if(dataEntry.getKey().equals(key)) {
                return dataEntry.getValues();
            }
        }
        return new ArrayList<>();
    }

    public DataEntry createOrUpdate( String key, List<String> values) throws Exception{
        List<DataEntry> dataEntryList = getFileContent();
        DataEntry dataEntryToUpdate = new DataEntry( key, values);
        if(get(key).isEmpty()) {
            dataEntryList.add(dataEntryToUpdate);
        } else {
            for( DataEntry dataEntry: dataEntryList) {
                if(dataEntry.getKey().equals(dataEntryToUpdate.getKey())) {
                    dataEntry.setValues(values);
                }
            }
        }
        writeData(dataEntryList);
        return dataEntryToUpdate;
    }

    public DataEntry remove( String key) throws Exception {
        DataEntry dataEntryRemoved = null;
        List<DataEntry> dataEntryList = getFileContent();
        List<DataEntry> dataEntryListToSave = new ArrayList<>();
        for(DataEntry dataEntry: dataEntryList) {
            if(dataEntry.getKey().equals(key)) {
                dataEntryRemoved = dataEntry;
                continue;
            }
            dataEntryListToSave.add(dataEntry);
        }
        writeData(dataEntryListToSave);
        return dataEntryRemoved;
    }

    public static void main(String[] args) throws Exception {
        /*
        * Testing
        * */
        FileHandler fileHandler = new FileHandler("../replicated-data");
        fileHandler.createOrUpdate("name", Arrays.asList("Mayank"));
        fileHandler.createOrUpdate("university", Arrays.asList("SJSU"));
        fileHandler.createOrUpdate("school", Arrays.asList("APS"));
        fileHandler.createOrUpdate("country", Arrays.asList("USA"));
        System.out.println(fileHandler.get("name"));
        System.out.println(fileHandler.get("university"));
        System.out.println(fileHandler.get("school"));
        fileHandler.remove("university");
        fileHandler.remove("school");
    }
}
