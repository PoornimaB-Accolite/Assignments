import React, { Component } from "react";

class AddEmployee extends Component {
    data ={

    }
  state = {
    shown: false
  };
  onClick = () => {
    this.setState({ shown: true });
  };
  onCancel = e => {
    e.preventDefault();
    this.setState({ shown: false });
  };
  handleChange = (event) =>{
     console.log(event.target.value);
      this.data[event.target.id] = event.target.value;
  };
  add = e =>{
      e.preventDefault(); 
      console.log("Data",this.data);
      this.props.onEmpAdd(this.data);
  }
  validation =()=>
  {
    var x= document.getElementById("age").value;
    if(x<18)
    {
      alert("Age is less than 18");
    }
    
  }
  
  render() {
    return (
      <div>
        <br>
        </br>
        Add an Employee 
        <button onClick={this.onClick}>Add Employee</button>
        {this.state.shown && (
          <div>
            <form onSubmit={this.validation}>
              FirstName :<input type="text" id="name" placeholder="UserName" onChange={this.handleChange} /><br></br>
              Last Name :<input type="text" id="lname" placeholder="LastName" onChange={this.handleChange} /><br></br>
             Age : <input type="number" id="age" placeholder="Age" onChange={this.handleChange} /><br></br>
             Designation : <input type="text" id="designation" placeholder="Designation"  onChange={this.handleChange}/><br></br>
             Department<select id="department" onChange={this.handleChange} default="hr">
             {

               this.props.departments && this.props.departments.map((dept,i)=>{
                 return(
                   <option key={dept.deptn}>{dept.deptn}</option>
                 );
               })
              } 
               
             
             
             </select><br></br>
             Location: <input type="text" id="location" placeholder="location" onChange={this.handleChange}/><br></br>
              <button onClick={this.add} >Add Employee </button>
              <button onClick={this.onCancel}> Cancel</button>
            </form>
          </div>
        )}
      </div>
    );
  }
}

export default AddEmployee;