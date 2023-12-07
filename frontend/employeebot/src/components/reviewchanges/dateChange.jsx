import axios from 'axios';
import React from 'react';
import { useEffect } from 'react';
import Employee from '../../services/Employee';
import { useState } from 'react';
import "./reviewstyle.css";

const DateChange = (props) => {
    const [message, setMessage] = useState("");
    useEffect(() => {
        let body = {
            "employeeId": Employee.emp.employeeId,
            "issuesDb": "remove",
            "possessionsDb": "remove",
            "projectsDb": "remove",
            "leavesDb": "remove",
            "educationDetailsDb": "remove",
            "personalDetailsDb": "remove",
            "terminationDate": props.previousStep.message
        }
        axios.put("http://localhost:8081/flags/update", JSON.stringify(body), {
            headers: {
                'accept': '*/*',
                'Content-Type': 'application/json'
            }
        }).then((res) => { console.log(res); setMessage("The Termination date has changed to " + props.previousStep.message) })
            .catch((err) => { console.log(err) });
    }, [])
    return (
        <>{message && <p className='msg'>{message}</p>}</>
    );
}

export default DateChange;