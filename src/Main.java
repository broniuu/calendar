import java.util.*;

public class Main extends RuntimeException {

    public static void main(String[] args) {
        MyDate[] dateArray = new MyDate[3];
        dateArray[0] = new MyDate(1, 1, 2022);
        dateArray[1] = new MyDate(1, 12, 2022);
        dateArray[2] = new MyDate(2, 2, 2022);

        List<MyDate> dateList = new ArrayList<MyDate>();
        dateList.add(new MyDate(5, 5, 2022));
        dateList.add(new MyDate(4, 4, 2023));
        dateList.add(new MyDate(6, 6, 2022));

        System.out.println("------Array-------");
        for (MyDate date: dateArray){
            System.out.println(date.toString());
        }
        System.out.println("------List-------");
        for (MyDate date: dateList){
            System.out.println(date.toString());
        }

        Arrays.sort(dateArray);
        Collections.sort(dateList);
        System.out.print("\n\n After Sort: \n");

        System.out.println("------Array-------");
        for (MyDate date: dateArray){
            System.out.println(date.toString());
        }
        System.out.println("------List-------");
        for (MyDate date: dateList){
            System.out.println(date.toString());
        }
    }
}
