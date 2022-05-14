package service;

public class DataEntry {

    private String key;

    private String value;

    public DataEntry() {
        key = null;
        value = null;
    }

    public DataEntry( String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void setKey( String key) {
        this.key = key;
    }

    public void setValue( String value) {
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
