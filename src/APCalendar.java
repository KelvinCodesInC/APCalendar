public class APCalendar
{
    /** Returns true if year is a leap year and false otherwise. */
    private static boolean isLeapYear(int year)
    {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }
    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2)
    {
        int totalLeapYears = 0;
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                totalLeapYears++;
            }
        }
        return  totalLeapYears;
    }
    /** Returns the value representing the day of the week for the first day of year,
     * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     */
    private static int firstDayOfYear(int year)
    {
        int day = 6; //2000 Jan 1st Saturday
        if (year > 2000) {
            for (int i = 2000; i < year; i++) {
                int days = isLeapYear(i) ? 366 : 365; //if isleapyear then 366 else 365
                day = (day + days) % 7; //mod to get the actual week
            }
        } else {
            for (int i = 1999; i >= year; i--) {
                int days = isLeapYear(i) ? 366 : 365; //if isleapyear then 366 else 365
                day = (day - days) % 7;
                if (day < 0) day += 7 ;
            }
        }

        return day;
    }
    /** Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1 (month = 1, day = 1) of any year.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    private static int dayOfYear(int month, int day, int year)
    {
        int n = 0;
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; //leap year so feb becomes 29
        }

        for (int i = 0; i < month - 1; i++) {
            n += daysInMonth[i];
        }
        n += day;
        return n;
    }
    /** Returns the value representing the day of the week for the given date
     * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
     * and 6 denotes Saturday.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfWeek(int month, int day, int year)
    {
        int firstDay = firstDayOfYear(year);
        int dayNumber = dayOfYear(month, day, year);
        return (firstDay + dayNumber - 1) % 7;
    }
}
