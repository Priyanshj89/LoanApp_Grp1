import { Link } from "react-router-dom";
import CustDataEdit from "./custDataEdit";
const CustDataManagement = () => {
    return (
        <div >
            <h1 className="display-1">Customer Data Management</h1>
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