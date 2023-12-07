import React, { useEffect, useState } from 'react';
import axios from 'axios';
import EmployeeNotFound from './EmployeeNotFound';
import Employee from '../services/Employee';
const CheckEmployee = (props) => {
    const [name, setName] = useState("");
    const [user, setUser] = useState({});
    const [error, setError] = useState("");
    useEffect(() => {
        console.log(props);
        setName(props.previousStep.message);
        //axios
        axios.get(`http://localhost:8081/employee/${props.previousStep.message}`)
            .then((res) => {
                console.log(res);
                setUser(res.data);
                console.log(user);
            }).catch((err) => {
                console.log(err)
                if (err.response) {
                    setError(err.response.data.message);
                }
            })
    }, [])
    return (
        <>
            {user &&
                <div>
                    <div className="container">
                        <div className="card">
                            <div className="card-header">Employee Details</div>
                            <div className="card-body rounded-3">
                                <div style={{ backgroundColor: "#DFCCFB", color: "#333", padding: "20px" }}>
                                    <p><strong>Employee ID:</strong> {user.employeeId}</p>
                                    <p><strong>Name:</strong> {user.name}</p>
                                    <p><strong>Team:</strong> {user.team}</p>
                                    <p><strong>Role:</strong> {user.role}</p>
                                    <p><strong>Status:</strong> {user.status}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <p>{Employee.addEmployee(user)}</p>
                </div >
            }
            {
                error && <EmployeeNotFound cause={error} />
            }
        </>
    );
}

export default CheckEmployee;

/*import { useEffect, useState } from 'react';
import axios from 'axios';
import EmployeeNotFound from './EmployeeNotFound';
import Employee from '../services/Employee';
import 
const CheckEmployee = (props) => {
    const [name, setName] = useState("");
    const [user, setUser] = useState({});
    const [error, setError] = useState("");
    useEffect(() => {
        console.log(props);
        setName(props.previousStep.message);
        //axios
        axios.get(`http://localhost:8081/employee/${props.previousStep.message}`)
            .then((res) => {
                console.log(res);
                setUser(res.data);
                console.log(user);
            }).catch((err) => {
                console.log(err)
                if (err.response) {
                    setError(err.response.data.message);
                }
            })
    }, [])
    return (
        <>
            {user &&
                <div>
                    <div className="container">
                        <div className="card">
                            <div className="card-header">Employee Details</div>
                            <div className="card-body rounded-3">
                                <div>
                                    <p><strong>Employee ID:</strong> {user.employeeId}</p>
                                    <p><strong>Name:</strong> {user.name}</p>
                                    <p><strong>Team:</strong> {user.team}</p>
                                    <p><strong>Role:</strong> {user.role}</p>
                                    <p><strong>Status:</strong> {user.status}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <p>{Employee.addEmployee(user)}</p>
                </div >
            }
            {
                error && <EmployeeNotFound cause={error} />
            }
        </>
    );
}

export default CheckEmployee;*/