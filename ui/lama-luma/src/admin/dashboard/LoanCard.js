import React, { useEffect, useState } from 'react'
import axios from "axios";
import {Table} from 'react-bootstrap'
import Navbar from '../../components/Navbar';
import "../../styles/LoanCard.css"
import "../../styles/AdminLogin.css";
import ToBeApproved from "../dashboard/ToBeApproved"

const LoanCard = () => {
    const [type,setType]=useState("Furniture");
    const [lid,setLid]=useState("");
    const [time,setTime]=useState("");
    const [loans,setLoans]=useState([]);
    const [items,setItems]=useState();

    async function getAllItems(){
        await axios.get("http://localhost:8082/item/getToBeapproved").then(res=>{
            console.log(res.data);
            setItems(res?.data);
        })
        .catch(err=>{
            console.log(err);
        })
    }

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
       getAllItems();
    },[])
    return (
        <div>
            <Navbar/>
            <div style={{display:"flex"}}>
        <div className='LoanCard' style={{width:'100%',padding:"2rem"}}>
            <div className='border-st'>
            <form style={{justifyContent:'center',border:'2px',display:"flex",flexDirection:"column"}} onSubmit={handleLoan}>
                    <div className='form-data-c'>
                    <label>Loan Type</label>
                    <select value={type}  onChange={(e)=>setType(e.target.value)}>
                        <option>Furniture</option>
                        <option>Crockery</option>
                        <option>Software</option>
                        <option>Hardware</option>
                        <option>Stationary</option>
                    </select>
                    </div>

                    <div className='form-data-c'>
                    <label> Loan Id</label>
                    <input value={lid}/>
                    </div>

                    <div className='form-data-c'>
                    <label >Duration(in years)</label>
                    <input value={time} onChange={(e)=>setTime(e.target.value)}/>
                    </div>
                    <button className='sect-btn'>Add Data</button>
                </form>
<br /><br />
                <Table striped bordered hover variant='dark'>
            <thead>
                <tr>
                    <th>Loan id</th>
                    <th>Loan Type</th>
                    <th>Issue Date</th>
                    <th>Return Date</th>
                    <th>Duration</th>
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
            </div>
            <ToBeApproved/>
        </div>
        </div>
    )
}

export default LoanCard;