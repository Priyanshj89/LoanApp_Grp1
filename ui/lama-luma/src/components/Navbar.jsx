import "../styles//Navbar.css"
import { useNavigate } from "react-router-dom";

export default function Navbar() {

    const navigate = useNavigate();

    return(
        <div className="navbar">
            <div className="navbar-title" onClick={()=>{navigate('/')}} style={{cursor:"pointer"}}>Loan Management</div>
        </div>
    );
}