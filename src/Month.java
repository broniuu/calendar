import java.util.List;

/**
 * Month is public class that contains number of days within the month, and number of month
 *
 */

public class Month {
    private int numberOfDays;
    private int number;

    public String getName() {
        return name;
    }

    private String name;

    Month(int number, Year year){
        if(number <= 12) {
            findNumberOfDays(number, year);
            setNumber(number);
            nameTheMonth(number);
        }
    }

    /**
     * Sets number of days
     *
     * @param numberOfDays  number of days in month
     */

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    /**
     * Sets number of month
     *
     * @param number  number of month
     */

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Sets name of month
     *
     * @param name  name of month
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets number of days in year
     *
     */

    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * Gets number of month
     *
     */

    public int getNumber() {
        return number;
    }

    /**
     * It finds number of days in month.
     * If year is leap, February will get 29 days. If not, it will get 28 days
     *
     * @param number    number of month
     * @param year  object of Year class
     */

    public void findNumberOfDays(int number, Year year){
        //sprawdzamy ile dni w miesiącu
        switch (number){
            case 1,3,5,7,8,10,12: //31 dni
                setNumberOfDays(31);
                break;
            case 4,6,9,11: //30 dni
                setNumberOfDays(30);
                break;
            case 2: //28 lub 29 dni
                //sprawdzamy czy rok przestępny
                if(year.getLeap() == true){
                    setNumberOfDays(29);
                } else {
                    setNumberOfDays(28);
                }
                break;
        }
    }

    /**
     * assigns name for month using its number
     *
     * @param number    number of monht
     */

    public void nameTheMonth(int number){
        List<String> namesOfMonth = List.of("JANUARY", "FEBRUARY", "MARCH", "APRIL",
                "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
                "NOVEMBER", "DECEMBER");
        setName(namesOfMonth.get(number-1)); //odejmujemy 1 bo w tablicy nazwy miesięcy indexują się od 0
    }
}
