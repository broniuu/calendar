public class Main {
    public static void main(String[] args){
        try {
            Data data = new Data(0, 12, 2021);
        }
        catch (MonthException monthException){
            System.out.println(monthException.getMessage());
        }
        catch (DayException dayException){
            System.out.println(dayException.getMessage());
        }
    }
}
