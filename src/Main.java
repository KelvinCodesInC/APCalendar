//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        APCalendar calendar = new APCalendar();
        System.out.println(calendar.dayOfWeek(1, 5, 2019));
        System.out.println(calendar.dayOfWeek(1, 10, 2019));
        System.out.println(calendar.firstDayOfYear(2019));
        System.out.println(calendar.dayOfYear(3,1,2017));
        System.out.println(calendar.dayOfYear(3,1,2016));
        System.out.println();
    }
}
