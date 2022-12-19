package lab1.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import java.io.File;
import java.util.List;

public class JSONSerializer<T> implements Serializer<T>{
    @SneakyThrows
    @Override
    public void toFile(T entity, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), entity);
    }

    @SneakyThrows
    @Override
    public T fromFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filename), new TypeReference<T>() {});
    }

    @SneakyThrows
    @Override
    public void listToFile(List<T> entities, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename),entities);
    }

    @SneakyThrows
    @Override
    public List<T> listFromFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filename), new TypeReference<List<T>>(){});
    }

}
