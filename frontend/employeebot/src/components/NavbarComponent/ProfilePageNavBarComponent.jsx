import "./ProfilePageNavBarComponent.css"
import bot from '../../assets/bot.gif';
import logo from '../../assets/Logo.png';
import { IconButton } from "@mui/material";
import KeyboardBackspaceIcon from '@mui/icons-material/KeyboardBackspace';
import { Link } from "react-router-dom";

const ProfilePageNavBarComponent = () => {
    return (
        <>
            <div className="container-fluid">
                <div className="row rectangle">
                    <div className="col d-flex justify-content-between align-items-center">
                        <div className="d-flex flex-column align-items-center p-2" >
                            <img src={logo} className="logo img-fluid"></img>
                            <p className="companyName">Natwest Group</p>
                        </div>
                        <div className="d-sm-flex align-items-center m-2">
                            <p className="title">Workforce Departure Companion</p>
                            <img src={bot} className="botGif d-none d-sm-block img-fluid pb-4 "></img>
                        </div>
                        <div className="m-2">
                            <IconButton component={Link} to={`/home`}>
                                <KeyboardBackspaceIcon sx={{ color: '#FFFFFF', width: 30, height: 30 }} />
                            </IconButton>
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col rectangle2 d-flex p-2">
                        <span className="ms-auto me-5">About</span>
                        <span className="me-5">Team</span>
                        <span className="me-5">Documentation</span>
                        <span className="me-auto">Chatbot</span>
                    </div>
                </div>
            </div>
        </>
    );
}

export default ProfilePageNavBarComponent;