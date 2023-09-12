import { Link } from "react-router-dom";

const Dashboard = () => {
    return (
        <div>
            <h1 className="display-1">Admin Dashboard</h1>
            <div>
                <Link to ='/admin/dashboard/custDataManagement'><button className="btn btn-primary btn-lg">Customer Data Management</button></Link>
                <button className="btn btn-primary btn-lg">Items Master Data</button>
                <button className="btn btn-primary btn-lg">Loan Card Management</button>
            </div>
        </div>
    )
}
export { Dashboard };