import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import Natwest from "../../assets/natwestImg.png";
import "./adminComponent.css"
const AdminComponent = () => {
    const [client, setClient] = useState({
        corporate_id: "",
        email: "",
        password: (Math.random() + 1).toString(36).substring(5)
    });
    const handleChange = (event) => {
        let newUser = { ...client };
        newUser[event.target.name] = event.target.value;
        setClient(newUser);
    };
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(client);
        const token = localStorage.getItem("token");
        axios.post("http://localhost:3000/user/sendmail", JSON.stringify(client),
            {
                headers: {
                    'accept': '*/*',
                    'Content-Type': 'application/json',
                    "authentication": token
                }
            }).then(
                (res) => {
                    console.log(res);
                }
            ).catch(
                (err) => { console.log(err); }
            )
    };
    return (<>
        <div className='background-radial-gradient overflow-hidden' style={{ height: "100%", width: "100%" }}>
            <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
                <div class="row gx-lg-5 align-items-center mb-5">
                    <div class="col-lg-6 mb-5 mb-lg-0" style={{ zIndex: "10" }}>
                        <h1 class="my-5 display-5 fw-bold ls-tight" style={{ color: "hsl(218, 81%, 95%)" }}>
                            WorkForce Departure Companion<br />
                            <span style={{ color: "hsl(218, 81%, 75%)" }}>Termination Bot</span>
                        </h1>
                        <p class="mb-4 opacity-70" style={{ color: "hsl(218, 81%, 85%)", fontWeight: "400", fontSize: 20 }}>
                            Hello! We are the Workforce Departure Companion, your exclusive Workforce Departure Companion. Our mission is to simplify HR termination tasks for you. We're here 24/7 to assist with inquiries, streamline processes, and ensure HR departure operations run smoothly as per schedule. Your trusted Companion, always at your service.<br />
                        </p>
                    </div>

                    <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                        <div class="card bg-glass">
                            <div class="card-body px-4 py-5 px-md-5">
                                <form className='' onSubmit={handleSubmit}>
                                    <h4 className='mb-3'>Create an Account for user</h4>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example3">Corporate Id</label>
                                        <input type="text" id="form3Example3" class="form-control" name="corporate_id" onChange={handleChange} />

                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example3">Email address</label>
                                        <input type="email" id="form3Example3" class="form-control" name="email" onChange={handleChange} />

                                    </div>
                                    <Link to="/">Back to Login</Link><br />
                                    <button type="submit" class="btn btn-primary btn-block mb-4 mt-3">
                                        Send a credential to user
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div >
    </>);
}

export default AdminComponent;