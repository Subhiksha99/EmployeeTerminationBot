import axios from 'axios';
import React from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import "./reviewstyle.css";

const EmployeeList = () => {
    const user = { employeeId: "", terminationDate: "" };
    const [userList, setUserList] = useState([])
    useEffect(() => {
        //get employee
        axios.get("http://localhost:8081/flags/all", {
            headers: {
                'accept': '*/*',
                'Content-Type': 'application/json'
            }
        })
            .then((res) => {
                console.log(res);
                let arr = res.data;
                console.log(arr);
                setUserList(arr);
            }).catch((err) => { console.log(err) });


    }, [])
    return (
        <>{userList && <ul className="list-group shadow emp-list">
            {userList.map(c => (<li className="list-group-item" key={c.employeeId}>Employee Id: {c.employeeId}<br />Termination Date:{c.terminationDate}</li>))}
        </ul>}</>
    );
}

export default EmployeeList;