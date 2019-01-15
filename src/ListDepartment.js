import React, { Component } from "react";
import './DepartmentComponent.css'
class ListDepartment extends Component {
  render() {
    console.log("Departments", this.props.departments);
    let newdepartment = this.props.departments.map((department, i) => {
      return i;
    });

    return (
        <div>
          <h1>Department</h1>
  
          <table>
            <th>
              <td>Dept Name</td>
              <td>Dept Desc</td>
            </th>
            {this.props.departments &&
              this.props.departments.map((department, i) => {
                return (
                  <tr key={department.deptn}>
                    <td>{department.deptn}</td>
                    <td>{department.desc}</td>
                
                  </tr>
                );
              })}
          </table>
        </div>
      );
        
    }
}


export default ListDepartment;