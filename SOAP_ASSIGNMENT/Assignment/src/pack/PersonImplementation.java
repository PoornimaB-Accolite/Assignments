package pack;

import java.util.ArrayList;

public class PersonImplementation {
	
	 static ArrayList<Person> persons = new ArrayList<>();
		
	public static String addPersons()
	{
		persons.add(new Person("A",1,20));
		persons.add(new Person("B",2,21));
		persons.add(new Person("c",2,22));
		return "Persons are added";
		
	}
	public static String createPerson(String name,int id, int age) {
		persons.add(new Person(name,id,age));

		return "Person added Succesfully";
		}

	public static String getPersonDetails(int id) {

		for (Person p : persons) {
			if (p.getId() == id) {
				return p.toString();
			}
		}
		return "No match found";
	}

	public static String getAllPersons() {
		if (persons.isEmpty() != true) {
			return persons.toString();
		}

		return "No persons";
	}

	public static String delete(int id) {

		for (Person p : persons) {
			if (p.getId() == id) {
				persons.remove(p);
				return "Person deleted with Id:"+ id;
			}
		}
		return "Erro in deleted..Person does not exists";
	}
	
	public static String updatePerson(String name,int id,int age)
	{
		for(Person p : persons)
		{
			if(p.getId() == id)
			{
				p.setName(name);
				p.setAge(age);
				return "Person Updated Succesfully..with Id"+id;
			}
		}
		return "Failed to Update";
	}

}
