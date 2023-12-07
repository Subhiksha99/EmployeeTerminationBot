import "./resetPasswordComponent.css"
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import Joi from 'joi-browser';
import Natwest from "../../assets/natwestImg.png";

const ResetPasswordComponent = () => {
    const [userPwd, setUserPwd] = useState({
        email: "",
        password: "",
        crmpassword: ""
    });
    const [errors, setErrors] = useState({});
    const navigate = useNavigate();
    const schema = {
        email: Joi.string().email().required(),
        password: Joi.string().min(6).max(30).required(),
        crmpassword: Joi.any().valid(Joi.ref('password')).required().options({ language: { any: { allowOnly: 'must match password' } } })
    };
    const validate = () => {
        const errors = {}; //object type local variable
        const result = Joi.validate(userPwd, schema, {
            abortEarly: false,
        });
        console.log(result);
        if (result.error != null)
            for (let item of result.error.details) {
                errors[item.path[0]] = item.message;
            }
        return Object.keys(errors).length === 0 ? null : errors;
    };
    const handleChange = (event) => {
        let newUser = { ...userPwd };
        newUser[event.target.name] = event.target.value;
        console.log(event.target.value);
        setUserPwd(newUser);
    };
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(userPwd);
        setErrors(validate());
        if (errors != null) return;
        const token = localStorage.getItem("token");
        console.log(token);
        //update password and fist logged in
        axios.patch("http://localhost:3000/user/update/password", JSON.stringify(userPwd), {
            headers: {
                'accept': '*/*',
                'Content-Type': 'application/json',
                "authentication": token
            }
        }, { withCredentials: true }).
            then((res) => {
                console.log(res);
                navigate("/home");
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
                                    <h4 className='mb-3'>Reset password</h4>
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
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example4">Confirm Password</label>
                                        <input type="password" id="form3Example4" class="form-control" name="crmpassword" onChange={handleChange} />
                                        <small style={{ color: "red" }}>{errors && errors.crmpassword}</small>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-block mb-4 mt-3">
                                        Reset Password
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

export default ResetPasswordComponent;