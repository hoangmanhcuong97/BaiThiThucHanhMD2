package Storage;

import model.ListPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileListPhone {
    public static void writeFileListPhone(List<ListPhone> managerListPhone) throws IOException {
        FileOutputStream fos = new FileOutputStream("CSV.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(managerListPhone);
        oos.close();
        fos.close();
    }

    public static List<ListPhone> readFileListPhone() throws IOException, ClassNotFoundException {
        List<ListPhone> readListPhone = new ArrayList<>();
        File file = new File("CVS.txt");
        if(file.length() > 0){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            readListPhone = (List<ListPhone>) ois.readObject();
            ois.close();
            fis.close();
        }
        return readListPhone;
    }
}
