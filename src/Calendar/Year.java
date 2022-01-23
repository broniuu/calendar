package Calendar;

/**
 * Year is public class that contains number of years and its leap
 *
 */

public class Year {
    private int number;
    private boolean leap;


    /**
     * Class constructor, that set number and leap
     * @param number
     */

    Year(int number){
        setNumber(number);
        this.checkIfLeap();
    }

    /**
     * Sets number of year
     *
     * @param number    number of year
     */

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Sets leap of year
     *
     * @param leap    leap of year
     */

    public void setLeap(boolean leap) {
        this.leap = leap;
    }

    /**
     * Gets leap of year
     *
     * @return leap of year
     */

    public boolean getLeap() {
        return leap;
    }

    /**
     * Gets number of year
     *
     * @return number of year
     */

    public int getNumber() {
        return number;
    }

    /**
     * Check's if year is leap, and assign it to leap attribute of object
     */

    public void checkIfLeap() {
        //lata przestępne to takie, których numeracja:
        //-jest podzielna przez 4 i niepodzielna przez 100
        //-lub jest podzielna przez 400
        if((this.number % 4 == 0 && this.number % 100 != 0)
        || this.number % 400 == 0){
            setLeap(true);
        }else {
            setLeap(false);
        }
    }
}
