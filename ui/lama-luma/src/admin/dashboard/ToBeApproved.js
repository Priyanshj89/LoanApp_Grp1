import React, { useEffect, useState } from 'react'
import axios from "axios";
import Navbar from '../../components/Navbar';
import "../../styles/LoanCard.css"
import "../../styles/AdminLogin.css"
import {Button} from 'react-bootstrap'
import Modal from 'react-bootstrap/Modal';
import "../../styles/ViewLoan.css"

const LoanCard = () => {

    const [items,setItems]=useState();
    const[show,setShow]=useState(false);
    const [loanid,setloanId]=useState("");
    async function getAllItems(){
        await axios.get("http://localhost:8082/item/getToBeapproved").then(res=>{
            console.log(res.data);
            setItems(res?.data);
        })
        .catch(err=>{
            console.log(err);
        })
    }

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
    async function handleItem(item){
        await axios.post("http://localhost:8082/item/addItemOnLoanApproved",{
            item_id:item.item_id,
            loan_id:loanid
        },{
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*"
            }
        }).then(res=>{
            setShow(false);
            setloanId("");
            getAllItems();
        }).catch(err=>{
            console.log(err);
        })
        
    }
    useEffect(()=>{
       getAllItems();
    },[])
    return (
        <div style={{minWidth:"35rem",margin:"10px"}}>
    
                <table striped bordered hover className="styled-table">
            <thead>
                <tr>
                    <th>Item Id</th>
                    <th>Item Make</th>
                    <th>Item Category</th>
                    <th>Employee Id</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                 
        {
        items?.map(item=>{
             
            return(
            <tr>
                <td>{item.item_id}</td>
                <td>{item.item_make}</td>
                <td>{item.item_category}</td>
                <td>{item.employee.employee_id}</td>
                <Button onClick={()=>setShow(true)} style={{margin:"3px"}}>Y</Button>
                <Button onClick={()=>{deleteItem(item.item_id)}} variant='danger'>N</Button>
                <Modal
                    show={show}
                    onHide={() => setShow(false)}
                    dialogClassName="modal-90w"
                    
                  >
                    <Modal.Header closeButton>
                      <Modal.Title >
                        Approve
                      </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                      <label>Enter Loan Id for the particular Item</label>
                      <input value={loanid} onChange={(e)=>{setloanId(e.target.value)}}/>
                      <Button variant='success' onClick={()=>{handleItem(item)}}>Approve</Button>
                    </Modal.Body>
                 </Modal>
               
            </tr>

         ) })
        }
            </tbody>
        </table>
        </div>
    )
}

export default LoanCard;