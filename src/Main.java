public class Main extends RuntimeException {

    public static void main(String[] args) {
        Date data = new Date(8, 5, 2023);
        Date data2 = new Date(24, 12, 1);

        //pierwszy pomiar (metoda zwykła)
        long start = System.nanoTime();
        data.setDayName();
        long stop=System.nanoTime();

        long result1 = stop - start;

        //drugi pomiar (metoda modulo)
        long start2 = System.nanoTime();
        data2.setDayNameModulo();
        long stop2 = System.nanoTime();

        long result2 = stop2 - start2;

        System.out.println(data.toString("day_name_first"));
        System.out.println(data.toString("no_day_name"));
        System.out.println(data.toString("roman_month"));
        System.out.println(data.toString("shortcut_month"));
    }
}
