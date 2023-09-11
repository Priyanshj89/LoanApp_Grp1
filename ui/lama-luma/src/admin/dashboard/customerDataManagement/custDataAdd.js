import { Axios } from 'axios';
import { Form, Button } from 'semantic-ui-react';

export default function FormValidation() {
    // const { register, handleSubmit, formState: { errors } } = useForm();
    const handleSubmit = (data) => {
        // const req = {

        // }
        // Axios.post()
        console.log(data.value);
    }
    return (
        <div>
            <Form onSubmit={(event) => handleSubmit(event.target.empId)}>

                <Form.Field>
                    <label>Employee ID</label>
                    <input
                        placeholder='Employee ID'
                        type="number"
                        min="0"
                        {...("empId", { required: true })}
                    />
                </Form.Field>

                <Form.Field>
                    <label>Employee Name</label>
                    <input
                        placeholder='Employee Name'
                        type="text"
                        {...("empName", { required: true, maxLength: 10 })}
                    />
                </Form.Field>
                <Form.Field>
                    <label>Designation</label>
                    <input
                        placeholder='Designation'
                        type="text"
                        {...("Designation", { required: true, maxLength: 10 })}
                    />
                </Form.Field>
                <Form.Field>
                    <label>Department</label>
                    <input
                        placeholder='Department'
                        type="text"
                        {...("Department", { required: true, maxLength: 10 })}
                    />
                </Form.Field>


                <Form.Field>
                    <label>Gender</label>
                    <input
                        placeholder='Gender'
                        type="text"
                        {...("Gender", { required: true })}
                        list='genderList'
                    />

                        <datalist id="genderList">
                            <option value='Male' />
                            <option value='Female' />
                            <option value='Other' />
                        </datalist>

                </Form.Field>
                <Form.Field>
                    <label>DOB</label>
                    <input
                        placeholder='DOB'
                        type="date"
                        {...("DOB", { required: true })}
                    />
                </Form.Field>                
                <Form.Field>
                    <label>DOJ</label>
                    <input
                        placeholder='DOJ'
                        type="date"
                        {...("DOJ", { required: true})}
                    />
                </Form.Field>

                <Button type='submit'>Submit</Button>
            </Form>
        </div >
    )
}