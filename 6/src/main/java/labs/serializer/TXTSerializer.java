package labs.serializer;

import labs.Car;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TXTSerializer<T extends TXTSerializable<T>> implements Serializer<T> {

    //    T object;
//    public TXTSerializer(T typeObject){
//        object=typeObject;
//    }
    @Override
    public void toFile(T entity, String filename) throws IOException {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(entity.toStringSerialize());
        }
        catch (IOException e){
            e.printStackTrace();
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

//        try (
//            BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            return (T)object.fromStringSerialize(br.readLine());
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }


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
