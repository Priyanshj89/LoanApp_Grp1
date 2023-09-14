import axios from "axios"
import { useEffect, useState } from "react";

const apiCall = async () => {
    await axios.get('http://localhost:8082/employee/allEmployees', {
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*"
        }
    }).then(res => res);
}

export default function CustDataEdit() {
    const [userData, setUserData] = useState([]);
    useEffect(() => {
        setUserData(async () => await apiCall());
        // setUserData(() => userData?.data);
    }, []);
    let userList;
    if (userData?.status === 200 && userData.size() > 0) userList = userData.data.map((element) => <li key={element.employee_id}> {element}</li>);
    else console.log(userData);
    console.log(userData);
    return <div>{userList}</div>;
}
