import { Link } from "react-router-dom";
import Navbar from "../../components/Navbar";
import "../../styles/AdminLogin.css"
import"../../styles/AdminDashboard.css"

const Dashboard = () => {
    return (
        <div >
            <Navbar/>
            <div className="admin-dashboard">
            <h1>Admin Dashboard</h1>
            <div>
                <Link to ='/admin/dashboard/custDataManagement'><button className="prim-btn">Customer Data Management</button></Link>
                <Link to ='/admin/dashboard/itemMaster'><button className="prim-btn">Items Master Data</button></Link>
                <button className="prim-btn">Loan Card Management</button>
            </div>
            </div>
        </div>
    )
}
export { Dashboard };