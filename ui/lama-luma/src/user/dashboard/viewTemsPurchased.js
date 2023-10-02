import { useEffect,useState } from "react";
import Navbar from "../../components/Navbar";
import axios from "axios";
import "../../styles/ViewLoan.css"

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
        <h1 style={{textAlign:"center",marginTop:"2rem"}}>Items You have purchased</h1>
            <table striped bordered hover className="styled-table">
                <thead>
                    <tr>
                        <th>Item id</th>
                        <th>Item Category</th>
                        <th>Item Make</th>
                        <th>Valuation</th>
                       {// <td>Loan Id</td>
                       }
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
                            {//<td>{item.loan}</td>   
                    }     
                        </tr>
                    )})
                    }
        </tbody>
    </table>
</div>
}
export {ViewItemsPurchased};