import axios from 'axios';
import { useState } from 'react';
import { Form, Button } from 'semantic-ui-react';
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from 'react-router-dom';
import Navbar from '../../../components/Navbar';
import "../../../styles/CustomerData.css"

export default function CustDataAdd() {
    const Navigate = useNavigate();
    const [empId, setEmpId] = useState(Math.floor(Math.random() * 1000000));
    
    const handleSubmit = async (data) => {
        console.log(data);
        const req = {
            'employee_id': empId,
            'name': data.name.value,
            'designation': data.designation.value,
            'dept': data.department.value,
            'gender': data.gender.value,
            'dob': data.dob.value,
            'doj': data.doj.value,
            'password': data.password.value
        }
        let res = await axios.post('http://localhost:8082/admin/addCustomer', req, {
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*"
            },
        });
        if (res?.status === 200) {
            alert('User Created');
            setEmpId(() => Math.floor(Math.random() * 1000000));
            Navigate("/admin/dashboard/custDataManagement");
        }
        else {
            alert('res.status');
        }
        console.log(req);
    }
    return (
        <div>
            <Navbar/>
        <div style={{ display: 'flex', justifyContent: 'center' }} className='addcustomer-card'>
            
            <Form onSubmit={(event) => {
                
                handleSubmit(event.target)
                event.target.reset();
            }}>
                <div style={{display:"flex"}}>
                <div style={{padding:"2rem"}}>
                <label>Employee ID </label>
                <div className="form-control"
                >{empId}</div>


                <Form.Field className='form-group'>
                    <label >Password</label>
                    <input
                        placeholder='Password'
                        type="password"
                        id='password'
                        className="form-control"
                        {...("password", { required: true })}
                    />
                </Form.Field>

                <Form.Field className='form-group'>
                    <label>Employee Name</label>
                    <input
                        placeholder='Employee Name'
                        type="text"
                        id='name'
                        className="form-control"
                        {...("empName", { required: true, maxLength: 10 })}
                    />
                </Form.Field>
                <Form.Field className='form-group'>
                    <label>Designation</label>
                    <input
                        placeholder='Designation'
                        type="text"
                        id='designation'
                        className="form-control"
                        {...("Designation", { required: true, maxLength: 10 })}
                    />
                </Form.Field>
                </div>
                <div style={{paddingTop:"1.4rem"}}>
                <Form.Field className='form-group'>
                    <label>Department</label>
                    <input
                        placeholder='Department'
                        type="text"
                        id='department'
                        className="form-control"
                        {...("Department", { required: true, maxLength: 10 })}
                    />
                </Form.Field>


                <Form.Field className='form-group'>
                    <label>Gender</label>
                    <input
                        placeholder='Gender'
                        type="text"
                        id='gender'
                        className="form-control"
                        {...("Gender", { required: true, maxLength: 1 })}
                        list='genderList'
                    />

                    <datalist id="genderList">
                        <option value='M' />
                        <option value='F' />
                    </datalist>

                </Form.Field>
                <Form.Field className='form-group'>
                    <label>DOB</label>
                    <input
                        placeholder='DOB'
                        type="date"
                        id='dob'
                        className="form-control"
                        {...("DOB", { required: true })}
                    />
                </Form.Field>
                <Form.Field className='form-group'>
                    <label>DOJ</label>
                    <input
                        placeholder='DOJ'
                        type="date"
                        id="doj"
                        className="form-control"
                        {...("DOJ", { required: true })}
                    />
                </Form.Field>
                </div>
                </div>
                <Button type='submit' className='sec-btn'>Submit</Button>
            </Form>
        </div >
        </div>
    )
}