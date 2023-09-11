import java.lang.reflect.Field;
import java.util.Vector;

public class Demo14 {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ClassLoader classLoader = Demo14.class.getClassLoader();
        Field hiddenField = ClassLoader.class.getDeclaredField("classes");
        hiddenField.setAccessible(true);
        Vector<Class<?>> loadedClasses = (Vector<Class<?>>) hiddenField.get(classLoader);

        System.out.println(loadedClasses);
        int y = MyChild.x;
        System.out.println(y);
        System.out.println(loadedClasses);
        //System.out.println(MyChild.y);
    }   
}

class MyParent {
    static int x = 10;
    static {
        System.out.println("MyParent class is being initialized");
    }
}

class MyChild extends MyParent {
    static int y = 20;
    static {
        System.out.println("MyChild class is being initialized");
    }
}
