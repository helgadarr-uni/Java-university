package lab1.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lab1.Car;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class XMLSerializer<T> implements Serializer<T>{
    @SneakyThrows
    @Override
    public void toFile(T entity, String filename) {
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File(filename), entity);
    }

    @SneakyThrows
    @Override
    public T fromFile(String filename) {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(new File(filename), new TypeReference<T>() {});
    }

    @SneakyThrows
    @Override
    public void listToFile(List<T> entities, String filename) {
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File(filename),entities);
    }

    @SneakyThrows
    @Override
    public List<T> listFromFile(String filename) {
        XmlMapper mapper = new XmlMapper();
//        return mapper.readValue(new File(filename), new TypeReference<List<T>>());
        return null;
        }
}
