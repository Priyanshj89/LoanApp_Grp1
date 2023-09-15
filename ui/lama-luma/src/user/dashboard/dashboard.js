import Navbar from "../../components/Navbar";
import "../../styles/UserDashboard.css"
import "../../styles/EmployeeLogin.css"
import { Link } from "react-router-dom";

const Dashboard = () => {
    return (        
    <div >
        <Navbar/>
        <div className="user-dashboard">
        <h1>User Dashboard</h1>
        <div style={{marginTop:'150px'}}>
            <Link to ='/user/dashboard/viewLoan'><button className="prim-btn" style={{width:'30%'}}>View Your Loans</button></Link>
            <Link to ='/user/dashboard/applyLoan'><button className="prim-btn" style={{width:'25%'}}>Apply for a Loan</button></Link>
            <Link to ='/user/dashboard/viewItemsPurchased'><button className="prim-btn" style={{width:'25%'}}>View Items Purchased</button></Link>
        </div>
        </div>
    </div>);
}
export {Dashboard};