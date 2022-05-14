import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    public void readData(String key) throws IOException, ParseException {
        ReadDataService readDataService = new ReadDataService();
        System.out.println(readDataService.readDataForKey(key));
    }
    public void writeDatea(String key, String value) throws IOException, ParseException {
        WriteDataService writeDataService = new WriteDataService();
        JSONObject emp = new JSONObject();
        emp.put(key, value);
        writeDataService.writeDataForKey(emp);
    }
    public void updateData(String key, String value) throws IOException, ParseException {
        UpdateDataService updateDataService = new UpdateDataService();
        updateDataService.updateDataForKey(key, value);
    }
    public void deleteData(String key) throws IOException, ParseException {
        DeleteDataService deleteDataService = new DeleteDataService();
        deleteDataService.deleteDataForKey(key);
    }
    // If you want to test the CRUD you can directly do so by running main.
    public static void main(String[] args) throws IOException, ParseException {
        DeleteDataService deleteDataService = new DeleteDataService();
        ReadDataService readDataService = new ReadDataService();
        WriteDataService writeDataService = new WriteDataService();
        UpdateDataService updateDataService = new UpdateDataService();

        while(true) {
            System.out.println("Choose which file operation you want to do ");
            Scanner myObj = new Scanner(System.in);
            int choice = Integer.parseInt(myObj.nextLine());
            switch (choice) {
                case 1: {
                    System.out.println("Enter the key which you want to read ");
                    String key = myObj.nextLine();
                    System.out.println(readDataService.readDataForKey(key));
                    break;
                }
                case 2: {
                    System.out.println("Enter the key which you want to write ");
                    String key = myObj.nextLine();
                    System.out.println("Enter the value which you want to write ");
                    String value = myObj.nextLine();
                    JSONObject emp = new JSONObject();
                    emp.put(key, value);
                    writeDataService.writeDataForKey(emp);
                    break;
                }
                case 3: {
                    System.out.println("Enter the key for which the value should be updated ");
                    String key = myObj.nextLine();
                    System.out.println("Enter the value which you want to update ");
                    String value = myObj.nextLine();
                    updateDataService.updateDataForKey(key, value);
                    break;
                }
                case 4: {
                    System.out.println("Delete the key which should be deleted ");
                    String key = myObj.nextLine();
                    deleteDataService.deleteDataForKey(key);
                    break;
                }
            }
        }
    }
}