import React, { useState } from 'react'
import "bootstrap/dist/css/bootstrap.min.css";
import "../styles/HomePage.css"
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import Navbar from './Navbar';
import background from "./download.png";

const HomePage = () => {
    
    return (
        <div className='home' style={{ backgroundImage: `url(${background})`,backgroundSize:"100% 50%",backgroundRepeat: 'no-repeat',height:"100vh",backgroundPositionY:"100%"}}>
            <Navbar/>
            <div className='home-card'>
            <h2>Loan Application Management</h2>
            <h4>Start Your Journey With Us</h4>
            <div className='login-buttons'>
                <Link to='/adminlogin'><button className='prim-btn'>Login As Admin</button></Link>
                <Link to='/employeelogin'><button className='prim-btn'>Login As Employee</button></Link>
            </div>
            </div>
        </div>
    )
}

export default HomePage;