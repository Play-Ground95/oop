public class Demo28 {
    public static void main(String[] args) {
        // String -> Enum
        WeekDays day = WeekDays.valueOf("FRIDAY");
        System.out.println(day);

        System.out.println("----------------");

        WeekDays[] constants = WeekDays.values();
        for (WeekDays constant : constants) {
            System.out.println(constant);
        }

        day = WeekDays.WEDNESDAY;
        System.out.println(day.name());         // WEDNESDAY
        System.out.println(day.ordinal());      // 2

        switch (day){
            case MONDAY:
                System.out.println("Monday");
                break;
            case TUESDAY:
                System.out.println("Tuesday");
                break;
            case WEDNESDAY:
                System.out.println("WEDNESDAY");
                break;
            default:
                System.out.println("Some other day");
        }
    }
}

enum WeekDays{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}