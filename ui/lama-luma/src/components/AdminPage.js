import React,{useState} from "react";
import {useNavigate} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

export default function AdminPage() {
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [passwordError, setpasswordError] = useState("");
    const [emailError, setemailError] = useState("");
  
    
    const navigate = useNavigate();
    
    const loginSubmit = (e) => {
        e.preventDefault();
       // let history = useHistory();
       // history.push("\user")
       navigate("/admin/dashboard")
      };

      return (
        <div className="App">
          <div className="container">
            <div className="row d-flex justify-content-center">
              <div className="col-md-4">
                <form id="loginform" onSubmit={loginSubmit}>
                  <div className="form-group">
                    <label>Hello User XYZ</label>
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