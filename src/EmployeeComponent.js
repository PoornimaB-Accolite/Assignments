import React, { Component } from 'react';
import "./EmployeeComponent.css";

import AddEmployee from './AddEmployee';
import ListEmployees from './ListEmployee';
import DepartmentComponent from './DepartmentComponent';
import ListDepartments from './ListDepartment';
import SearchComponent from './SearchComponent';

class EmployeeComponent extends Component {
  state = {
    employees: [
      {
        name: "Sharada",
        lname: "V",
        age: 21,
        designation: "intern",
        department: "IT",
        location: "Mangalore, Karnataka,India, Asia, World, Earth"
      },
      {
        name: "Meena",
        lname: "M",
        age: 21,
        designation: "intern",
        department: "HR",
        location: "Bangalore,Karnataka,India, Asia, World, Earth"
      },
      {
        name: "Punith",
        lname: "Chouhan",
        age: 26,
        designation: "intern",
        department :"Accountant",
        location: "Patna, Bihar,India, Asia, World, Earth"
      },
      {
        name: "Ambika",
        lname: "K",
        age: 25,
        designation: "intern",
        department :"HR",
        location: "Patna, Bihar,India, Asia, World, Earth"
      }
    ],
    departments: [

      {
        deptn :"HR",
        desc :" human Resuorce"
      },

      {
        deptn :"IT",
        desc :" Information Technology"
      },
      {
        deptn :"Accountant",
        desc :"Accounts Dept"
      }

    ]
  };

  onEmployeeAdded = (newEmployeeData) => {
      console.log("NewData",newEmployeeData);
      let employees = [...this.state.employees]
      employees.push(newEmployeeData);
      this.setState({employees:employees})
  }
  onDepartmentAdded =(newDepartmentData) =>{

      console.log("NewData",newDepartmentData);
      let departments = [...this.state.departments]
      departments.push(newDepartmentData);
      this.setState({departments : departments})
  }
  render() {
    return (
      <React.Fragment>
        <AddEmployee onEmpAdd={ this.onEmployeeAdded} departments={this.state.departments} />
        <ListEmployees employees={this.state.employees}/>
        <DepartmentComponent  onDeptAdd={this.onDepartmentAdded}/>
        <ListDepartments departments={this.state.departments}/>
        <SearchComponent departments={this.state.departments} employees={this.state.employees}/>
        </React.Fragment>
    );
  }
}

export default EmployeeComponent;