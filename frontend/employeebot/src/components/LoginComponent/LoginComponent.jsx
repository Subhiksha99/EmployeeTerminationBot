import React from 'react';
import { useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import Natwest from "../../assets/natwestImg.png";
import Joi from 'joi-browser';
import "./LoginComponent.css"
const LoginComponent = () => {
    const [user, setUser] = useState({
        corporate_id: "",
        email: "",
        password: "",
    });
    const navigate = useNavigate();
    const [errors, setErrors] = useState({});
    const [message, setMessage] = useState("");

    //Step1:  Define schema to validate email and password
    const schema = {
        corporate_id: Joi.string().required(),
        email: Joi.string().email({ minDomainSegments: 2 }).required(),
        password: Joi.string().min(6).max(30).required(),
    };

    // Step 2: Validate
    const validate = () => {
        const errors = {}; //object type local variable
        const result = Joi.validate(user, schema, {
            abortEarly: false,
        });
        console.log(result);
        // setting error messages to error properties
        // ex: errors[username] = "username is required";
        // ex: errors[password] = "password is required";
        if (result.error != null)
            for (let item of result.error.details) {
                errors[item.path[0]] = item.message;
            }
        return Object.keys(errors).length === 0 ? null : errors;
    };

    const handleChange = (event) => {
        let newUser = { ...user };
        newUser[event.target.name] = event.target.value;
        console.log(event.target.value);
        setUser(newUser);
    };
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log("user:", user);
        setErrors(validate());
        if (errors != null) return;
        axios.post("http://localhost:3000/user/login", JSON.stringify(user),
            {
                headers: {
                    'accept': '*/*',
                    'Content-Type': 'application/json',
                    'token': "",
                }
            }
        )
            .then((res) => {
                console.log(res);
                const token = res.headers["token"];
                console.log(token)
                localStorage.setItem('token', token);
                if (res.data.email === "admin@example.com") {
                    //admin login
                    //redirect to admin page
                    navigate("/admin");
                }
                else if (res.data.firstTimeLoggedIn) {
                    console.log(" first time login success");
                    //trigger reset password
                    navigate("/reset");
                }
                else {
                    localStorage.setItem("user-detail", res.data);
                    //navigate to home page
                    navigate("/home");
                }
            })
            .catch((err) => {
                console.log(err);
                if (err.responce) {
                    setMessage(err.responce.data.message);
                }
                else {
                    setMessage(err.message);
                }
                console.log(err.responce.data.message);
            })
    };
    return (
        <>
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
                                        <h4 className='mb-3'>Enter Your Credential</h4>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="form3Example3">Corporate Id</label>
                                            <input type="text" id="form3Example3" class="form-control" name="corporate_id" onChange={handleChange} />
                                            <small style={{ color: "red" }}>{errors && errors.corporate_id}</small>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="form3Example3">Email address</label>
                                            <input type="email" id="form3Example3" class="form-control" name="email" onChange={handleChange} />
                                            <small style={{ color: "red" }}>{errors && errors.email}</small>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="form3Example4">Password</label>
                                            <input type="password" id="form3Example4" class="form-control" name="password" onChange={handleChange} />
                                            <small style={{ color: "red" }}>{errors && errors.password}</small>
                                        </div>
                                        Forgot password? <Link to="/reset">Reset Password</Link><br />
                                        <button type="submit" class="btn btn-primary btn-block mb-4 mt-3">
                                            Login
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div >
        </>
    );
}

export default LoginComponent;