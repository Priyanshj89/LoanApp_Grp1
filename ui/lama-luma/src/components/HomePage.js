import React,{useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from 'axios'
import "bootstrap/dist/css/bootstrap.min.css";

export default function HomePage() {
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [passwordError, setpasswordError] = useState("");
    const [emailError, setemailError] = useState("");
  
    const navigate = useNavigate();

    const LoginSubmit = (e) => {
        e.preventDefault();
        
        axios
        .get(
          "http://localhost:8080/hello",
          /*{
            params: { email: email },
          },*/
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
        navigate("/user")

      };

      return (
        <div className="App">
          <div className="container">
            <div className="row d-flex justify-content-center">
              <div className="col-md-4">
                <form id="loginform" onSubmit={LoginSubmit}>
                  <div className="form-group">
                    <label>Email address</label>
                    <input
                      type="text"
                      className="form-control"
                      name="EmailInput"
                      placeholder="Enter email"
                      onChange={(event) => setEmail(event.target.value)}
                    />
                  </div>
                  <div className="form-group">
                    <label>Password</label>
                    <input
                      type="password"
                      className="form-control"
                      placeholder="Password"
                      onChange={(event) => setPassword(event.target.value)}
                    />
                  </div>
                  <button type="submit" className="btn btn-primary">
                    Submit
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      );
}