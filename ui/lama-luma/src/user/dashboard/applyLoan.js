import { useState } from "react";

const ApplyLoan = () => {

    function handleSubmit(e){
        e.preventDefault();
        console.log(empid);
        console.log(value);
        console.log(desc);
        console.log(make);
        console.log(category);
    }
    

    const [empid,setempid]=useState("");
    const [value,setValue]=useState("");
    const [desc,setDesc]=useState("");
    const [make,setMake]=useState("");
    const [category,setCategory]=useState("");
    return <div>
        <h2>Apply For a Loan</h2>

        <div className="applyLoan">
            <form onSubmit={handleSubmit}>  
                <br /><label for="emp_id">Employee Id</label>
                <input id="emp_id"  onChange={(e)=>{setempid(e.target.value)}}/>

                <br /><label for="desc">Item Description</label>
                <input id="desc"  onChange={(e)=>{setDesc(e.target.value)}}/>

                <br /><label for="itemValue">Item Value</label>
                <input id="itemValue"  onChange={(e)=>{setValue(e.target.value)}}/>
                    <br />
                <label for="itemMake">Item Make</label>
                <select id="itemMake" onChange={(e)=>setMake(e.target.value)}>
                    <option value="Wooden">Wooden</option>
                    <option value="Steel">Steel</option>
                    <option value="Hardware">Hardware</option>
                    <option value="Software">Software</option>
                </select>
                <br />
                <label for="itemCategory">Item Category</label>
                
                <select id="itemCategory" onChange={(e)=>setCategory(e.target.value)}>
                    <option value="Furniture">Furniture</option>
                    <option value="Stationary">Stationary</option>
                    <option value="Appliances">Appliances</option>
                    <option value="Stationary">Stationary</option>
                </select>





                <button>Apply</button>
            </form>

        </div>
        
        
        </div>
}
export {ApplyLoan};