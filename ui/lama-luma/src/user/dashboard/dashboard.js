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
        <div>
            <Link to ='/user/dashboard/custDataManagement'><button className="prim-btn">View Your Loans</button></Link>
            <button className="prim-btn">Apply for a Loan</button>
            <button className="prim-btn">View Items Purchased</button>
        </div>
        </div>
    </div>);
}
export {Dashboard};