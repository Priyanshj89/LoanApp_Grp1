import { Link } from "react-router-dom";
import Navbar from "../../components/Navbar";
import"../../styles/AdminDashboard.css"

const Dashboard = () => {
    return (
        <div >
            <Navbar/>
            <div className="admin-dashboard">
            <h1>Admin Dashboard</h1>
            <div className="dashboard-card-collection">
                <div className="dashboard-card"><div className="dasboad-card-text">View, Modify and Add Customers to the Loan Application Management Portal.</div><Link to ='/admin/dashboard/custDataManagement'><button className="dashboard-card-btn">Customer Management</button></Link></div>
                <div className="dashboard-card"><div className="dasboad-card-text">Create new loan for the customer and assign a particular loan for requested item.</div> <Link to= '/admin/dashboard/LoanCardManagement'><button className="dashboard-card-btn">Loan Card Management</button></Link></div>
                <div className="dashboard-card"><div className="dasboad-card-text">Create items for the customer for which he can apply loan for. View existing created items.</div><Link to= '/admin/dashboard/ItemMaster'><button className="dashboard-card-btn">Item Master</button></Link></div>
                
            </div>
            </div>
        </div>
    )
}
export { Dashboard };