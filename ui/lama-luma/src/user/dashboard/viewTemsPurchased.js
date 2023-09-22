import { useEffect,useState } from "react";
import Navbar from "../../components/Navbar";
import axios from "axios";
import {Table} from 'react-bootstrap';

const ViewItemsPurchased = () => {

    const [items, setItems] = useState([])
    useEffect(()=>{
        axios.get('http://localhost:8082/employee/getItemsPurchased',{
           //employee_id:localStorage.get("empid");
        }, {
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*"
            }
        }).then(res => {
            console.log(res.data);
            setItems(res?.data);
        });
    },[]);
    return <div>
        <Navbar/>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <td>Employee id</td>
                        <td>Name</td>
                        <td>Department</td>
                        <td>Designation</td>
                        <td>Gender</td>
                        <td>Date of birth</td>
                    </tr>
                </thead>
                <tbody>
         
                    {
                    items.map(item=>{
                        return(
                        <tr>
                            <td>{item.employee_id}</td>
                            <td>{item.name}</td>
                            <td>{item.dept}</td>
                            <td>{item.designation}</td>
                            <td>{item.gender}</td>        
                        </tr>
                    )})
                    }
        </tbody>
    </Table>
</div>
}
export {ViewItemsPurchased};