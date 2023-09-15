import axios from "axios"
import { useEffect, useState } from "react";
import {Table} from 'react-bootstrap'


export default function CustDataEdit() {
    const [userData, setUserData] = useState([]);
    const apiCall = async () => {
        await axios.get('http://localhost:8082/employee/allEmployees', {
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*"
            }
        }).then(res => {
            console.log(res.data);
           setUserData(res?.data);
        });
    }
    useEffect(() => {
        apiCall();
    }, []);
    
    function convert(date){
        return date?.split("T")[0];
    }
    return( <div>
        <Table striped bordered hover>
            <thead>
                <tr>
                    <td>Employee id</td>
                    <td>Name</td>
                    <td>Department</td>
                    <td>Designation</td>
                    <td>Gender</td>
                    <td>Date of birth</td>
                    <td>Date of Joining</td> 
                </tr>
            </thead>
            <tbody>
                 
        {
        userData.map(item=>{
                var temp=convert(item.dob);
                var temp2=convert(item.doj);
            return(
            <tr>
                <td>{item.employee_id}</td>
                <td>{item.name}</td>
                <td>{item.dept}</td>
                <td>{item.designation}</td>
                 <td>{item.gender}</td>
                 <td>{temp}</td>
                  <td>{temp2}</td>
            </tr>

         ) })
        }
            </tbody>
        </Table>
       </div>)
}
