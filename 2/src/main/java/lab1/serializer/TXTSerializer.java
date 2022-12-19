package lab1.serializer;

import lab1.Car;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TXTSerializer<T extends TXTSerializable<T>> implements Serializer<T> {

    @Override
    public void toFile(T entity, String filename) throws IOException {
        try (FileWriter fos = new FileWriter(filename))
         {
             fos.write(entity.toStringSerialize());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SneakyThrows
    @Override
    public T fromFile(String filename) {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        return (T) new Car().fromStringSerialize(everything);
    }
    @SneakyThrows
    @Override
    public void listToFile(List<T> entities, String filename) {
        try (FileWriter fos = new FileWriter(filename)){
        StringBuilder sb = new StringBuilder();
        for (T car:entities){
            sb.append(car.toStringSerialize()).append(";");
        }
        fos.write(sb.toString());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @SneakyThrows
    @Override
    public List<T> listFromFile(String filename) {
        List<T> cars = new ArrayList<T>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();

            String sb1 = new String(sb);
            String[] objString = sb1.split(";");
            for (String item : objString) {
                cars.add((T) new Car().fromStringSerialize(item));
            }
        }
        return cars;
    }
}
