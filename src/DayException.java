/**
 * This class represents exception given, when user enters wrong day number
 *
 * @see RuntimeException
 */

public class DayException extends RuntimeException{
    /**
     * Class constructor that uses constructor from RuntimeException
     *
     * @param exceptionInfo    text information about exception
     */
    DayException(String exceptionInfo){
        super(exceptionInfo);
    }
}