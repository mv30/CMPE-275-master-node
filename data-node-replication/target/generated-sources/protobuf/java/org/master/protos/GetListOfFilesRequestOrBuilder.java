// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: master-comm.proto

package org.master.protos;

public interface GetListOfFilesRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:stream.GetListOfFilesRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Send empty string to request list of files from all nodes
   * </pre>
   *
   * <code>repeated string nodeips = 1;</code>
   * @return A list containing the nodeips.
   */
  java.util.List<java.lang.String>
      getNodeipsList();
  /**
   * <pre>
   * Send empty string to request list of files from all nodes
   * </pre>
   *
   * <code>repeated string nodeips = 1;</code>
   * @return The count of nodeips.
   */
  int getNodeipsCount();
  /**
   * <pre>
   * Send empty string to request list of files from all nodes
   * </pre>
   *
   * <code>repeated string nodeips = 1;</code>
   * @param index The index of the element to return.
   * @return The nodeips at the given index.
   */
  java.lang.String getNodeips(int index);
  /**
   * <pre>
   * Send empty string to request list of files from all nodes
   * </pre>
   *
   * <code>repeated string nodeips = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the nodeips at the given index.
   */
  com.google.protobuf.ByteString
      getNodeipsBytes(int index);
}
