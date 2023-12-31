import React,{useState} from "react";
import {useNavigate} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import '../styles/AdminLogin.css';
import Navbar from "./Navbar";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

export default function AdminLogin() {
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [passwordError, setpasswordError] = useState("");
    const [emailError, setemailError] = useState("");
    const[show,setShow]=useState(false);
    const[ fid,setFid]=useState("");
    const[name,setName]=useState("");
    const[newp,setNew]=useState("");
  
    
    const navigate = useNavigate();

    const handleValidation = (event) => {
      let formIsValid = true;
  
      /*if (!email.match(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/)) {
        formIsValid = false;
        setemailError("Email Not Valid");
        return false;
      } else {
        setemailError("");
        formIsValid = true;
      }*/
  
      if (!password.match(/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/)) {
        formIsValid = false;
        setpasswordError(
          "Minimum eight characters, at least one letter and one number"
        );
        return false;
      } else {
        setpasswordError("");
        formIsValid = true;
      }
  
      return formIsValid;
    };

    function handleForgot(e){
      e.preventDefault();
      console.log(newp);
      console.log(name);
      console.log(fid);
      axios
      .put(
        "http://localhost:8082/admin/updatePass",
        {
           admin_id: fid,
           name:name,
           password:newp
        },
        {
          headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin":"*"
          },
        }
      )
      .then(res => {
          console.log("Heelo"+res)
          if(res.data=="updated")
          {
            setShow(false);
            alert("reset")
          }
          else
          alert(res.data);
      })
      .catch(err => {
        console.log(err);
      });
    }
    
    const loginSubmit = (e) => {
        e.preventDefault();
        const formvalidation = handleValidation();

        if(formvalidation){
         axios
        .post(
          "http://localhost:8082/admin/login",
          {
             admin_id: email,
             password:password
          },
          {
            headers: {
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin":"*"
            },
          }
        )
        .then(res => {
            console.log("Heelo"+res)
            if(res.data=="success")
            navigate("/admin/dashboard")
            else
            alert("wrong password/ incorrect id");
        })
        .catch(err => {
          console.log(err);
        });
      
       
       
      }
      };

      return (
        <div className="App">
          <Navbar/>
          <div className="container">
            <div className="row d-flex justify-content-center">
              <div className="col-md-4 adminlogin-card">
                <h2>Admin Login</h2>
                <form id="loginform" onSubmit={loginSubmit}>
                  <div className="form-group">
                    <label>ID</label>
                    <input
                      type="text"
                      className="form-control"
                      name="EmailInput"
                      placeholder="Enter ID"
                      onChange={(event) => setEmail(event.target.value)}
                    />
                <small id="emailHelp" className="text-danger form-text">
                  {emailError}
                </small>
                  </div>
                  <div className="form-group">
                    <label>Password</label>
                    <input
                      type="password"
                      className="form-control"
                      placeholder="Password"
                      onChange={(event) => setPassword(event.target.value)}
                    />
                <small id="passworderror" className="text-danger form-text">
                  {passwordError}
                </small>
                  </div>
                  <button type="submit" className="prim-btn" style={{width:"90%"}}>
                    Login
                  </button>
                </form>
                <>
                  <button className="sec-btn" onClick={() => setShow(true)}>
                    Forgot Password?
                  </button>

                  <Modal
                    show={show}
                    onHide={() => setShow(false)}
                    dialogClassName="modal-90w"
                  >
                    <Modal.Header closeButton>
                      <Modal.Title >
                        Reset Password
                      </Modal.Title>
                    </Modal.Header>
                    <Modal.Body style={{display:"inline-block", width:"10rem"}}>
                    <form onSubmit={handleForgot}>
                    <label>Admin Id</label>
                    <input onChange={(e)=>{setFid(e.target.value)}} />
                    <label>Name/Email</label>
                    <input onChange={(e)=>setName(e.target.value)}/>
                    <label>New Password</label>
                    <input onChange={(e)=>setNew(e.target.value)}/>
                    
                    <button className="prim-btn">Reset</button>
                    </form>
                    </Modal.Body>
      </Modal>
      </>
             

              </div>
            </div>
          </div>
        </div>
      );
}