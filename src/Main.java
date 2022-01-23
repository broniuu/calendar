import java.util.*;
import Calendar.*;
/**
 * This class is for tests
 *
 * @author  Filip Broniek
 */

public class Main extends RuntimeException {

    /**
     * this is method for tests of features in Calendar
     * @param args  array of arguments for working
     */
    public static void main(String[] args) {
        MyDate myDate = new MyDate("1", "2", "2023");
        System.out.println(myDate.toString());
        MyDate myDate2 = MyDate.parse("01-02-2001");
        System.out.println(myDate2.toString());
    }
}
