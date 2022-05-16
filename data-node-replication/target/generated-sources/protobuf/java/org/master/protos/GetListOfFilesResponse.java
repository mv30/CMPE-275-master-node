// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: master-comm.proto

package org.master.protos;

/**
 * Protobuf type {@code stream.GetListOfFilesResponse}
 */
public final class GetListOfFilesResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:stream.GetListOfFilesResponse)
    GetListOfFilesResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetListOfFilesResponse.newBuilder() to construct.
  private GetListOfFilesResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetListOfFilesResponse() {
    filenames_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetListOfFilesResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetListOfFilesResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              filenames_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            filenames_.add(s);
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        filenames_ = filenames_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.master.protos.MasterComm.internal_static_stream_GetListOfFilesResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.master.protos.MasterComm.internal_static_stream_GetListOfFilesResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.master.protos.GetListOfFilesResponse.class, org.master.protos.GetListOfFilesResponse.Builder.class);
  }

  public static final int FILENAMES_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList filenames_;
  /**
   * <code>repeated string filenames = 1;</code>
   * @return A list containing the filenames.
   */
  public com.google.protobuf.ProtocolStringList
      getFilenamesList() {
    return filenames_;
  }
  /**
   * <code>repeated string filenames = 1;</code>
   * @return The count of filenames.
   */
  public int getFilenamesCount() {
    return filenames_.size();
  }
  /**
   * <code>repeated string filenames = 1;</code>
   * @param index The index of the element to return.
   * @return The filenames at the given index.
   */
  public java.lang.String getFilenames(int index) {
    return filenames_.get(index);
  }
  /**
   * <code>repeated string filenames = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the filenames at the given index.
   */
  public com.google.protobuf.ByteString
      getFilenamesBytes(int index) {
    return filenames_.getByteString(index);
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
    for (int i = 0; i < filenames_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, filenames_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < filenames_.size(); i++) {
        dataSize += computeStringSizeNoTag(filenames_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getFilenamesList().size();
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
    if (!(obj instanceof org.master.protos.GetListOfFilesResponse)) {
      return super.equals(obj);
    }
    org.master.protos.GetListOfFilesResponse other = (org.master.protos.GetListOfFilesResponse) obj;

    if (!getFilenamesList()
        .equals(other.getFilenamesList())) return false;
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
    if (getFilenamesCount() > 0) {
      hash = (37 * hash) + FILENAMES_FIELD_NUMBER;
      hash = (53 * hash) + getFilenamesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.master.protos.GetListOfFilesResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.master.protos.GetListOfFilesResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.master.protos.GetListOfFilesResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.master.protos.GetListOfFilesResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.master.protos.GetListOfFilesResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.master.protos.GetListOfFilesResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.master.protos.GetListOfFilesResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.master.protos.GetListOfFilesResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.master.protos.GetListOfFilesResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.master.protos.GetListOfFilesResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.master.protos.GetListOfFilesResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.master.protos.GetListOfFilesResponse parseFrom(
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
  public static Builder newBuilder(org.master.protos.GetListOfFilesResponse prototype) {
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
   * Protobuf type {@code stream.GetListOfFilesResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:stream.GetListOfFilesResponse)
      org.master.protos.GetListOfFilesResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.master.protos.MasterComm.internal_static_stream_GetListOfFilesResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.master.protos.MasterComm.internal_static_stream_GetListOfFilesResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.master.protos.GetListOfFilesResponse.class, org.master.protos.GetListOfFilesResponse.Builder.class);
    }

    // Construct using org.master.protos.GetListOfFilesResponse.newBuilder()
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
      filenames_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.master.protos.MasterComm.internal_static_stream_GetListOfFilesResponse_descriptor;
    }

    @java.lang.Override
    public org.master.protos.GetListOfFilesResponse getDefaultInstanceForType() {
      return org.master.protos.GetListOfFilesResponse.getDefaultInstance();
    }

    @java.lang.Override
    public org.master.protos.GetListOfFilesResponse build() {
      org.master.protos.GetListOfFilesResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.master.protos.GetListOfFilesResponse buildPartial() {
      org.master.protos.GetListOfFilesResponse result = new org.master.protos.GetListOfFilesResponse(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        filenames_ = filenames_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.filenames_ = filenames_;
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
      if (other instanceof org.master.protos.GetListOfFilesResponse) {
        return mergeFrom((org.master.protos.GetListOfFilesResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.master.protos.GetListOfFilesResponse other) {
      if (other == org.master.protos.GetListOfFilesResponse.getDefaultInstance()) return this;
      if (!other.filenames_.isEmpty()) {
        if (filenames_.isEmpty()) {
          filenames_ = other.filenames_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureFilenamesIsMutable();
          filenames_.addAll(other.filenames_);
        }
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
      org.master.protos.GetListOfFilesResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.master.protos.GetListOfFilesResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList filenames_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureFilenamesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        filenames_ = new com.google.protobuf.LazyStringArrayList(filenames_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string filenames = 1;</code>
     * @return A list containing the filenames.
     */
    public com.google.protobuf.ProtocolStringList
        getFilenamesList() {
      return filenames_.getUnmodifiableView();
    }
    /**
     * <code>repeated string filenames = 1;</code>
     * @return The count of filenames.
     */
    public int getFilenamesCount() {
      return filenames_.size();
    }
    /**
     * <code>repeated string filenames = 1;</code>
     * @param index The index of the element to return.
     * @return The filenames at the given index.
     */
    public java.lang.String getFilenames(int index) {
      return filenames_.get(index);
    }
    /**
     * <code>repeated string filenames = 1;</code>
     * @param index The index of the value to return.
     * @return The bytes of the filenames at the given index.
     */
    public com.google.protobuf.ByteString
        getFilenamesBytes(int index) {
      return filenames_.getByteString(index);
    }
    /**
     * <code>repeated string filenames = 1;</code>
     * @param index The index to set the value at.
     * @param value The filenames to set.
     * @return This builder for chaining.
     */
    public Builder setFilenames(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureFilenamesIsMutable();
      filenames_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string filenames = 1;</code>
     * @param value The filenames to add.
     * @return This builder for chaining.
     */
    public Builder addFilenames(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureFilenamesIsMutable();
      filenames_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string filenames = 1;</code>
     * @param values The filenames to add.
     * @return This builder for chaining.
     */
    public Builder addAllFilenames(
        java.lang.Iterable<java.lang.String> values) {
      ensureFilenamesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, filenames_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string filenames = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFilenames() {
      filenames_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string filenames = 1;</code>
     * @param value The bytes of the filenames to add.
     * @return This builder for chaining.
     */
    public Builder addFilenamesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureFilenamesIsMutable();
      filenames_.add(value);
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


    // @@protoc_insertion_point(builder_scope:stream.GetListOfFilesResponse)
  }

  // @@protoc_insertion_point(class_scope:stream.GetListOfFilesResponse)
  private static final org.master.protos.GetListOfFilesResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.master.protos.GetListOfFilesResponse();
  }

  public static org.master.protos.GetListOfFilesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetListOfFilesResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetListOfFilesResponse>() {
    @java.lang.Override
    public GetListOfFilesResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetListOfFilesResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetListOfFilesResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetListOfFilesResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.master.protos.GetListOfFilesResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

