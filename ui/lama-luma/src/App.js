import { Routes, Route } from "react-router-dom";
import { Dashboard as UserDashboard } from './user/dashboard/dashboard';
import { Dashboard as  AdminDashboard } from './admin/dashboard/dashboard';
import { ApplyLoan } from './user/dashboard/applyLoan';
import { ViewLoan } from './user/dashboard/viewLoan';
import { ViewItemsPurchased } from './user/dashboard/viewTemsPurchased';
import HomePage from './components/HomePage';
import EmployeeLogin from "./components/EmployeeLogin";
import AdminPage from './components/AdminLogin';
import CustDataManagement from "./admin/dashboard/customerDataManagement/custDataManagement";
import CustDataAdd from "./admin/dashboard/customerDataManagement/custDataAdd";
import CustDataEdit from "./admin/dashboard/customerDataManagement/custDataEdit";
import LoanCard from "./admin/dashboard/LoanCard"
import ItemMaster from "./admin/dashboard/ItemMaster"

function App() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/user/dashboard/" element={<UserDashboard />} />
      <Route path="/user/dashboard/applyLoan" element={<ApplyLoan />} />
      <Route path="/user/dashboard/viewLoan" element={<ViewLoan />} />
      <Route path="/user/dashboard/viewItemsPurchased" element={<ViewItemsPurchased />} />
      <Route path="/admin/dashboard/" element={<AdminDashboard />} />
      <Route path= '/admin/dashboard/custDataManagement' element={<CustDataManagement />} />
      <Route path= '/admin/dashboard/custDataManagement/add' element ={<CustDataAdd />} />
      <Route path= '/admin/dashboard/custDataManagement/edit' element ={<CustDataEdit />} />
      <Route path="/admin/dashboard/LoanCardManagement" element={<LoanCard/>} />
      <Route path="/admin/dashboard/ItemMaster" element={<ItemMaster/>} />

      <Route path="/employeelogin" element={<EmployeeLogin />} />
      <Route path="/adminlogin" element={<AdminPage />} />
    </Routes>
  );
}

export default App;
