function Employee(name,dept,age,eid,mailid,aadarid,doj,sal)
{
	this.name=name;
	this.department=dept;;
	this.age=age;
	this.employeeId=eid;
	this.MailId=mailid;
	this.AdarId=aadarid;
	this.dateOfJoining=doj;
	this.salary=sal;
	this.getDetailsOfEmp = function()
	{
	console.log("Name of the Employee is: "+ this.name);
	console.log("Department of the Employee is: "+ this.department);
	console.log("Employee Id is: "+ this.employeeId);
	console.log("Age of the Employee is: "+ this.age);
	console.log("MailId of the Employee is: "+ this.MailId);
	console.log("AdarId of the Employee is: "+ this.AdarId);
	console.log("joining date of the Employee is: "+ this.dateOfJoining);

	}
}
//prototype property allows you to add new properties to object constructor
//all the Objects share this property
	
Employee.prototype.nationality="Indian";

//prototype property allows you to add new methods to existing objects
Employee.prototype.getNationality = function()
{
	console.log("Nationality Of the employee is" + this.nationality); 
}

//Creating Manager Constructor function which is derived from Employee;
var Manager= function()
{
	Employee.call(this);
	this.reports=[];
	this.ManRepFunction = function(){
		for(var i=0;i<reports.length;i++)
		{
	 		console.log("Report["+i+"]="+reports[i]);

		}

	}
}
Manager.prototype = Object.create(Employee.prototype);
Manager.prototype.constructor = Manager;

//creating an object of Employee;
var Emp1= new Employee("Poorna","IT","Acco@11","20","Poorna@gmail.com","3241","03/01/2019",10000);

//to get the details of Emp1
Emp1.getDetailsOfEmp();

//to get the nationality of Emp1
Emp1.getNationality();

//Adding properties to an object that is specific to a object at run time
Emp1.bonus=30000;

//creating a Manager object;
var mnger1 = new Manager;
mnger1.name="Anju";
mnger1.age="20";
mnger1.MailId="a@accoliteindai.com";
mnger1.aadarNo="1234";
mnger1.EmployeeId="Acco@3";
mnger1.dateOfJoining="03/2/2010";
mnger1.reports=[rep1,rep2,rep3];

//using __proto__ to property to only Manager object
mnger1.__proto__.NoOfEmployees=20;

//adding a method to manager objects
Manager.prototype.getNoOfEmps=function()
{
	console.log("Number of Employees under this Manager"+this.NoOfEmployees);
}

//Creating HR Constructor function which is derived from Employee;
var HR= function()
{
	Employee.call(this);
	this.hiredEmps=[];
	this.HiredEmpsFunction = function(){
		for(var i=0;i<hiredEmps.length;i++)
		{
	 		console.log("HiredEmp["+i+"]="+hiredEmps[i]);

		}

	}
}
HR.prototype = new Employee;
HR.prototype.constructor = HR;

// creating HR object
var hr1 = new Employee("Meena","HealthCare","Acco@16","30","meena@gmail.com","4561","03/01/2000",100000);
hr1.hiredEmps[0]="reena";
hr1.hiredEmps[1]="teena";
hr1.hiredEmps[2]="Sheena";

//To get all the employees hired from this manager
hr1.HiredEmpsFunction();

//to display details of the Hr1
hr1.getDetailsOfEmp();

//Adding a new property to the Hr1 object;
hr1.__proto__.experience=30;
//Adding a new property to all the objects of HR
HR.prototype.native="Banglore";
//Adding a new method to HR to get the native of HR
HR.prototype.getNativeOfHR = function()
{
	console.log("Native of HR"+ this.name +" is" +this.native);
}

// to get details of emp1,mnger1,hr1
emp1.getDetailsOfEmp();
mnger1.getDetailsOfEmp();
hr1.getDetailsOfEmps();

//to get all the managed by manager
mnger1.ManRepFunction();

//Using call
var empfunction =emp1.getDetailsOfEmp;
empfunction.call(emp1);

var mangerfunc = mnger1.getDetailsOfEmp;
mangerfunc.call(mnger1);


















	





