import { Link } from "react-router-dom";
import CustDataEdit from "./custDataEdit";
import Navbar from "../../../components/Navbar"
const CustDataManagement = () => {
    return (
        <div >
            <Navbar/>
            <h4 className="display-1">Customer Data Management</h4>
            <br />
            <div >
                <p>
                    <Link to='/admin/dashboard/custDataManagement/add'><button className='btn btn-primary btn-lg'>Add Employee</button></Link>
                    <CustDataEdit />
                </p>
            </div>
        </div>
    )
}
export default CustDataManagement;