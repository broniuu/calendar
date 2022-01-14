import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogHandler {
    private static String logPath = "C:\\Users\\broni\\IdeaProjects\\Calendar\\Logs.txt";

    public static void write(String message) {
        try {
            FileWriter fileWriter = new FileWriter(logPath, true);
            fileWriter.write(message);
            fileWriter.write("\n");
            fileWriter.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  static void read(){
        try {
            FileReader fileReader = new FileReader(logPath);
            int data = fileReader.read();
            while(data != -1){
                System.out.print((char)data);
                data = fileReader.read();
            }
            fileReader.close();

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
