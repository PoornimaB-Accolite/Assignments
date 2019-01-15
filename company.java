package poo;

import java.util.*;

class Company
{
    String company_name ;
    Address company_address;
    List<Employee> l1;
    Company()
    {
        company_name=null;
        company_address=new Address();
        l1= new ArrayList<Employee>();
    }
    Company(String name,Address e1,List l)
    {
        company_name = name;
        company_address=e1;
        l1=l;
    }
    Company(String name,String city,String street,String state,Employee[] e1)
    {
        company_name=name;
        company_address= new  Address(city,street,state);
        l1= new ArrayList<Employee>();
        for(int i=0;i<e1.length;i++)
        {
            l1.add(e1[i]);
        }

    }
    @Override
    public String toString() {
        return this.company_name +"--"+this.company_address;

    }

    public String getCompany_name() {
        return company_name;
    }

    public Address getCompany_address() {
        return company_address;
    }

    void listOfEmps()
    {
        System.out.println("-------- "+ this.company_name+"------");
        for(int i=0;i<l1.size();i++)
        {
            System.out.println(l1.get(i).getE_name());

        }
    }
    void listOfEmpsAgelessthan30()
    {
        System.out.println("---List Of Employees of Comapany "+ this.company_name +" who age is less than 30");
        for(int i=0;i<l1.size();i++)
        {
            Employee e1=l1.get(i);
            if(e1.getE_age()<30)
            {
                System.out.println(e1.E_name+"--Age is "+e1.E_age);
            }
            else
                continue;
        }
    }
    void empsSortedByAge()
    {
        System.out.println("-----Employees Of comapany---"+ this.company_name);
        Collections.sort(l1,new SortAcctoAge());
        System.out.println("Sorted By Age--"+l1);
    }
    void empsSortedById()
    {
        System.out.println("-----Employees Of comapany---"+ this.company_name);
        Collections.sort(l1,new SortAcctoId());
        System.out.println("Sorted By Id--"+l1);
    }
    void empsSortedByName()
    {
        System.out.println("-----Employees Of comapany---"+ this.company_name);
        Collections.sort(l1,new SortAcctoName());
        System.out.println("Sorted By Name--"+l1);

    }

}
class CompanyList
{
    List<Company> l2;
    CompanyList()
    {
        l2 = new ArrayList<>();
    }
    CompanyList(Company[] c)
    {
        l2 = new ArrayList<>();
        for(int i=0;i< c.length;i++)
        {
            l2.add(c[i]);
        }
    }
	void listOfcompaniesInSamecity(String city)
	{
		for(int i=0;i<l2.size();i++)
		{
			if(l2.get(i).getCompany_address().getCity().equals(city))
			{
				System.out.println(l2.get(i).getCompany_name());
			}
		}
		
	}
    
}


class Employee
{
   String E_name;
   int  E_id;
   int  E_age;
   Employee()
   {
       E_name=null;
       E_id=-1;
       E_age=-1;
   }
    Employee(String name,int id,int age)
    {
        E_name=name;
        E_id=id;
        E_age = age;
    }


    @Override
    public String toString() {
        return "Name--"+this.E_name+"-Age--"+this.E_age+"-Id--"+this.E_id;
    }

    public int getE_age() {
        return E_age;
    }

    public int getE_id() {
        return E_id;
    }

    public String getE_name() {
        return E_name;
    }

    public void setE_age(int e_age) {
        E_age = e_age;
    }

    public void setE_id(int e_id) {
        E_id = e_id;
    }

    public void setE_name(String e_name) {
        E_name = e_name;
    }
}
class SortAcctoAge implements Comparator<Employee>
{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getE_age()-o2.getE_age();
    }
}
class SortAcctoName implements Comparator<Employee>
{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getE_name().compareTo(o2.getE_name());
    }
}
class SortAcctoId implements Comparator<Employee>
{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getE_id()-o2.getE_id();
    }
}

class Address
{
    String city;
    String street;
    String state;
    Address()
    {
        city=street=state=null;
    }
    Address(String city,String street,String state)
    {
        this.city=city;
        this.street=street;
        this.state=state;
    }

    @Override
    public String toString() {
        return "Comapny city is "+this.city+"--Street-"+this.street+"--State is "+this.state;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return this.street;
    }

    public String getState() {
        return this.state;
    }
}


public class mainMethodClass
{
    public static void  main(String[] args)
    {
        Employee e1 = new Employee("Poorna",1,35);
        Employee e2 = new Employee("pavi",2,18);
        Employee e3 = new Employee("Sharada",5,19);
        Employee e4 = new Employee("Punith",3,25);
        Employee e5 = new Employee("Satish",4,40);
        Employee e6 =new Employee("Chaithra",6,16);
        Employee[] emps = new Employee[3];
        emps[0]=e1;
        emps[1]=e2;
        emps[2]=e3;
        List<Employee> l = new ArrayList<Employee>();
        l.add(e4);
        l.add(e5);
        l.add(e6);
        Address adds1= new Address("Banglore","Marathalli","Karnataka");
        Company c1 = new Company("Accolite","Banglore","Marathalli","karnataka",emps);
        Company c2 = new Company("Cisco",adds1,l);
        //To list all employees of a Particular company.
        c1.listOfEmps();
        c2.listOfEmps();
        //to list all the employees of a company who has age less than 30
        c1.listOfEmpsAgelessthan30();
        c2.listOfEmpsAgelessthan30();
        //to list all employees according to their age in ascending order.
        c1.empsSortedByAge();
        c2.empsSortedByAge();
        //to list all employees sorted by id in ascending order.
        c1.empsSortedById();
        c2.empsSortedById();
        //to list all employees sorted by their name in ascending order.
        c1.empsSortedByName();
        c2.empsSortedByName();
		
        //List Of companies located in the same city.
        Company[] c = new Company[2];

        CompanyList complst = new CompanyList(c);
		complst.listOfcompaniesInSamecity();


    }
}
