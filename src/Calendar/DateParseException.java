package Calendar;

/**
 * This class represents exception given, when there is too many (or too low)
 * arguments after parsing date String input
 *
 * @see RuntimeException
 */

public class DateParseException extends RuntimeException{
    /**
     * Class constructor that uses constructor from RuntimeException
     *
     * @param exceptionInfo    text information about exception
     */
    DateParseException(String exceptionInfo){
        super(exceptionInfo);
    }
}
