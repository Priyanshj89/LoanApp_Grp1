import { useEffect,useState } from "react";
import Navbar from "../../components/Navbar";
import axios from "axios";
import {Table} from 'react-bootstrap';
import "../../styles/ViewLoan.css"

const ViewLoan = () => {
    const [loans, setLoans] = useState([])
    useEffect(()=>{
        axios.post('http://localhost:8082/loan/getOneLoan',{
            employee_id:"1"
        }, {
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*"
            }
        }).then(res => {
            console.log(res.data);
            setLoans(res?.data);
        });
    },[]);
    return <div>
        <Navbar/>
            <Table striped bordered hover className="styled-table">
                <thead>
                    <tr>
                        <th>Loan id</th>
                        <th>Issue Date</th>
                        <th>Return Date</th>
                        <th>Type</th>
                        <th>Duration</th>
                        <th> Status</th>
                    </tr>
                </thead>
                <tbody>
         
                    {
                    loans.map(item=>{
                
                        
                        return(
                        <tr>
                            <td>{item[0]}</td>
                            <td>{item[1]}</td>
                            <td>{item[2]}</td>
                            <td>{item[3]}</td>
                            <td>{item[4]}</td>        
                           {item[5]?(
                            <td style={{color:'green'}}>Approved</td>
                           ):(
                            <td style={{color:'yellow'}}>Pending</td>
                           )    }  

                        </tr>
                    )})
                    }
        </tbody>
    </Table>
</div>
}
export {ViewLoan};