import axios from 'axios';
import { useState } from 'react';
import { Form, Button } from 'semantic-ui-react';

export default function FormValidation() {
    const [empId, setEmpId] = useState(Math.floor(Math.random()*1000000));
    const handleSubmit = async (data) => {
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
        let res= await axios.post('http://localhost:8082/admin/addCustomer', req, {
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*"
            },
        });
        if(res?.status === 200){
            alert('User Created');
            setEmpId(()=>Math.floor(Math.random()*1000000));
        }
        else {
            alert('res.status');
        }
        console.log(req);
    }
    return (
        <div className="row d-flex justify-content-center">
            <Form onSubmit={(event) => handleSubmit(event.target)}>

                <label>Employee ID </label>
                <span>{empId}</span>
                

                <Form.Field>
                    <label>Password</label>
                    <input
                        placeholder='Password'
                        type="password"
                        id='password'
                        {...("password", { required: true })}
                    />
                </Form.Field>

                <Form.Field>
                    <label>Employee Name</label>
                    <input
                        placeholder='Employee Name'
                        type="text"
                        id='name'
                        {...("empName", { required: true, maxLength: 10 })}
                    />
                </Form.Field>
                <Form.Field>
                    <label>Designation</label>
                    <input
                        placeholder='Designation'
                        type="text"
                        id='designation'
                        {...("Designation", { required: true, maxLength: 10 })}
                    />
                </Form.Field>
                <Form.Field>
                    <label>Department</label>
                    <input
                        placeholder='Department'
                        type="text"
                        id='department'
                        {...("Department", { required: true, maxLength: 10 })}
                    />
                </Form.Field>


                <Form.Field>
                    <label>Gender</label>
                    <input
                        placeholder='Gender'
                        type="text"
                        id='gender'
                        {...("Gender", { required: true, maxLength: 1 })}
                        list='genderList'
                    />

                    <datalist id="genderList">
                        <option value='M' />
                        <option value='F' />
                    </datalist>

                </Form.Field>
                <Form.Field>
                    <label>DOB</label>
                    <input
                        placeholder='DOB'
                        type="date"
                        id='dob'
                        {...("DOB", { required: true })}
                    />
                </Form.Field>
                <Form.Field>
                    <label>DOJ</label>
                    <input
                        placeholder='DOJ'
                        type="date"
                        id="doj"
                        {...("DOJ", { required: true })}
                    />
                </Form.Field>

                <Button type='submit'>Submit</Button>
            </Form>
        </div >
    )
}