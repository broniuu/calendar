public class Data {
    private int day;
    private Month month;
    private Year year;

    Data(int day, int monthNumber, int yearNumber) throws MonthException, DayException {
        setYear(new Year(yearNumber));
        if (monthNumber > 12 || monthNumber < 1) { //sprawdzam czy numer miesiąca mieści sie w zakresie
            throw new MonthException("Number of month is off the scope");
        }
        setMonth(new Month(monthNumber, year));
        if (day > month.getNumberOfDays() || day < 1) { //sprawdzam czy dzień mieści się w zakresie
            throw new DayException("Number of day is off the scope");
        }
        setDay(day);
    }

    Data(int day, Month month, Year year) {
        if(day <= month.getNumberOfDays() && day < 0) { //sprawdzam czy aktualny dzień mieści się w wyznaczonym przedziale
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

    @Override
    public String toString() {
        return  day + "." + month.getNumber() + '.' + year.getNumber();
    }
}
