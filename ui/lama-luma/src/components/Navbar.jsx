import "../styles//Navbar.css"
import { useNavigate,useLocation } from "react-router-dom";
import { Button } from "react-bootstrap";
export default function Navbar() {

    const navigate = useNavigate();
    const location=useLocation();
    var temp=false;
    if(location.pathname=="/" || location.pathname=="/employeelogin"||location.pathname=="/adminlogin")
    {
        temp=true;
    }
    function handleLogout(){
        localStorage.removeItem("empid");
        navigate("/")
    }
    return(
      
        <div className="navbar">
            <div className="navbar-title" onClick={()=>{navigate('/')}} style={{cursor:"pointer"}}>
                <h3 style={{marginRight:'250px'}}>Loan Management</h3>
                {
                   temp?"":<Button onClick={()=>{handleLogout()}}>Logout</Button>
              
                }
                
                
                
                </div>
        </div>
    );
}