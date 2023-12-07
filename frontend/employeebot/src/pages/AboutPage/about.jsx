import React from 'react';
import "./about.css"
import Vector from "./../../assets/Vector.png"
import { Link } from 'react-router-dom';
import Natwest from "../../assets/natwestImg.png";

const AboutUs = () => {
    return (
        <div className='container-fluid row-properties'>
            <div className="row">
                <div class="col-lg-6 col-md-6">
                    <img className="img-fluid" style={{ height: "70%", width: "70%", alignContent: "center", marginTop: "10%", marginLeft: "20%" }} src={Natwest} />
                    <center>
                        <h1>Natwest</h1>
                        <h2>Groups</h2>
                    </center>
                </div>
                <div class="col-lg-6">
                    <div style={{ color: '#C3BE4E', fontSize: 64, fontWeight: '500', wordWrap: 'break-word', paddingTop: "10%" }}>
                        About Us
                    </div>
                    <div style={{ color: '#D5E5F1', fontSize: 30, wordWrap: 'break-word', marginRight: "5%" }} className='p-2'>
                        Hello! We are the Workforce Termination Companion, your exclusive Workforce Departure Companion. Our mission is to simplify HR termination tasks for you. We're here 24/7 to assist with inquiries, streamline processes, and ensure HR departure operations run smoothly as per schedule. Your trusted Companion, always at your service.<br />
                        <Link to="/login"><img src={Vector} className="float-end" /></Link>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AboutUs;