/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { useRef, useEffect, useState } from "react";
import "./teamPage.css"; // Import the CSS file
import FooterComponent from "../../components/FooterComponent/footerComponent";
import HomePageBodyComponent from "../../components/HomePageBodyComponent/homePageBodyComponent";
import NavBarComponent from "../../components/NavbarComponent/navbarComponent";
import Abinav from "../../assets/NIK_9847_11zon.jpg";
import siva from "../../assets/siva.png";
import divya from "../../assets/divya.jpeg";
import subi from "../../assets/subhi.png"
function Team() {
  const HomePage = () => {
    return (
      <>
        <HomePageBodyComponent />
        <NavBarComponent />
        <FooterComponent />
      </>
    );
  }

  const message = `As a part of our Capstone Project, we've developed this Workforce Departure Companion Bot which facilitates ease of removal and departure of employees leaving or resigning from the company.`;
  const [scrollDirection, setScrollDirection] = useState(1);

  const teamMembers = [
    {
      name: "Abhinav Siddharth",
      role: "IIIT Delhi",
      imageSrc: Abinav,
    },
    {
      name: "Kollu Siva Sai",
      role: "MIT Manipal",
      imageSrc: siva,
    },
    {
      name: "Divya Amruthavalli",
      role: "VIT Amravati",
      imageSrc: divya,
    },
    {
      name: "Subhikhsha",
      role: "MIT Chennai",
      imageSrc: subi,
    },
  ];

  const containerRef = useRef(null);

  // Function to scroll the container automatically
  const scrollAutomatically = () => {
    const container = containerRef.current;

    // Calculate the total width of all team member cards
    const totalWidth = teamMembers.length * 400; // Adjust 400 to your card width

    // Calculate the distance to scroll in each step
    const scrollStep = 2; // Adjust the scroll step as needed

    // Scroll to the right by the scrollStep
    container.scrollLeft += scrollStep * scrollDirection;

    // If scrolled to the right end, change direction to left
    if (container.scrollLeft + container.clientWidth >= totalWidth) {
      setScrollDirection(-1);
    }

    // If scrolled to the left end, change direction to right
    if (container.scrollLeft <= 0) {
      setScrollDirection(1);
    }
  };

  // Start automatic scrolling when the component mounts
  useEffect(() => {
    const intervalId = setInterval(scrollAutomatically, 20); // Adjust the interval as needed
    return () => clearInterval(intervalId); // Clean up the interval on component unmount
  }, []);




  return (<><NavBarComponent />
    <section className="section-white">
      <div className="container">
        <div className="row">
          <div className="col-md-12 text-center">
            <h2 className="section-title">The Team Behind</h2>
            <h1>Workforce Companion Bot</h1>
            <h4 className="section-subtitle">{message}</h4>
          </div>

          {/* Render team members */}
          <div className="team-members-container-horizontal"
            ref={containerRef}>
            {teamMembers.map((member, index) => (
              <div className="col-sm-6 col-md-4" key={index}>
                <div className="team-item">
                  <img src={member.imageSrc} className="team-img" alt="pic" />
                  <h3>{member.name}</h3>
                  <div className="team-info">
                    <p className="team-description">{member.role}</p>
                  </div>
                  <ul className="team-icon">
                    <li>
                      <a href="#" className="twitter">
                        <i className="fa fa-twitter"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#" className="pinterest">
                        <i className="fa fa-pinterest"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#" className="facebook">
                        <i className="fa fa-facebook"></i>
                      </a>
                    </li>
                    <li>
                      <a href="#" className="dribble">
                        <i className="fa fa-dribbble"></i>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </section>
    <FooterComponent />
  </>);
}

export default Team;
