import React, { useEffect } from 'react';
import Employee from '../services/Employee';
import axios from 'axios';
import { json } from 'react-router-dom';
import { useState } from 'react';
const Transfer = (props) => {
    const [message, setMessage] = useState("");
    useEffect(() => {
        console.log(props.steps);
        let team = props.steps["User Shares Department Transferring Message"].value;
        let role = props.steps["User Shares Designation Transferring Message"].value;
        Employee.emp.role = role;
        Employee.emp.team = team;
        console.log(team);
        axios.put("http://localhost:8081/employee/update", JSON.stringify(Employee.emp), {
            headers: {
                'accept': '*/*',
                'Content-Type': 'application/json'
            }
        }).then((res) => {
            console.log(res);
            setMessage("The employee is successfully transfered")
        }).catch((err) => { console.log(err) });
    }, [])
    return (
        <>{message && <p style={{ backgroundColor: "rgb(110, 72, 170)", color: "white", marginLeft: "30px", padding: "15px" }}>{message}</p>}</>
    );
}

export default Transfer;