public class Demo26 {
    public static void main(String[] args) {
        //Months month = Months.JAN;
        // MonthsClone clone=MonthsClone.JAN;
        Months.JAN.print();
    }
}



enum Months {
    JAN(1,"January"), 
    FEB(2,"February"), 
    MAR(2,"March"), 
    APR(4,"April"); 
    

    int index;
    String fullname;

    Months(int index, String fullName) {
        this.index=index;
        this.fullName=fullName;
    }

    public void print() {
        System.out.printf("month:%s - name:%s \n",index,fullname);
    }
}

class MonthsClone {
    public static final MonthsClone JAN = new MonthsClone();
    public static final MonthsClone FEB = new MonthsClone();
    public static final MonthsClone MAR = new MonthsClone();
    public static final MonthsClone APR = new MonthsClone();
    public static final MonthsClone MAY = new MonthsClone();

    private String fieldName;
    private static int count;

    {
        fieldName= MonthsClone.class.getDeclaredFields()[count++].getName();
    }

    // private MonthsClone() {
    // System.out.println("MonthsClone()");
    // }
    @Override
    public String toString(){
        return fieldName;
    }
}
