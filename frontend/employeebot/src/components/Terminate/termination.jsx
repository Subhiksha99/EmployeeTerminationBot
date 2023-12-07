import axios from 'axios';
import React from 'react';
import { useEffect } from 'react';
import Employee from '../../services/Employee';
import { useState } from 'react';
import './terminatestyle.css'

const Termination = (props) => {
    const [message, setMessage] = useState("");
    useEffect(() => {
        //console.log(props.state);
        let id = Employee.emp.employeeId;
        let date = new Date();
        date = date.setMonth(new Date().getMonth() + 2)
        let body = {
            "employeeId": id,
            "issuesDb": "remove",
            "possessionsDb": "remove",
            "projectsDb": "remove",
            "leavesDb": "remove",
            "educationDetailsDb": "remove",
            "personalDetailsDb": "remove",
            "terminationDate": date
        }
        let mailcontent = {
            "name": Employee.emp.name,
            "terminationDate": date,
            "email": Employee.emp.mail
        }
        axios.post("http://localhost:8081/flags/sendmail", JSON.stringify(mailcontent), {
            headers: {
                'accept': '*/*',
                'Content-Type': 'application/json'
            }
        }).then((res) => { console.log(res) }).catch((err) => { console.log(err) })
        axios.post("http://localhost:8081/flags/add", JSON.stringify(body), {
            headers: {
                'accept': '*/*',
                'Content-Type': 'application/json'
            }
        }).then(
            (res) => {
                console.log(res);
                setMessage("The flagging is done.The Employee details will be removed upon termination date.The Resignation mail is sent to the employee");
            }
        ).catch(
            (err) => {
                console.log(err);
            }
        );
    }, [])
    return (
        <>
            {message && <p className='msg'>{message}</p>}
        </>
    );
}

export default Termination;