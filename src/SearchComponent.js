import React,{ Component} from 'react';

class SearchComponent extends Component
{

    search = props =>{
        var dept = document.getElementById('department').value;
        var depts = this.props.departments;
        var emps = this.props.employees;
        var result="<table>";
        var i=0;
        for(i=0;i<emps.length;i++)
        {
            if(dept == emps[i].department)
            {
                result += '<tr><td>'+emps[i].name +'</td><td>'+ emps[i].lname+'</td></tr>'
            }
        }
        result+="</table>"
        document.getElementById("done").innerHTML=result;

    }


    render(){
        return (



                <div>
                <br></br>
                Which Department?
                <select id="department">
                {
                    this.props.departments && this.props.departments.map((department,i)=>{
                        return (
                            <option key={department.deptn}>{department.deptn}</option>
                        )
                    })
                }
                
                
                </select>
                <button onClick={this.search}>Search</button>
                <div id="done"></div>
                </div>

            
        )


    }
    


        
    
}

export default SearchComponent;