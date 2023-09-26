import { useEffect,useState } from "react";
import Navbar from "../../components/Navbar";
import axios from "axios";
import {Table} from 'react-bootstrap';

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
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <td>Loan id</td>
                        <td>Issue Date</td>
                        <td>Return Date</td>
                        <td>Type</td>
                        <td>Duration</td>
                        <td> Status</td>
                    </tr>
                </thead>
                <tbody>
         
                    {
                    loans.map(item=>{
                        var str="pending";
                        if(item[5]==true)
                         str="approved"
                        
                        return(
                        <tr>
                            <td>{item[0]}</td>
                            <td>{item[1]}</td>
                            <td>{item[2]}</td>
                            <td>{item[3]}</td>
                            <td>{item[4]}</td>        
                           item[5]?(
                            <td style={{color:'green'}}>Approved</td>
                           ):(
                            <td style={{color:'yellow'}}>Pending</td>
                           )      

                        </tr>
                    )})
                    }
        </tbody>
    </Table>
</div>
}
export {ViewLoan};