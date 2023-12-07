import "./footerComponent.css"
const FooterComponent = () => {
    return (
        <>
            <div className="container-fluid">
                <div className="row p-3" style={{ backgroundColor: "#D9D9D9" }}>
                    <div className="col text-center my-2 footerText">
                        <span className="fw-bold" >Useful Links</span>
                        <ul className="my-2 list-unstyled text-center text-decoration-underline">
                            <li>About</li>
                            <li>Team</li>
                            <li>Documentation</li>
                            <li>Chatbot</li>
                        </ul>
                    </div>
                    <div className="col text-center my-2 footerText">
                        <span className="fw-bold">Contact</span>
                        <ul className="my-2 list-unstyled text-center text-decoration-underline">
                            <li>Email</li>
                        </ul>
                    </div>
                    <div className="col text-center my-2 footerText">
                        <span className="fw-bold">References</span>
                        <ul className="my-2 list-unstyled text-center text-decoration-underline">
                            <li>Github</li>
                            <li>GitLab</li>
                        </ul>
                    </div>
                </div>
            </div>
        </>
    );
}

export default FooterComponent;