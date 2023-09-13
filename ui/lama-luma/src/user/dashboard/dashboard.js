import Navbar from "../../components/Navbar";
import "../../styles/UserDashboard.css"
import "../../styles/EmployeeLogin.css"
import { Link } from "react-router-dom";

const Dashboard = () => {
<<<<<<< HEAD
    return <div><h1>Employee Dashboard</h1>
    <button>View Loans</button>
    <button>Apply for loans</button>
    <button>View Items purchased</button>
    
    </div>
=======
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
>>>>>>> e3dfb05f238fdc7fdd2875faaeaea3a9babf99b8
}
export {Dashboard};