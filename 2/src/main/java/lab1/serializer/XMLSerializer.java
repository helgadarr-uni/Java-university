package lab1.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XMLSerializer<T> implements Serializer<T> {
    @SneakyThrows
    @Override
    public void toFile(T entity, String filename) {
        XmlMapper mapper = new XmlMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), entity);
    }

    @SneakyThrows
    @Override
    public T fromFile(String filename) {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(new File(filename), new TypeReference<T>() {
        });
    }

    @SneakyThrows
    @Override
    public void listToFile(List<T> entities, String filename) {
        XmlMapper mapper = new XmlMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), entities);
    }

    @SneakyThrows
    @Override
    public List<T> listFromFile(String filename) {
        XmlMapper mapper = new XmlMapper();
        String readContent = new String(Files.readAllBytes(Paths.get(filename)));
        return mapper.readValue(new File(filename), new TypeReference<List<T>>() {
        });

    }
}
