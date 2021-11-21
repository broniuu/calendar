public class Main {
    public static void main(String[] args){
        try {
            Data data = new Data(1, 0, 2021);
        } catch (MonthOffTheScopeException monthOffTheScopeExeption){
            System.out.println(monthOffTheScopeExeption.getMessage());
        }
    }
}
