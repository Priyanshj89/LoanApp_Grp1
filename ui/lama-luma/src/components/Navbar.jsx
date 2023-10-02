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
            <div className="navbar-title" onClick={()=>{navigate('/')}} style={{cursor:"pointer",display:"flex"}}>
                <h3 >Loan Management</h3>
                {
                   temp?"":<Button onClick={()=>{handleLogout()}} style={{marginLeft:"55rem",backgroundColor:"rgb(251, 204, 75)",color:"black",fontSize:"14px",borderColor:"rgb(254, 171, 82)"}} >Logout</Button>
              
                }
                
                
                
                </div>
        </div>
    );
}