import { useState,useEffect } from "react";
import Navbar from "../../components/Navbar"
import '../../styles/ApplyLoan.css'
import axios from 'axios'
import {Table} from 'react-bootstrap'

import {Button} from 'react-bootstrap'

export default function ItemMaster(){
        const [items,setItems]=useState();

        async function deleteItem(id){
            let url="http://localhost:8082/item/delete/" +id;
            await axios.delete(url).then((res)=>{
                if(res.status=="200" && res.data=="Deleted from db"){
                    console.log("deleted");
                    getAllItems();
                }
            }).catch(err=>{
                console.log(err);

            })
        }
        async function getAllItems(e){
            //  e.preventDefault();
            await axios.get("http://localhost:8082/item/allItems",{
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin":"*"
            }).then(res=>{
                setItems(res.data);
                console.log(res.data);
            }).catch(err=>{
                console.log(err);
            })
        }

useEffect(()=>{
    getAllItems()
},[])

    async function handleSubmit(e){
        e.preventDefault();
        console.log(value);
        console.log(desc);
        console.log(make);
        console.log(category);
        await axios.post("http://localhost:8082/item/addItem",{
            description:desc,
            item_category:category,
            item_make:make,
            valuation:value
        },{
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin":"*"
        }).then(res=>{
            if(res.status=="200"){
                setCategory("Furniture");
                setMake("wooden");
                setValue("");
                setDesc("");
                getAllItems();
            }
        })
    }
    

    const [empid,setempid]=useState("");
    const [value,setValue]=useState("");
    const [desc,setDesc]=useState("");
    const [make,setMake]=useState("wooden");
    const [category,setCategory]=useState("furniture");
    return <div>
        <Navbar/>
        <div className="applyloan-wrapper">
        <h2 tyle={{marginLeft:'50px'}}>Add a new Item</h2>
        <br/>
        <div className="applyLoan">
            <form onSubmit={handleSubmit}> 
            
            <div className="loan-group"> 
                <label for="desc">Item Description:</label>
                <input id="desc" value={desc} onChange={(e)=>{setDesc(e.target.value)}}/>
            </div>
            <div className="loan-group"> 
                <label for="itemValue">Item Value:</label>
                <input id="itemValue" value={value} onChange={(e)=>{setValue(e.target.value)}}/>
            </div>
            <div className="loan-group"> 
                <label for="itemMake">Item Make:</label>
                <select id="itemMake" value={make} onChange={(e)=>setMake(e.target.value)}>
                    <option value="Wooden">Wooden</option>
                    <option value="Steel">Steel</option>
                    <option value="Hardware">Hardware</option>
                    <option value="Software">Software</option>
                </select>
            </div>
            <div className="loan-group"> 
                <label for="itemCategory">Item Category:</label>
                <select id="itemCategory" value={category} onChange={(e)=>setCategory(e.target.value)}>
                    <option value="Furniture">Furniture</option>
                    <option value="Stationary">Stationary</option>
                    <option value="Appliances">Appliances</option>
                    <option value="Stationary">Stationary</option>
                </select>
            </div>
                <button className="loan-btn">Add</button>
            </form>

        </div>
        </div>
        <h1>Available Items</h1>
        <Table striped bordered hover>
            <thead>
                <tr>
                    <td>Item Id</td>
                    <td>Item Category</td>
                    <td>Item Make</td>
                    <td>Valuation</td>
                </tr>
            </thead>
            <tbody>
                 
        {
        items?.map(item=>{
             
            return(
            <tr>
                <td>{item.item_id}</td>
                <td>{item.item_category}</td>
                <td>{item.item_make}</td>
                <td>{item.valuation}</td>
                <Button variant="danger" onClick={()=>{deleteItem(item.item_id)}}>Delete Item</Button>
            </tr>

         ) })
        }
            </tbody>
        </Table>
        </div>
}
