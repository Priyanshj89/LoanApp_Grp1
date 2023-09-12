import { Link } from "react-router-dom";
const CustDataManagement = () => {
    return (
        <div>
            
            <Link to='/admin/dashboard/custDataManagement/add'><button>Add</button></Link>
            <Link to='/admin/dashboard/custDataManagement/edit'><button>Edit</button></Link>
            
        </div>
    )
}
export default CustDataManagement;