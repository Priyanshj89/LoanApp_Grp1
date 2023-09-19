import { useEffect, useState } from "react";
import Navbar from "../../components/Navbar"
import "../../styles/ApplyLoan.css";
import axios from "axios";
import {Table} from 'react-bootstrap'

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
    
    return <div>
        <Navbar/>
        <Table striped bordered hover>
            <thead>
                <tr>
                    <td>Category</td>
                    <td>Item Name</td>
                    <td>Valuation</td>
                    <td>Item Make</td>
                    <td>Description</td>
                </tr>
            </thead>
            <tbody>
                 
        {
        items.map(item=>{
            return(
            <tr>
                <td>{item.category}</td>
                <td>{item.item_name}</td>
                <td>{item.valuation}</td>
                <td>{item.item_make}</td>
                 <td>{item.description}</td>
              
                 
            </tr>

         ) })
        }
            </tbody>
        </Table>
       
        </div>
}
export {ApplyLoan};