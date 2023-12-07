import "./logOutPageNavBarComponent.css"
import logo from '../../assets/Logo.png'
import Login from "@mui/icons-material/Login"
import { IconButton } from "@mui/material"
import { Link } from "react-router-dom";

const LogOutPageNavBarComponent = () => {
    return (
        <>
            <div className="container-fluid">
                <div className="row rectangle">
                    <div className="col d-flex justify-content-between align-items-center">
                        <div className="d-flex flex-column align-items-center p-2" >
                            <img src={logo} className="logo img-fluid"></img>
                            <p className="companyName">Natwest Group</p>
                        </div>
                        <div className="m-2">
                            <p className="title">Workforce Departure Companion</p>
                        </div>
                        <div className="m-2">
                            <IconButton component={Link} to='/'>
                                <Login style={{ color: 'black', width: 50, height: 50 }} />
                            </IconButton>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default LogOutPageNavBarComponent;