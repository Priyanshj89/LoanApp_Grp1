import { Link } from "react-router-dom";

const Dashboard = () => {
    return (
        <div>
            <h1>Admin Dashboard</h1>
            <div>
                <Link to ='/admin/dashboard/custDataManagement'><button>Customer Data Management</button></Link>
                <button>Items Master Data</button>
                <button>Loan Card Management</button>
            </div>
        </div>
    )
}
export { Dashboard };