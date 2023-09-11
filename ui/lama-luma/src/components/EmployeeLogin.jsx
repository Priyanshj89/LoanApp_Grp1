import React,{useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from 'axios'
import "bootstrap/dist/css/bootstrap.min.css";
import './EmployeeLogin.css'

export default function EmployeeLogin() {
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [passwordError, setpasswordError] = useState("");
    const [emailError, setemailError] = useState("");
  
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

    const LoginSubmit = (e) => {
        e.preventDefault();
        const formvalidation = handleValidation();

        if(formvalidation){
         axios
        .get(
          "http://localhost:8080/hello",
          {
            id: email,
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
          alert(res.data)
        })
        .catch(err => {
          console.log(err);
        });
        navigate("/user/dashboard")
      }

      };

      return (
        <div className="App">
          <div className="container">
            <div className="row d-flex justify-content-center">
              <div className="col-md-4">
                <h2>Employee Login</h2>
                <form id="loginform" onSubmit={LoginSubmit}>
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
                  <button type="submit" className="btn btn-primary">
                    Submit
                  </button>
                  <div onClick={()=>{navigate('/adminlogin')}}>For Admin Login Click Here</div>
                </form>
              </div>
            </div>
          </div>
        </div>
      );
}