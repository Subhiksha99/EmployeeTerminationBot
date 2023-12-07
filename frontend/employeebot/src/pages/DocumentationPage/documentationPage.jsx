import React, { useRef, useEffect, useState } from "react";
import FooterComponent from "../../components/FooterComponent/footerComponent";
import HomePageBodyComponent from "../../components/HomePageBodyComponent/homePageBodyComponent";
import NavBarComponent from "../../components/NavbarComponent/navbarComponent";
import './documentationPage.css';

const Documentation = () => {
  return (
    <><NavBarComponent />
      <div className="documentation-container">
        <h2 className="documentation-h2">Guide</h2>
        <h4 className="documentation-h4">This section provides detailed descriptions of various functionalities and features of our application. User stories helped us understand the needs and requirements of our users, enabling us to create a better user experience.</h4>
        <h4 className="documentation-h4">For the Purpose of Designing our Workforce Departure Companion ChatBot, we have defined our User Stories in such a way that it is in the subcontext of the HR using our ChatBot</h4>

        <h2 className="documentation-h2">Problem Statement</h2>
        <h4 className="documentation-h4">Purpose of building this ChatBot is to facilitate the easy departure of employees who are being terminated from the company. </h4>
        <h4 className="documentation-h4">We designed a Bot like application, that Remove or Transfers employee details from various HR systems post last working day of employee once the resignation is accepted in the system.
        </h4>

        <h2 className="documentation-h2">BOT Features</h2>
        <div className="user-story">
          <h3 className="documentation-h3">Terminating an Employee</h3>
          <h4 className="documentation-h4">
            1. Initiate the termination process for an employee.
          </h4>
          <h4 className="documentation-h4">
            2. Provide necessary details such as termination date, and cause of termination.
          </h4>
          <h4 className="documentation-h4">
            3. Generate termination letters and notifications.
          </h4>
          <h3 className="documentation-h3">Transferring an Employee</h3>
          <h4 className="documentation-h4">
            1. Process the transfer of an employee from one department to the other department.
          </h4>
          <h4 className="documentation-h4">
            2. Define the role of the employee being transferred to the new department.
          </h4>
          <h3 className="documentation-h3">Reviewing Status</h3>
          <h4 className="documentation-h4">
            1. Retrieve and display information about a departing employee's and employees leaving from the company.
          </h4>
          <h4 className="documentation-h4">
            2. View the termination timeline and related documentation.
          </h4>

        </div>
        <h2 className="documentation-h2">User Guide</h2>
        <div className="user-story">
          <h3 className="documentation-h3">Getting Started</h3>
          <h4 className="documentation-h4">
            1. Log in using credentials sent by the Admin to the email.
          </h4>
          <h4 className="documentation-h4">
            2. Get familiar with the chatbot's commands and capabilities.
          </h4>
          <h3 className="documentation-h3">Terminating an Employee</h3>
          <h4 className="documentation-h4">
            1. Initiate a conversation with the chatbot.
          </h4>
          <h4 className="documentation-h4">
            2. Select the "Terminate Employee" option.
          </h4>
          <h4 className="documentation-h4">
            3. Follow the prompts to provide necessary information for termination.
          </h4>
          <h4 className="documentation-h4">
            4. Confirm and review the details before finalizing the termination process.
          </h4>
          <h3 className="documentation-h3">Transferring an Employee</h3>
          <h4 className="documentation-h4">
            1. Initiate a conversation with the chatbot.
          </h4>
          <h4 className="documentation-h4">
            2. Select the "Transfer Employee" option.
          </h4>
          <h4 className="documentation-h4">
            3. Provide information about the transfer, including the recipient's details.
          </h4>
          <h4 className="documentation-h4">
            4. Confirm and review the transfer details before proceeding.
          </h4>
          <h3 className="documentation-h3">Reviewing Changes Status</h3>
          <h4 className="documentation-h4">
            1. Initiate a conversation with the chatbot.
          </h4>
          <h4 className="documentation-h4">
            2. Select the "Review Changes" option.
          </h4>
          <h4 className="documentation-h4">
            3. Provide the employee's name or unique identifier.
          </h4>
          <h4 className="documentation-h4">
            4. Receive a summary of the employee's status, including their termination timeline and documentation.
          </h4>
          <h4 className="documentation-h4">
            5. Process Data removal as per the termination date.
          </h4>
        </div>
      </div>
      <FooterComponent />
    </>
  );

};

export default Documentation;