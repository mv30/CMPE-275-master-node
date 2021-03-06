// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: master-comm.proto

package org.master.protos;

public final class MasterCommDataNode {
  private MasterCommDataNode() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_NodeIpsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_NodeIpsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_NodeIpsReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_NodeIpsReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_ReplicationDetailsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_ReplicationDetailsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_ReplicationDetailsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_ReplicationDetailsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_NewNodeUpdateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_NewNodeUpdateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_NewNodeUpdateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_NewNodeUpdateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_StatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_StatusResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_GetNodeForDownloadRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_GetNodeForDownloadRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_GetNodeForDownloadResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_GetNodeForDownloadResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_GetNodeForUploadRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_GetNodeForUploadRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_GetNodeForUploadResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_GetNodeForUploadResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_NodeDownUpdateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_NodeDownUpdateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_NodeDownUpdateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_NodeDownUpdateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_GetListOfFilesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_GetListOfFilesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_GetListOfFilesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_GetListOfFilesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_GetListOfNodesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_GetListOfNodesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_GetListOfNodesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_GetListOfNodesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stream_DataPayload_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stream_DataPayload_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021master-comm.proto\022\006stream\"\"\n\016NodeIpsRe" +
      "quest\022\020\n\010filename\030\001 \001(\t\"\037\n\014NodeIpsReply\022" +
      "\017\n\007nodeips\030\001 \003(\t\">\n\031ReplicationDetailsRe" +
      "quest\022\020\n\010filename\030\001 \001(\t\022\017\n\007nodeips\030\002 \003(\t" +
      "\"<\n\032ReplicationDetailsResponse\022\036\n\006status" +
      "\030\001 \001(\0162\016.stream.Status\")\n\024NewNodeUpdateR" +
      "equest\022\021\n\tnewnodeip\030\001 \001(\t\"\'\n\025NewNodeUpda" +
      "teResponse\022\016\n\006status\030\001 \001(\t\"0\n\016StatusResp" +
      "onse\022\036\n\006status\030\001 \001(\0162\016.stream.Status\"-\n\031" +
      "GetNodeForDownloadRequest\022\020\n\010filename\030\001 " +
      "\001(\t\",\n\032GetNodeForDownloadResponse\022\016\n\006nod" +
      "eip\030\001 \001(\t\"=\n\027GetNodeForUploadRequest\022\020\n\010" +
      "filename\030\001 \001(\t\022\020\n\010filesize\030\002 \001(\003\"*\n\030GetN" +
      "odeForUploadResponse\022\016\n\006nodeip\030\001 \001(\t\"\'\n\025" +
      "NodeDownUpdateRequest\022\016\n\006nodeip\030\001 \001(\t\"(\n" +
      "\026NodeDownUpdateResponse\022\016\n\006status\030\001 \001(\t\"" +
      "(\n\025GetListOfFilesRequest\022\017\n\007nodeips\030\001 \003(" +
      "\t\"+\n\026GetListOfFilesResponse\022\021\n\tfilenames" +
      "\030\001 \003(\t\"\027\n\025GetListOfNodesRequest\")\n\026GetLi" +
      "stOfNodesResponse\022\017\n\007nodeips\030\001 \003(\t\"*\n\013Da" +
      "taPayload\022\013\n\003key\030\001 \001(\t\022\016\n\006values\030\002 \003(\t*\"" +
      "\n\006Status\022\013\n\007SUCCESS\020\000\022\013\n\007FAILURE\020\0012\240\007\n\013R" +
      "eplication\0228\n\nhealthPoll\022\023.stream.DataPa" +
      "yload\032\023.stream.DataPayload\"\000\0225\n\007setData\022" +
      "\023.stream.DataPayload\032\023.stream.DataPayloa" +
      "d\"\000\0225\n\007getData\022\023.stream.DataPayload\032\023.st" +
      "ream.DataPayload\"\000\0228\n\nremoveData\022\023.strea" +
      "m.DataPayload\032\023.stream.DataPayload\"\000\022N\n\r" +
      "NewNodeUpdate\022\034.stream.NewNodeUpdateRequ" +
      "est\032\035.stream.NewNodeUpdateResponse\"\000\022]\n\022" +
      "GetNodeForDownload\022!.stream.GetNodeForDo" +
      "wnloadRequest\032\".stream.GetNodeForDownloa" +
      "dResponse\"\000\022W\n\020GetNodeForUpload\022\037.stream" +
      ".GetNodeForUploadRequest\032 .stream.GetNod" +
      "eForUploadResponse\"\000\022Q\n\016NodeDownUpdate\022\035" +
      ".stream.NodeDownUpdateRequest\032\036.stream.N" +
      "odeDownUpdateResponse\"\000\022Q\n\016GetListOfNode" +
      "s\022\035.stream.GetListOfNodesRequest\032\036.strea" +
      "m.GetListOfNodesResponse\"\000\022J\n\030GetNodeIps" +
      "ForReplication\022\026.stream.NodeIpsRequest\032\024" +
      ".stream.NodeIpsReply\"\000\022b\n\027UpdateReplicat" +
      "ionStatus\022!.stream.ReplicationDetailsReq" +
      "uest\032\".stream.ReplicationDetailsResponse" +
      "\"\000\022Q\n\016GetListOfFiles\022\035.stream.GetListOfF" +
      "ilesRequest\032\036.stream.GetListOfFilesRespo" +
      "nse\"\000B/\n\021org.master.protosB\022MasterCommDa" +
      "taNodeP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_stream_NodeIpsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_stream_NodeIpsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_NodeIpsRequest_descriptor,
        new java.lang.String[] { "Filename", });
    internal_static_stream_NodeIpsReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_stream_NodeIpsReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_NodeIpsReply_descriptor,
        new java.lang.String[] { "Nodeips", });
    internal_static_stream_ReplicationDetailsRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_stream_ReplicationDetailsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_ReplicationDetailsRequest_descriptor,
        new java.lang.String[] { "Filename", "Nodeips", });
    internal_static_stream_ReplicationDetailsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_stream_ReplicationDetailsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_ReplicationDetailsResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_stream_NewNodeUpdateRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_stream_NewNodeUpdateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_NewNodeUpdateRequest_descriptor,
        new java.lang.String[] { "Newnodeip", });
    internal_static_stream_NewNodeUpdateResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_stream_NewNodeUpdateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_NewNodeUpdateResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_stream_StatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_stream_StatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_StatusResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_stream_GetNodeForDownloadRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_stream_GetNodeForDownloadRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_GetNodeForDownloadRequest_descriptor,
        new java.lang.String[] { "Filename", });
    internal_static_stream_GetNodeForDownloadResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_stream_GetNodeForDownloadResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_GetNodeForDownloadResponse_descriptor,
        new java.lang.String[] { "Nodeip", });
    internal_static_stream_GetNodeForUploadRequest_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_stream_GetNodeForUploadRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_GetNodeForUploadRequest_descriptor,
        new java.lang.String[] { "Filename", "Filesize", });
    internal_static_stream_GetNodeForUploadResponse_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_stream_GetNodeForUploadResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_GetNodeForUploadResponse_descriptor,
        new java.lang.String[] { "Nodeip", });
    internal_static_stream_NodeDownUpdateRequest_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_stream_NodeDownUpdateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_NodeDownUpdateRequest_descriptor,
        new java.lang.String[] { "Nodeip", });
    internal_static_stream_NodeDownUpdateResponse_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_stream_NodeDownUpdateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_NodeDownUpdateResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_stream_GetListOfFilesRequest_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_stream_GetListOfFilesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_GetListOfFilesRequest_descriptor,
        new java.lang.String[] { "Nodeips", });
    internal_static_stream_GetListOfFilesResponse_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_stream_GetListOfFilesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_GetListOfFilesResponse_descriptor,
        new java.lang.String[] { "Filenames", });
    internal_static_stream_GetListOfNodesRequest_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_stream_GetListOfNodesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_GetListOfNodesRequest_descriptor,
        new java.lang.String[] { });
    internal_static_stream_GetListOfNodesResponse_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_stream_GetListOfNodesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_GetListOfNodesResponse_descriptor,
        new java.lang.String[] { "Nodeips", });
    internal_static_stream_DataPayload_descriptor =
      getDescriptor().getMessageTypes().get(17);
    internal_static_stream_DataPayload_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stream_DataPayload_descriptor,
        new java.lang.String[] { "Key", "Values", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
