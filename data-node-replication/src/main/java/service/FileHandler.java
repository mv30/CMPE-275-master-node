package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final String filePath;

    private final JSONParser jsonParser;

    private final ObjectMapper objectMapper;

    public FileHandler( String filePath) {
        this.filePath = filePath;
        this.jsonParser = new JSONParser();
        this.objectMapper = new ObjectMapper();
        new File(filePath).mkdirs();
        System.out.println(new File(String.format("%s/data.json",this.filePath)).getAbsoluteFile());
        try {
            FileWriter fw = new FileWriter(String.format("%s/data.json",this.filePath));
            fw.write("[]");
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DataEntry> getFileContent() throws Exception{
        FileReader fr = new FileReader(String.format("%s/data.json", this.filePath));
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
        FileWriter fw = new FileWriter(String.format("%s/data.json", this.filePath));
        fw.write(value);
        fw.close();
    }

    public String get( String key) throws Exception {
        List<DataEntry> dataEntryList = getFileContent();
        for(DataEntry dataEntry: dataEntryList) {
            if(dataEntry.getKey().equals(key)) {
                return dataEntry.getValue();
            }
        }
        return null;
    }

    public DataEntry createOrUpdate( String key, String value) throws Exception{
        List<DataEntry> dataEntryList = getFileContent();
        DataEntry dataEntryToUpdate = new DataEntry( key, value);
        if(get(key)==null) {
            dataEntryList.add(dataEntryToUpdate);
        } else {
            for( DataEntry dataEntry: dataEntryList) {
                if(dataEntry.getKey().equals(dataEntryToUpdate.getKey())) {
                    dataEntry.setValue(value);
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
        FileHandler fileHandler = new FileHandler("/Users/mayankverma/replicated-data");
        fileHandler.createOrUpdate("name", "Mayank");
        fileHandler.createOrUpdate("university", "SJSU");
        fileHandler.createOrUpdate("school", "APS");
        fileHandler.createOrUpdate("country", "USA");
        System.out.println(fileHandler.get("name"));
        System.out.println(fileHandler.get("university"));
        System.out.println(fileHandler.get("school"));
        fileHandler.remove("university");
        fileHandler.remove("school");
    }
}
