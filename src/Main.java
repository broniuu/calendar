import java.util.*;
import Calendar.*;

public class Main extends RuntimeException {

    public static void main(String[] args) {
        MyDate myDate = new MyDate("1", "2", "2023");
        System.out.println(myDate.toString());
        MyDate myDate2 = MyDate.parse("01-02-2001");
        System.out.println(myDate2.toString());
    }
}
