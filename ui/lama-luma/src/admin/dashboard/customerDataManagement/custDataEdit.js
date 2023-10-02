import axios from "axios"
import { useEffect, useState } from "react";
import {Table} from 'react-bootstrap'
import { useNavigate } from "react-router-dom";
import Modal from 'react-bootstrap/Modal';
import  Button  from "react-bootstrap/Button";
import "../../../styles/ViewLoan.css"


export default function CustDataEdit() {
    const [userData, setUserData] = useState([]);
    const[show,setShow]=useState(false);
    const[name,setName]=useState("");
    const[dept,setDept]=useState("");
    const [id,setId]=useState("");
    const[desg,setDesg]=useState("");
    const[gender,setGender]=useState("");
    const[dob,setDob]=useState("");
    const[doj,setDoj]=useState("");
    const navigate=useNavigate();

    async function deleteUser(user){
        let url="http://localhost:8082/employee/delete/"+ user;
            await axios.delete(url)
            .then((res)=>{
                console.log(res);
                if(res.data=="Deleted from db")
                   window.location.reload();
                else
                console.log("error!");
            })
            .catch(err => {
                console.log(err);
              });
    }
    function setButton(bool,item){
        console.log(item);
        setId(item.employee_id);
        setName(item.name);
        setDept(item.dept);
        setDesg(item.designation);
        setGender(item.gender);
        setDob(item.dob);
        setDoj(item.doj);
        setShow(bool);
        console.log("logging after setting "+name);
    }
    const apiCall = async () => {
        await axios.get('http://localhost:8082/employee/allEmployees', {
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*"
            }
        }).then(res => {
            console.log(res.data);
           setUserData(res?.data);
        });
    }

    async function handleEdit(){
        console.log(name);
            await axios.put("http://localhost:8082/employee/edit",
            {
                employee_id:id,
                name:name,
                dept:dept,
                gender:gender,
                dob:dob,
                doj:doj,
                designation:desg
            },{
                headers: {
                  "Content-Type": "application/json",
                  "Access-Control-Allow-Origin":"*"
                },
              }).then(res=>{
                if(res.data=="updated"){
                    
                    window.location.reload();

                }
                else{ console.log("eroor");}
              }).catch(err=>{
                console.log(err);
              })
    }
    useEffect(() => {
        apiCall();
    }, []);
    
    function convert(date){
        return date?.split("T")[0];
    }
    return( <div>
        <table striped bordered hover className="styled-table">
            <thead>
                <tr>
                    <th>Employee id</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Designation</th>
                    <th>Gender</th>
                    <th>Date of birth</th>
                    <th>Date of Joining</th> 
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                 
        {
        userData.map(item=>{
                var temp=convert(item.dob);
                var temp2=convert(item.doj);
            return(
            <tr>
                <td>{item.employee_id}</td>
                <td>{item.name}</td>
                <td>{item.dept}</td>
                <td>{item.designation}</td>
                 <td>{item.gender}</td>
                 <td>{temp}</td>
                  <td>{temp2}</td>
                  <Button style={{width:'80px',marginRight:'20px'}} variant="danger" onClick={()=>deleteUser(item.employee_id)}>Delete</Button>

                  <Button style={{width:'80px',margin:"10px"}} variant="warning" onClick={() => setButton(true,item)}>
                  Edit
                  </Button>
                  
                  <Modal
                    show={show}
                    onHide={() => setShow(false)}
                    dialogClassName="modal-90w"
                    
                  >
                    <Modal.Header closeButton>
                      <Modal.Title >
                        Edit Employee Information
                      </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <form onSubmit={()=>handleEdit()}>
                    <label>Name</label><br/>
                    <input style={{width:'100%'}}  value={name} onChange={(e)=>setName(e.target.value)}/><br />
                    <label>Department</label><br/>
                    <input style={{width:'100%'}} onChange={(e)=>setDept(e.target.value)} value={dept} /><br />
                    <label>Gender</label><br/>
                    <input style={{width:'100%'}} onChange={(e)=>setGender(e.target.value)} value={gender} /><br />
                    <label>Designation</label><br/>
                    <input style={{width:'100%'}} onChange={(e)=>setDesg(e.target.value)} value={desg} /><br />
                    <label>DOB</label><br/>
                    <input style={{width:'100%'}} onChange={(e)=>setDob(e.target.value)} value={convert(dob)} type="date" /><br />
                    <label>DOJ</label><br/>
                    <input style={{width:'100%'}} onChange={(e)=>setDoj(e.target.value)} value={convert(doj)} type="date" /><br />
                    <button>Submit</button>
                    </form>
                    </Modal.Body>
                 </Modal>
            </tr>

         ) })
        }
            </tbody>
        </table>
       

       </div>)
}
