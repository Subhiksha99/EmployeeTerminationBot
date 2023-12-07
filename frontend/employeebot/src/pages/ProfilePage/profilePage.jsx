import "./profilePage.css"
import ProfilePageNavBarComponent from "../../components/NavbarComponent/ProfilePageNavBarComponent";
import ProfileComponent from "../../components/ProfileComponent/profileComponent";
import FooterComponent from "../../components/FooterComponent/footerComponent";

const Profile = () => {
    return (
        <>
            <ProfilePageNavBarComponent />
            <ProfileComponent />
        </>
    );
}

export default Profile;