package io_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile<E> {
    public List<E> readFile(String path) {
        List<E> lists = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fileInput = new FileInputStream(file);
            if (fileInput.available() > 0) {
                ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                lists = (List<E>) objectInput.readObject();
                objectInput.close();
            }
            return lists;
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return lists;
    }

    public void writeToFile(List<E> lists, String path) {
        try (FileOutputStream fileOutput = new FileOutputStream(path)) {
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(lists);
            objectOutput.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
