package entry;

import service.DataNodeClient;

public class IpDetailsEntry {

    private final Integer portNo;

    private final String hostName;

    private final String filePath;

    private final DataNodeClient dataNodeClient;

    public IpDetailsEntry( String hostName, Integer portNo, String filePath) {
        this.hostName = hostName;
        this.portNo = portNo;
        this.filePath = filePath;
        this.dataNodeClient = new DataNodeClient( hostName, portNo);
    }

    public String getHostName() {
        return hostName;
    }

    public Integer getPortNo() {
        return this.portNo;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public DataNodeClient getDataNodeClient() {
        return this.dataNodeClient;
    }
}
