import java.util.List;

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

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getNumber() {
        return number;
    }

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

    public void nameTheMonth(int number){
        List<String> namesOfMonth = List.of("JANUARY", "FEBRUARY", "MARCH", "APRIL",
                "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
                "NOVEMBER", "DECEMBER");
        setName(namesOfMonth.get(number-1)); //odejmujemy 1 bo w tablicy nazwy miesięcy indexują się od 0
    }
}
