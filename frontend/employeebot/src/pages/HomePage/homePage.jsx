import "./homePage.css"
import FooterComponent from "../../components/FooterComponent/footerComponent";
import HomePageBodyComponent from "../../components/HomePageBodyComponent/homePageBodyComponent";
import NavBarComponent from "../../components/NavbarComponent/navbarComponent";

const Home = () => {
    return (
        <>
            <NavBarComponent />
            <HomePageBodyComponent />
            <FooterComponent />
        </>
    );
}
export default Home;