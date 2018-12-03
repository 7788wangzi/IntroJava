public class Person {
    private String name;
    private int age;

    private Person(String name, int age)
    {
        this.name = name;
        this.age  = age;
    }

    public Person(String name)
    {
        this(name,0);
    }

    public Person()
    {
        this("");
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if(name.length()>0&name.length()<7) //name合法性验证
        {
            this.name = name;
        }
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge()
    {
        if(age>0&age<120) //age合法性验证
        {
            this.age=age;
        }
    }
}
