package lab1.serializer;

import lab1.Car;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

public interface Serializer<T> {
    void toFile(T entity, String filename) throws IOException;
    T fromFile(String filename);
    void listToFile(List<T> entities, String filename);
    List<T> listFromFile(String filename);
}
