import React, { Component } from "react";

class DepartmentComponent extends Component {
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
     console.log(event.target.value );
      this.data[event.target.id] = event.target.value;
  };
  add = e =>{
      e.preventDefault(); 
     
      console.log("Data",this.data);
      this.props.onDeptAdd(this.data);
    };
  
  
  render() {
    return (
      <div>
        ...............................................................................................................
        <br></br>
        Add the Department<br></br>
        <button onClick={this.onClick}>Add Department</button>
        {this.state.shown && (
          <div>
            <form >
              DepartMentName :<input type="text" id="deptn" placeholder="UserName" required onChange={this.handleChange}/><br></br>
             Departn Description: <input type="text" id="desc" placeholder="Description" required onChange={this.handleChange} /><br></br>
              <button onClick={this.add} >Add Department</button>
              <button onClick={this.onCancel}> Cancel</button>
            </form>
          </div>
        )}
      </div>
    );
  }
}

export default DepartmentComponent;