import { useState } from "react";
import Navbar from "../../components/Navbar";
import axios from "axios";
import "../../styles/ApplyLoan.css";

const ItemMaster = () =>{
    function handleSubmit(e){
        e.preventDefault();
        console.log(itemid);
        console.log(value);
        console.log(desc);
        console.log(make);
        console.log(category);
        console.log(name);

        axios
        .post(
          "http://localhost:8082/item/addItem",
          {
             item_id:itemid,
             description: desc,
             item_make:make,
             category:category,
             valuation:value,
             item_name:name

          },
          {
            headers: {
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin":"*"
            },
          }
        )
        .then(res => {
            console.log(res)
            alert("Item added Successfully to itinerary");
        })
        .catch(err => {
          console.log(err);
          alert("Item addition failed");
        });
      
    }
    
    const [itemid,setitemid]=useState("");
    const [value,setValue]=useState();
    const [desc,setDesc]=useState("");
    const [make,setMake]=useState("");
    const [category,setCategory]=useState("");
    const [name,setName] = useState("");

    return <div>
        <Navbar/>
        <div className="applyloan-wrapper">
        <h2>Add Item Eligible for Loan</h2>
        <br/>
        <div className="applyLoan">
            <form onSubmit={handleSubmit}> 
            <div className="loan-group"> 
            <div className="loan-group"> 
                <label for="item_id">Item Id:</label>
                <input id="item_id"  onChange={(e)=>{setitemid(e.target.value)}}/>
            </div>
            <div className="loan-group"> 
                <label for="item_name">Item Name:</label>
                <input id="item_name"  onChange={(e)=>{setName(e.target.value)}}/>
            </div>
                <label for="itemMake">Item Make:</label>
                <select id="itemMake" onChange={(e)=>setMake(e.target.value)}>
                    <option value="Wooden">Wooden</option>
                    <option value="Steel">Steel</option>
                    <option value="Hardware">Hardware</option>
                    <option value="Software">Software</option>
                </select>
            </div>
            <div className="loan-group"> 
                <label for="itemCategory">Item Category:</label>
                <select id="itemCategory" onChange={(e)=>setCategory(e.target.value)}>
                    <option value="Furniture">Furniture</option>
                    <option value="Stationary">Stationary</option>
                    <option value="Appliances">Appliances</option>
                    <option value="Stationary">Stationary</option>
                </select>
            </div>
            <div className="loan-group"> 
                <label for="desc">Item Description:</label>
                <input id="desc"  onChange={(e)=>{setDesc(e.target.value)}}/>
            </div>
            <div className="loan-group"> 
                <label for="itemValue">Item Value:</label>
                <input id="itemValue"  onChange={(e)=>{setValue(e.target.value)}}/>
            </div>
            
                <button className="loan-btn">ADD ITEM</button>
            </form>
        </div>
        </div>
        </div>
}

export default ItemMaster;