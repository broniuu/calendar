public class Data {
    private int day;
    private Month month;
    private Year year;

    Data(int day, int month, int year){

    }
    Data(int day, Month month, Year year) {
        if(day <= month.getNumberOfDays()) { //sprawdzam czy aktualny dzień mieści się w wyznaczonym przedziale
            setDay(day);
            setMonth(month);
            setYear(year);
        }
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setYear(Year year) {
        this.year = year;
    }

}
