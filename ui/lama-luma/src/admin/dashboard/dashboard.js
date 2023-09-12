import { Button } from "react-bootstrap";

const Dashboard = () => {
    return <div className="adminDashboard">
        <h1>Admin Dashboard</h1>
        <Button style={{marginLeft:'150px',marginTop:'200px'}}>Customer data Management</Button>

        <Button style={{marginLeft:'150px',marginTop:'200px'}}>Loan Card Management</Button>
        <Button style={{marginLeft:'150px',marginTop:'200px'}}>Item Master Data</Button>



    </div>
}
export {Dashboard};