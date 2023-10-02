import Navbar from "../../components/Navbar";
import "../../styles/UserDashboard.css"
import "../../styles/EmployeeLogin.css"
import "../../styles/AdminDashboard.css"
import { Link } from "react-router-dom";

const Dashboard = () => {
    return (        
    <div >
        <Navbar/>
        <div className="user-dashboard">
        <h1>User Dashboard</h1>
        <div className="dashboard-card-collection">
        <div className="dashboard-card"><div className="dasboad-card-text"><br/>View your loans here and their respective status.</div><Link to ='/user/dashboard/viewLoan'><button className="dashboard-card-btn">View Your Loans</button></Link></div>
        <div className="dashboard-card"><div className="dasboad-card-text"><br/>Apply loan for particular items existing in system.</div><Link to ='/user/dashboard/applyLoan'><button className="dashboard-card-btn">Apply for a Loan</button></Link></div>
        <div className="dashboard-card"><div className="dasboad-card-text"><br/>View all the items Purchased by you </div> <Link to ='/user/dashboard/viewItemsPurchased'><button className="dashboard-card-btn">View Items Purchased</button></Link></div>
        </div>
        </div>
    </div>);
}
export {Dashboard};