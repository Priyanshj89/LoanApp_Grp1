import './App.css';
import { Routes, Route } from "react-router-dom";
import Login from './login';
import { Dashboard as UserDashboard } from './user/dashboard/dashboard';
import { Dashboard as  AdminDashboard } from './admin/dashboard/dashboard';
import { ApplyLoan } from './user/dashboard/applyLoan';
import { ViewLoan } from './user/dashboard/viewLoan';
import { ViewItemsPurchased } from './user/dashboard/viewTemsPurchased';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/user/dashboard/" element={<UserDashboard />} />
      <Route path="/user/dashboard/applyLoan" element={<ApplyLoan />} />
      <Route path="/user/dashboard/viewLoan" element={<ViewLoan />} />
      <Route path="/user/dashboard/viewItemsPurchased" element={<ViewItemsPurchased />} />
      <Route path="/admin/dashboard/" element={<AdminDashboard />} >
      </Route>
      {/* <Route  path="/" element={<Login />}/> */}

    </Routes>
  );
}

export default App;
