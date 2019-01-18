package pack;



public class Person {
	String name;
	int id;
	int age;

	public Person() {
		// TODO Auto-generated constructor stub
	} 
	
	Person(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String toString()
	{
		return "Name:"+this.name+"  Age:"+this.age+" Id:"+this.id;
	}

}
