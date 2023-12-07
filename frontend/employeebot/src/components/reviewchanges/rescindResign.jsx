import axios from 'axios';
import React from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import Employee from '../../services/Employee';
import "./reviewstyle.css";

const RescindedResignation = () => {
    const [message, setMessage] = useState("");
    let date = new Date();
    useEffect(() => {
        let mailcontent = {
            "name": Employee.emp.name,
            "terminationDate": date,
            "email": Employee.emp.mail
        }
        axios.post("http://localhost:8081/flags/sendmail/cancel", JSON.stringify(mailcontent), {
            headers: {
                'accept': '*/*',
                'Content-Type': 'application/json'
            }
        }).then((res) => { console.log(res) }).catch((err) => { console.log(err) })
        axios.delete(`http://localhost:8081/flags/deleteById/${Employee.emp.employeeId}`).then((res) => { console.log(res); setMessage("The Employee resignation is cancelled and informed to employee via mail") }).catch((err) => { console.log(err) });
    }, [])
    return (
        <>{message && <div>
            <p className='msg'>{message}</p></div>}
        </>
    );
}

export default RescindedResignation;