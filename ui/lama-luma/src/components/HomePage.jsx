import React, { useState } from 'react'
import "bootstrap/dist/css/bootstrap.min.css";
import "../styles/HomePage.css"
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

const HomePage = () => {
    
    return (
        <div className='home'>
            <h2>Loan Application Management</h2>
            <h4>Start Your Journey With Us</h4>
            <div className='login-buttons'>
                <Link to='/adminlogin' className='btn btn-primary'>Login As Admin</Link>
                <Link to='/employeelogin' className='btn btn-primary'>Login As Employee</Link>
            </div>
        </div>
    )
}

export default HomePage;