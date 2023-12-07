import bot from '../../assets/bot.gif';
import LogOutPageNavBarComponent from "../../components/LogOutPageNavBarComponent/logOutPageNavBarComponent";
import './logOutPage.css'


const LogOut = () => {
    return (
        <>
            <LogOutPageNavBarComponent />
            <div className="container-fluid p-1" style={{ backgroundColor: "#C4D9C4" }}>
                <div className="row my-auto py-5" >
                    <div className="col-12 col-lg-7 my-auto">
                        <div className="card rounded-5 m-5" style={{ backgroundColor: "#D9D9D9" }}>
                            <div className="card-body p-4 ">
                                <p className="card-text logOutContent ">You have been successfully Logged out.Feel free to visit once again to use my services. I will be serving others during that time.</p>
                            </div>
                        </div>
                    </div>
                    <div className="col-12 col-lg-5 my-auto pb-5 text-center">
                        <img src={bot} className="logOutBotGif img-fluid "></img>
                    </div>
                </div>
                <br />
                <br />
                <br />
            </div>
        </>
    );
}

export default LogOut;