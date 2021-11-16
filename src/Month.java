public class Month {
    private int numberOfDays;
    private int number;
    private String name;

    Month(int number, Year year){
        setNumberOfDays(numberOfDays);
        setNumber(number);
        setName(name);
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
    public void chceckNumberOfDays(int number, Year year){
        boolean leap = year.getLeap();
        //sprawdzamy ile dni w miesiącu
        switch (number){
            case 1,3,5,7,8,10,12: //31 dni
                break;
            case 4,6,9,11: //30 dni
                break;
            case 2: //28 lub 29 dni
                break;
        }
    }
}
