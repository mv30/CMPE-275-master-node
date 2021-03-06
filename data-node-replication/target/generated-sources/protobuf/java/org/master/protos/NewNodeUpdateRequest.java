// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: master-comm.proto

package org.master.protos;

/**
 * <pre>
 * The request message containing the IP address of the new Node that joined the network
 * </pre>
 *
 * Protobuf type {@code stream.NewNodeUpdateRequest}
 */
public final class NewNodeUpdateRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:stream.NewNodeUpdateRequest)
    NewNodeUpdateRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NewNodeUpdateRequest.newBuilder() to construct.
  private NewNodeUpdateRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NewNodeUpdateRequest() {
    newnodeip_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new NewNodeUpdateRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NewNodeUpdateRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            newnodeip_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.master.protos.MasterCommDataNode.internal_static_stream_NewNodeUpdateRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.master.protos.MasterCommDataNode.internal_static_stream_NewNodeUpdateRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.master.protos.NewNodeUpdateRequest.class, org.master.protos.NewNodeUpdateRequest.Builder.class);
  }

  public static final int NEWNODEIP_FIELD_NUMBER = 1;
  private volatile java.lang.Object newnodeip_;
  /**
   * <code>string newnodeip = 1;</code>
   * @return The newnodeip.
   */
  @java.lang.Override
  public java.lang.String getNewnodeip() {
    java.lang.Object ref = newnodeip_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      newnodeip_ = s;
      return s;
    }
  }
  /**
   * <code>string newnodeip = 1;</code>
   * @return The bytes for newnodeip.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNewnodeipBytes() {
    java.lang.Object ref = newnodeip_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      newnodeip_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(newnodeip_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, newnodeip_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(newnodeip_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, newnodeip_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.master.protos.NewNodeUpdateRequest)) {
      return super.equals(obj);
    }
    org.master.protos.NewNodeUpdateRequest other = (org.master.protos.NewNodeUpdateRequest) obj;

    if (!getNewnodeip()
        .equals(other.getNewnodeip())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NEWNODEIP_FIELD_NUMBER;
    hash = (53 * hash) + getNewnodeip().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.master.protos.NewNodeUpdateRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.master.protos.NewNodeUpdateRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.master.protos.NewNodeUpdateRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.master.protos.NewNodeUpdateRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.master.protos.NewNodeUpdateRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.master.protos.NewNodeUpdateRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.master.protos.NewNodeUpdateRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.master.protos.NewNodeUpdateRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.master.protos.NewNodeUpdateRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.master.protos.NewNodeUpdateRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.master.protos.NewNodeUpdateRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.master.protos.NewNodeUpdateRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.master.protos.NewNodeUpdateRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The request message containing the IP address of the new Node that joined the network
   * </pre>
   *
   * Protobuf type {@code stream.NewNodeUpdateRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:stream.NewNodeUpdateRequest)
      org.master.protos.NewNodeUpdateRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.master.protos.MasterCommDataNode.internal_static_stream_NewNodeUpdateRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.master.protos.MasterCommDataNode.internal_static_stream_NewNodeUpdateRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.master.protos.NewNodeUpdateRequest.class, org.master.protos.NewNodeUpdateRequest.Builder.class);
    }

    // Construct using org.master.protos.NewNodeUpdateRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      newnodeip_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.master.protos.MasterCommDataNode.internal_static_stream_NewNodeUpdateRequest_descriptor;
    }

    @java.lang.Override
    public org.master.protos.NewNodeUpdateRequest getDefaultInstanceForType() {
      return org.master.protos.NewNodeUpdateRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.master.protos.NewNodeUpdateRequest build() {
      org.master.protos.NewNodeUpdateRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.master.protos.NewNodeUpdateRequest buildPartial() {
      org.master.protos.NewNodeUpdateRequest result = new org.master.protos.NewNodeUpdateRequest(this);
      result.newnodeip_ = newnodeip_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.master.protos.NewNodeUpdateRequest) {
        return mergeFrom((org.master.protos.NewNodeUpdateRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.master.protos.NewNodeUpdateRequest other) {
      if (other == org.master.protos.NewNodeUpdateRequest.getDefaultInstance()) return this;
      if (!other.getNewnodeip().isEmpty()) {
        newnodeip_ = other.newnodeip_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.master.protos.NewNodeUpdateRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.master.protos.NewNodeUpdateRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object newnodeip_ = "";
    /**
     * <code>string newnodeip = 1;</code>
     * @return The newnodeip.
     */
    public java.lang.String getNewnodeip() {
      java.lang.Object ref = newnodeip_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        newnodeip_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string newnodeip = 1;</code>
     * @return The bytes for newnodeip.
     */
    public com.google.protobuf.ByteString
        getNewnodeipBytes() {
      java.lang.Object ref = newnodeip_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        newnodeip_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string newnodeip = 1;</code>
     * @param value The newnodeip to set.
     * @return This builder for chaining.
     */
    public Builder setNewnodeip(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      newnodeip_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string newnodeip = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNewnodeip() {
      
      newnodeip_ = getDefaultInstance().getNewnodeip();
      onChanged();
      return this;
    }
    /**
     * <code>string newnodeip = 1;</code>
     * @param value The bytes for newnodeip to set.
     * @return This builder for chaining.
     */
    public Builder setNewnodeipBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      newnodeip_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:stream.NewNodeUpdateRequest)
  }

  // @@protoc_insertion_point(class_scope:stream.NewNodeUpdateRequest)
  private static final org.master.protos.NewNodeUpdateRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.master.protos.NewNodeUpdateRequest();
  }

  public static org.master.protos.NewNodeUpdateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NewNodeUpdateRequest>
      PARSER = new com.google.protobuf.AbstractParser<NewNodeUpdateRequest>() {
    @java.lang.Override
    public NewNodeUpdateRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NewNodeUpdateRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NewNodeUpdateRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NewNodeUpdateRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.master.protos.NewNodeUpdateRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

