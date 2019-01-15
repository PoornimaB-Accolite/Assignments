import com.sun.deploy.util.SyncAccess;

class Employee{
    int E_id;
    String E_name;
    int E_age;
    static String companyName="Accolite";
    static String company_Loc="Banglore";
    Employee()
    {
        E_id=-1;
        E_name=null;
        E_age=-1;
    }
    Employee(int id,String name,int age)
    {
        E_id=id;
        E_name=name;
        E_age= age;
    }

    @Override
    public String toString() {
        return E_name +"-- " + E_age;
    }
    String getE_name()
    {
        return this.E_name;
    }
    int getE_id()
    {
        return this.E_id;
    }
    int getE_age()
    {
        return  this.E_age;
    }
    void setE_name(String name)
    {
        this.E_name=name;
    }
    void setE_id(int id)
    {
        this.E_id=id;
    }
    void setE_age(int age)
    {
        this.E_age=age;
    }
    void displayStatus()
    {
        System.out.println("In Employee class,Employee name is " +E_name);
    }
    static  String companyName()
    {
        return companyName;
    }
    static  String company_Loc()
    {
        return company_Loc;
    }
}
class Manager extends Employee  //Manager class extending  Employee class
{
    String Department;
    int bonus;
    Manager()
    {
        super();    //To call the constructor of the parent class.
        Department=null;
        bonus=0;
    }
    Manager(int id,String name,int age,String Department,int bonus)
    {
        super(id,name,age);
        this.Department=Department;
        this.bonus = bonus;         // "this" keyword represents the current object which called that object.
    }

    @Override
    public String toString() {
        return this.E_name+ " -- "+this.Department;
    }
    String getDepartment()
    {
        return this.Department;
    }
    int getBonus()
    {
        return this.bonus;
    }
    void  setDepartment(String Department)
    {
        this.Department= Department;
    }
    void setBonus(int bonus) {
        this.bonus = bonus;
    }
    void displayStatus()
    {
        System.out.println("I am "+this.E_name+"  Manager of " + this.Department+" Department");
    }

}
class Developer extends Employee
{
    String client_Loc;
    Developer()
    {
        super();
        client_Loc=null;

    }
    Developer(int id,String name,int age,String client_Loc)
    {
        super(id,name,age);
        this.client_Loc=client_Loc;

    }

    @Override
    public String toString() {
        return this.E_name +"--" + this.client_Loc;
    }
    String getClient_Loc()
    {
        return this.client_Loc;
    }
    void setClient_Loc(String client_Loc)
    {
        this.client_Loc=client_Loc;
    }
    void displayStatus()    //display method is overriding the Parent class method dispaly status.
    {
        System.out.println("I am a Develeoper "+this.E_name+" And I work in ClientLocation =" + this.client_Loc);
    }


}
public class InheritanceExample
{
    public static void main(String[] args)
    {
        Employee staff[] = new Employee[3];
        staff[0] = new Employee(1,"Pavi",21);
        staff[1]=new Manager(2,"Poorna",22,"IT",10000); //A parent class reference type can hold child class object
        staff[2]=new Developer(3,"Sharada",25,"Electronic City");
        for(int i=0;i<staff.length;i++)
        {
            System.out.println(staff[i]);   //By default toString method will be called.
        }
        for(int i=0;i<staff.length;i++)
        {
            staff[i].displayStatus();   //overriding of parent class method display happens by manager and developer objects.
        }
        //to show all the objects share the static variable.
        for(int i=0;i<staff.length;i++)
        {
            System.out.println(staff[i].E_name+"--"+staff[i].getClass()+"--"+staff[i].companyName());
            System.out.println(staff[i].company_Loc());
            System.out.println();
        }
    }
}
