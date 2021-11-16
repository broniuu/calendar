public class Year {
    private int number;
    private boolean leap;

    Year(int number){
        setNumber(number);
        this.checkIfLeap();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLeap(boolean leap) {
        this.leap = leap;
    }

    public boolean getLeap() {
        return leap;
    }

    //funkcja sprawdza czy rok jest przestępny
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
