package labs.serializer;

public interface TXTSerializable<T> {
    String toStringSerialize();
    T fromStringSerialize(String content);
}
