public class Demo26 {
    public static void main(String[] args) {
        //System.out.println(Months.JAN);
        //System.out.println(MonthsClone.JAN);
        Months.JAN.print();
        Months.FEB.print();
        // Value Constriants
        String month = "JANUARY";
        month = "FEBRUARY";
        month = "ABC";

        Months myMonth = Months.JAN;
        myMonth = Months.FEB;
        //myMonth = "ABC";
    }
}

class MonthsClone{
    public static final MonthsClone JAN = new MonthsClone();
    public static final MonthsClone FEB = new MonthsClone();
    public static final MonthsClone MAR = new MonthsClone();
    public static final MonthsClone APR = new MonthsClone();
    public static final MonthsClone MAY = new MonthsClone();

    private String fieldName;
    private static int count;

    {
        fieldName = MonthsClone.class.getDeclaredFields()[count++].getName();
    }

    private MonthsClone(){
        
    }

    // private void print(){
    //     new MonthsClone();
    // }

    @Override
    public String toString() {
        return fieldName;
    }
    
}

enum Months {
    JAN(1, "January"),
    FEB(2, "February"),
    MAR(3, "March");

    private int index;
    private String fullName;

    Months(int index, String fullName){
        this.index = index;
        this.fullName = fullName;
    }

    public void print(){
        System.out.printf("month:%s - %s \n", index, fullName);
    }
}

enum DayOfWeek{
    MONDAY(1), TUESDAY(2), WEDNESDAY(3);
    int x;
    DayOfWeek(int x){this.x = x;}
}