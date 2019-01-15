import React, { Component } from "react";

class ListEmployees extends Component {
  render() {
    console.log("Employees", this.props.employees);
    let newEmployee = this.props.employees.map((employee, i) => {
      return i;
    });

    return (
      <div>
        <h1>Employees</h1>

        <table>
          <th>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Age</td>
            <td>Designation</td>
            <td>Department</td>
            <td>Location</td>
          </th>
          {this.props.employees &&
            this.props.employees.map((employee, i) => {
              return (
                <tr key={employee.name}>
                  <td>{employee.name} </td>
                  <td>{employee.lname}</td>
                  <td>{employee.age}</td>
                  <td>{employee.designation}</td>
                  <td>{employee.department}</td>
                  <td>{employee.location}</td>
                </tr>
              );
            })}
        </table>
      </div>
    );
  }
}

export default ListEmployees;