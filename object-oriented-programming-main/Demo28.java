public class Demo28 {
    public static void main(String[] args) {
        WeekDays day = WeekDays.valueOf("FRIDAY");
        System.out.println(day);

        WeekDays[] constant=WeekDays.values();
        for (WeekDays weekDays : constant) {
            System.out.println(constant);
        }
        
        
        day=WeekDays.MONDAY;
        System.out.println(day.ordinal()); //0
        System.out.println(day.name());//MONDAY



    }
}

enum WeekDays{
    MONDAY,TUESDAY,WEDNESDAY,THRUSDAY,FRIDAY,SATURDAY,SUNDAY;
}