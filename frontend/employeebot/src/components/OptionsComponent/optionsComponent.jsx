import "./optionsComponent.css";
import { Link } from "react-router-dom";
const OptionsComponent = () => {
    return (
        <>
            <div className="row">
                <div className="col rectangle2 d-flex p-2">
                    <Link to={"/home"} style={{ textDecoration: "none", color: "black" }} className="ms-auto me-5"><span >About</span></Link>
                    <Link to={"/team"} className="me-5" style={{ textDecoration: "none", color: "black" }}><span >Team</span></Link>
                    <Link to={"/documentation"} className="me-5" style={{ textDecoration: "none", color: "black" }}><span >Guide</span></Link>
                    <Link to={"/chatbot"} className="me-auto" style={{ textDecoration: "none", color: "black" }}><span >Chatbot</span></Link>
                </div>
            </div >
        </>
    );
}
export default OptionsComponent;