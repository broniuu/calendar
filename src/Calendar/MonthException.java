package Calendar;

/**
 * This class represents exception given, when user enters wrong month number
 *
 * @author  Filip Broniek
 */

public class MonthException extends RuntimeException{
    /**
     * Class constructor that uses constructor from RuntimeException
     *
     * @param exceptionInfo    text information about exception
     */
    MonthException(String exceptionInfo){
        super(exceptionInfo);
    }
}
