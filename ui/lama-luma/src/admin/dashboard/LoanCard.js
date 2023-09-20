import React, { useEffect, useState } from 'react'
import axios from "axios";
import {Table} from 'react-bootstrap'

const LoanCard = () => {
    const [type,setType]=useState("Furniture");
    const [lid,setLid]=useState("");
    const [time,setTime]=useState("");
    const [loans,setLoans]=useState();

    async function getAllLoans(){
        await axios.get("http://localhost:8082/loan/allLoans").then(res=>{
            console.log(res.data);
            setLoans(res?.data);
        })
        .catch(err=>{
            console.log(err);
        })
    }
    async function handleLoan(e){
        e.preventDefault();
        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth();
        var day = d.getDate();
        var c = new Date(year + Number(time), month, day);
        console.log(c);
        await axios.post("http://localhost:8082/loan/addLoan", {
          loan_id:lid,
          loan_type:type,
          duration:time,
          issue_date:d,
          return_date:c
         },
         {
           headers: {
             "Content-Type": "application/json",
             "Access-Control-Allow-Origin":"*"
           },
         }).then((res)=>{
             if(res.status=="200"){
                var temp=Math.floor(Math.random() * 1000);
                setLid("L"+temp);
                setTime("");
                setType("Furniture");
                getAllLoans();
                console.log("get worked")
             }
         })
         .catch(err=>{
            console.log(err);
         })
    }
    useEffect(()=>{
       var temp=Math.floor(Math.random() * 1000);
       setLid("L"+temp);
       getAllLoans();
    },[])
    return (
        <div className='LoanCard' style={{width:'100%',display:'flex'}}>
            <div style={{borderRight:'2px solid black',width:'50%'}}>
            <form style={{justifyContent:'center',border:'2px'}} onSubmit={handleLoan}>
                    <label>Loan Type</label>
                    <select value={type}  onChange={(e)=>setType(e.target.value)}>
                        <option>Furniture</option>
                        <option>Crockery</option>
                        <option>Software</option>
                        <option>Hardware</option>
                        <option>Stationary</option>
                    </select><br />
                    <label> Loan Id</label>
                    <input value={lid}/><br />
                    <label >Duration(in years)</label>
                    <input value={time} onChange={(e)=>setTime(e.target.value)}/><br />
                    <button>Add Data</button>
                </form>
<br /><br />
                <Table striped bordered hover>
            <thead>
                <tr>
                    <td>Loan id</td>
                    <td>Loan Type</td>
                    <td>Issue Date</td>
                    <td>Return Date</td>
                    <td>Duration</td>
                </tr>
            </thead>
            <tbody>
                 
        {
        loans?.map(item=>{
             
            return(
            <tr>
                <td>{item.loan_id}</td>
                <td>{item.loan_type}</td>
                <td>{item.issue_date}</td>
                <td>{item.return_date}</td>
                 <td>{item.duration}</td>
               
            </tr>

         ) })
        }
            </tbody>
        </Table>
            </div>
            <div > 
            
            </div>
                
        </div>
    )
}

export default LoanCard;