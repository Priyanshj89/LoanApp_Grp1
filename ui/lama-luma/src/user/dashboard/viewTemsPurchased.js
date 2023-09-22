import { useEffect,useState } from "react";
import Navbar from "../../components/Navbar";
import axios from "axios";
import {Table} from 'react-bootstrap';

const ViewItemsPurchased = () => {

    const [items, setItems] = useState([])
    useEffect(()=>{
        axios.post('http://localhost:8082/item/getItemsPurchased',{
           employee_id:localStorage.getItem("empid")
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
        <h1 style={{marginLeft:'400px'}}>Items You have purchased</h1>
        <br />
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <td>Item id</td>
                        <td>Item Category</td>
                        <td>Item Make</td>
                        <td>Valuation</td>
                        <td>Loan Id</td>
                    </tr>
                </thead>
                <tbody>
         
                    {
                    items.map(item=>{
                        return(
                        <tr>
                            <td>{item.item_id}</td>
                            <td>{item.item_category}</td>
                            <td>{item.item_make}</td>
                            <td>{item.valuation}</td>
                            <td>{item.loan}</td>        
                        </tr>
                    )})
                    }
        </tbody>
    </Table>
</div>
}
export {ViewItemsPurchased};