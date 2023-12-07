import "./homePageBodyComponent.css";
import heroImage from "../../assets/heroImage.png"
import CardComponent from "../CardComponent/cardComponet";

const HomePageBodyComponent = () => {
    return (
        <>
        <div className="floating-button">
            <img
            src="/src\components\HomePageBodyComponent\chat.png" // Update with the path to your image
            alt="Custom Image"
            width="70" // Adjust the width and height as needed
            height="70"
        />
        </div>
            <div className="container-fluid rectangle3 pb-5">
                <div className="row mb-5">
                    <div className="col">
                        <img src={heroImage} className="heroImage img-fluid "></img>
                    </div>
                </div>
                <div className="row mb-3  ">
                    <div className="col-12">
                        <CardComponent title={<strong>Purpose</strong>} textContent="Hello! We are the HR Chat bot, your exclusive Workforce Departure Companion. Our mission is to simplify HR termination tasks for you. We're here 24/7 to assist with inquiries, streamline processes, and ensure HR departure operations run smoothly as per schedule. Your trusted Companion, always at your service.
"></CardComponent>
                    </div>
                </div>
                <div className="row">
                    <div className="col-12">
                        <CardComponent title={<strong>Capabilities</strong>} textContent="Helpful in trasferring and removal of the employee details upon their termination by automating the process. Helpful in reviewing the changes made regarding the transfer and removal of the employee details."></CardComponent>
                    </div>
                </div>
            </div>

        </>
    );
}

export default HomePageBodyComponent;