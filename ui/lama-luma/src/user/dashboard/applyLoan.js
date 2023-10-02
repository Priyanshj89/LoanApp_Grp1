import { useEffect, useState } from "react";
import Navbar from "../../components/Navbar"
import "../../styles/ApplyLoan.css";
import axios from "axios";
import {Button} from 'react-bootstrap';
import "../../styles/ViewLoan.css"
const ApplyLoan = () => {

    const [items,setItems] = useState([]);

    useEffect(()=>{
        axios
        .get(
          "http://localhost:8082/item/allItems",
          {
            headers: {
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin":"*"
            },
          }
        )
        .then(res => {
            console.log(res)
            setItems(res.data)
            //alert("Item added Successfully to itinerary");
        })
        .catch(err => {
          console.log(err);
          //alert("Item addition failed");
        });
    },[])

    const handleLoan = (item) =>{
      console.log(item)
      console.log(localStorage.getItem("empid"))
      axios
        .post(
          "http://localhost:8082/item/addItem",
          {
            employee_id:localStorage.getItem("empid"),
            item_make:item.item_make,
            item_category:item.item_category,
            is_applied:1,
            is_approved:0,
            valuation:item.valuation,
            description:item.description?item.description:"Unavailable"
          },
          {
            headers: {
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin":"*"
            },
          }
        )
        .then(res => {
          console.log(res.data);
          alert("Applied Successfully")
        })
        .catch(err => {
          console.log(err);
        });
    }
    
    return <div>
        <Navbar/>
        <table striped bordered hover className="styled-table">
            <thead>
                <tr>
                    <th>Item Id</th>
                    <th>Category</th>
                    <th>Valuation</th>
                    <th>Item Make</th>
                    <th>Description</th>
                    <th>Apply for Loan</th> 
                </tr>
            </thead>
            <tbody>
                 
        {
        items.map(item=>{
            return(
            <tr>
                <td>{item.item_id}</td>
                <td>{item.item_category}</td>
                <td>{item.valuation}</td>
                <td>{item.item_make}</td>
                 <td>{item.desc}</td>
                 <td><Button variant="link" onClick={()=>handleLoan(item)}>Apply</Button></td> 
            </tr>

         ) })
        }
            </tbody>
        </table>
       
        </div>
}
export {ApplyLoan};