public class StaticObj {
    public static int objectCount;
    public String name;

    public StaticObj(String name)
    {
        objectCount++;
        this.name = name;
    }

    public static String getClassName(){
        return "StaticObj";
    }

    public String getObjectName(){
        return this.name;
    }
}
