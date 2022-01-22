import java.util.Objects;

/**
 * This class contains date, and methods that manipulates on it
 *
 */


public class MyDate implements Comparable<MyDate> {
    private int day;
    private Month month;
    private Year year;
    private String nameOfDay;

    /**
     * Class constructor that uses only numbers
     *
     * @param day   number of day
     * @param monthNumber   number of month
     * @param yearNumber   number of year
     */
    MyDate(int day, int monthNumber, int yearNumber) throws MonthException, DayException {
        setYear(new Year(yearNumber));
        if (monthNumber > 12 || monthNumber < 1) { //sprawdzam czy numer miesiąca mieści sie w zakresie
            MonthException monthException = new MonthException("Number of month is off the scope");
            LogHandler.write(monthException.getMessage());
            throw monthException;
        }
        setMonth(new Month(monthNumber, year));
        if (day > month.getNumberOfDays() || day < 1) { //sprawdzam czy dzień mieści się w zakresie
            DayException dayException = new DayException("Number of day is off the scope");
            LogHandler.write(dayException.getMessage());
            throw dayException;
        }
        setDay(day);
    }


    /**
     * Class constructor that operates on objects
     *
     * @param day   number of day
     * @param month month with all its attributes
     * @param year year with all its attributes
     */

    MyDate(int day, Month month, Year year) {
        if(day <= month.getNumberOfDays() && day < 0) { //sprawdzam czy aktualny dzień mieści się w wyznaczonym przedziale
            setDay(day);
            setMonth(month);
            setYear(year);
        }
    }

    /**
     * Sets day
     *
     * @param day number of day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Sets month
     *
     * @param month month with all its attributes
     */
    public void setMonth(Month month) {
        this.month = month;
    }


    /**
     * Sets year
     *
     * @param year year with all its attributes
     */
    public void setYear(Year year) {
        this.year = year;
    }


    /**
     * Convert date to String
     *
     */
    @Override
    public String toString() {
        return  day + "." + month.getNumber() + '.' + year.getNumber();
    }

    /**
     * Moves date one week forward
     */
    public void addWeek() {
        int day = this.day + 7;
        int monthNumber = this.month.getNumber();
        int numberOfDays = this.month.getNumberOfDays();
        int yearNumber = this.year.getNumber();
        if (day > numberOfDays) {
            //this.day = this.day - month.getNumberOfDays();
            day = day - numberOfDays;
            //this.month = new Month(this.month.getNumber()+1, this.year);
            monthNumber = this.month.getNumber() + 1;
        }
        if (monthNumber > 12) {
            //this.year = new Year(year.getNumber() + 1);
            yearNumber = yearNumber + 1;
            //this.month = new Month(1,year);
            monthNumber = 1;
        }
        this.day = day;
        this.year = new Year(yearNumber);
        this.month = new Month(monthNumber, this.year );

    }

    /**
     * assigns a name of week, using current date and referential date
     * referential is constant, and its have day
     * Method can search date after referential date (2.1.2022) only
     * Ability to search date before it will be added in next update
     */
    public void setDayName(){
        final String[] namesOfWeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        MyDate referentialDate = new MyDate(2,1,2022); // niedziela
        while(referentialDate.compareTo(this) < 0 ){
            referentialDate.addWeek();
        }
        int daysToMove = referentialDate.day - this.day;
        if(daysToMove < 0){
            int previousMonthDays = this.month.getNumberOfDays() - this.day;
            daysToMove = referentialDate.day + previousMonthDays;
        }
        int daysMaXIndex = namesOfWeekDays.length - 1;
        int rightIndex = daysMaXIndex - daysToMove;

        this.nameOfDay = namesOfWeekDays[rightIndex];
    }

    /**
     * Assigns a name of week, using modulo operation
     * Method create unchangeable array of days from year beginning, to beginning of next months
     * It's more optimized version of setDayName method
     */
    public void setDayNameModulo(){
        final String[] namesOfWeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        final int daysFromYearBeginning[] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int monthNumber = this.month.getNumber();
        int yearNumber = this.year.getNumber();

        int dayOfYear = this.day + daysFromYearBeginning[monthNumber-1];
        if ((monthNumber > 2) && year.getLeap() == true){
            dayOfYear++;
        }
        int yy = (yearNumber - 1) % 100;
        int c = (yearNumber - 1) - yy;
        int g = yy + (yy / 4);
        int numberOfDay = (((((c / 100) % 4) * 5) + g) % 7);
        numberOfDay += dayOfYear - 1;
        numberOfDay %= 7;

        this.nameOfDay = namesOfWeekDays[numberOfDay];
    }

    /**
     * compares dates
     *
     * @param date
     * @return positive, negative, or zero number
     * @see Comparable
     */

    @Override
    public int compareTo(MyDate date) {
        int yearResult = this.year.getNumber() - date.year.getNumber();
        if (yearResult != 0) {
            return yearResult;
        }
        int MonthResult = this.month.getNumber() - date.month.getNumber();
        if (MonthResult != 0) {
            return MonthResult;
        }
        int DayResult = this.day - date.day;
        return DayResult;
    }

    /**
     * @see Comparable
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }


    /**
     * Convert date to string.
     * We can specify, what format of date we want.
     *
     * @param arg   name of format
     *              - "day_name" [name of day],[number of day] [name of month] [number of year]
     *              - "no_day_name" [number of day] [number of month] [number of year]
     *              - "roman_month" [number of day] [roman number of month] [number of year]
     *              - "shortcut_month" [number of day]-[shortcut number of day]-[number of year]
     *              - other string [number of day].[name of month].[number of year]
     * @return date as text
     */
    public String toString(String arg) {
        if(arg.equals("day_name")){
            return this.nameOfDay + ", " + this.day + " " + month.getName() + ' ' + year.getNumber();
        }
        if(arg.equals("no_day_name")){
            return this.day + " " + month.getName() + ' ' + year.getNumber();
        }
        if(arg.equals("roman_month")){
            String romanNumbers[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};
            int index = month.getNumber() - 1;
            return this.day + " " + romanNumbers[index] + ' ' + year.getNumber();
        }
        if(arg.equals("shortcut_month")){
            String shortcutMonthName = month.getName().substring(0,3);
            return this.day + "-" + shortcutMonthName + '-' + year.getNumber();
        }
        return  day + "." + month.getName() + '.' + year.getNumber();
    }
}
