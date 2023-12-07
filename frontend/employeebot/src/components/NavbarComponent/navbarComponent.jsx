import { useState } from "react";
import "./navbarComponent.css"
import bot from '../../assets/bot.gif';
import logo from '../../assets/Logo.png';
import adminSettingsMale from '../../assets/AdminSettingsMale.png';
import logout from '../../assets/Logout.png';
import { IconButton } from "@mui/material";
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import OptionsComponent from "../OptionsComponent/optionsComponent";
import { Link } from "react-router-dom";

const NavBarComponent = () => {
    const [isOpen, setIsOpen] = useState(false);
    const toggleDropdown = () => {
        setIsOpen(!isOpen);
    }
    return (
        <>
            <div className="container-fluid nav-container">
                <div className="row rectangle">
                    <div className="col d-flex justify-content-between align-items-center">
                        <div className="d-flex flex-column align-items-center" >
                            <img src={logo} className="logo img-fluid"></img>
                            <p className="companyName">Natwest Group</p>
                        </div>
                        <div className="d-sm-flex align-items-center m-2">
                            <p className="title">Workforce Departure Companion</p>
                            <img src={bot} className="botGif d-none d-sm-block img-fluid pb-4 "></img>
                        </div>
                        <div className="m-2">
                            <IconButton className='profile-icon' onClick={toggleDropdown}>
                                <AccountCircleIcon style={{ color: 'black', width: 50, height: 50 }} />
                                {isOpen && (
                                    <div className='d-flex flex-column dropdown-content p-1'>
                                        <Link to='/profile' className='link mt-3 mb-2'><img src={adminSettingsMale} className="admin-profile-icon img-fluid"></img>Profile</Link><hr className='hr' />
                                        <Link to='/logout' className='link mb-3'><img src={logout} className="logout-icon img-fluid"></img>Logout</Link>
                                    </div>
                                )}
                            </IconButton>
                        </div>
                    </div>
                </div>
                <OptionsComponent />
            </div>
        </>
    );
}

export default NavBarComponent;