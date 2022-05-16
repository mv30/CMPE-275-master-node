package entry;

import lombok.Getter;
import lombok.Setter;
import service.MasterCommDataNodeClient;

@Getter
@Setter
public class IpDetailsEntry {

    private final Integer portNo;

    private final String hostName;

    private final String keyValueFilePath;

    private final String activeNodesFilePath;

    private final MasterCommDataNodeClient masterCommDataNodeClient;

    public IpDetailsEntry( String hostName, Integer portNo, String keyValueFilePath, String activeNodesFilePath) {
        this.hostName = hostName;
        this.portNo = portNo;
        this.keyValueFilePath = keyValueFilePath;
        this.activeNodesFilePath = activeNodesFilePath;
        this.masterCommDataNodeClient = new MasterCommDataNodeClient( hostName, portNo);
    }
}
