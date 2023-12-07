import CheckEmployee from "../../components/checkEmployee";
import Transfer from "../../components/transfer";
import Employee from "../../services/Employee";
import Termination from "../../components/Terminate/termination";
import EmployeeList from "../../components/reviewchanges/employeeList";
import DateChange from "../../components/reviewchanges/dateChange";
import RescindedResignation from "../../components/reviewchanges/rescindResign";
const basicSteps = [
    {
        id: 'welcome',
        message: 'Hello! I am your Workforce Departure Companion! How can I assist you today?',
        trigger: 'mainMenu',
    },
    {
        id: 'mainMenu',
        message: 'Please Select Either of the Options',
        trigger: 'mainMenuOptions',
    },
    {
        id: 'mainMenuOptions',
        options: [
            { value: 'Review Changes', label: 'Review Changes', trigger: 'Review Changes' },
            { value: 'Terminating Employees', label: 'Terminating Employees', trigger: 'Terminating Employees' },
            { value: 'Tranferring Employees', label: 'Transferring Employees', trigger: 'Tranferring Employees' },
        ],
    },
    //First 3 Main Menu Options
    {
        id: 'Terminating Employees',
        message: 'Can you Provide me with the Employee ID',
        trigger: 'User Shares EmployeeID Terminating',
    },
    {
        id: 'User Shares EmployeeID Terminating',
        user: true,
        trigger: 'Checking Employee Exists Terminating',
    },
    {
        id: 'Checking Employee Exists Terminating',
        //message: 'Add Component to Check whether Employee Exists in the Backend Database',
        component: <CheckEmployee />,
        trigger: 'Termination Cause Message',
    },
    {
        id: 'Termination Cause Message',
        message: 'Can you Provide me the Cause of Termination of this Employee',
        trigger: 'Termination Cause Trigger',
    },
    {
        id: 'Termination Cause Trigger',
        options: [
            { value: 'Resignation', label: 'Resignation', trigger: 'Resignation Documentation' },
            { value: 'Layoffs', label: 'Layoffs', trigger: 'Layoffs Documentation' },
            { value: 'Other Causes', label: 'Other Causes', trigger: 'Bot Asks Other Cause of Termination' },
        ]
    },
    {
        id: 'Bot Asks Other Cause of Termination',
        message: 'Please Share the Concerned Cause of Termination of this Employee.',
        trigger: 'User Shares Cause of Termination',
    },
    {
        id: 'User Shares Cause of Termination',
        user: true,
        trigger: 'Other Causes Documentation',
    },

    {
        id: 'Other Causes Documentation',
        message: "Cause of the Employee Termination is because of {previousValue}! \n Here are the details of the Employee \n 1. Name of the Employee " + Employee.emp.name + " and the Emp-ID" + Employee.emp.employeeId + " \n 2. Cause of Termination:{previousValue}  \n 3. Expected Date of Official Resignation \n Do you want to send process the below Termination Email to the Employee",
        trigger: 'Terminating Email To The Employee Due to Other Causes',
    },
    {
        id: 'Terminating Email To The Employee Due to Other Causes',
        message: "Subject: Termination Notice \n    Dear subhi, \n We regret to inform you that your employment with NatWest group is terminated, effective [Termination Date], as per HR's evaluation of your personal and professional conduct in the office space. We appreciate your contributions and will provide support during this transition. For further details, please contact HR. \n Sincerely, \n HR Team",
        trigger: 'Data Removal?',
    },
    {
        id: 'Layoffs Documentation',
        message: 'Cause of the Employee Termination is Layoffs',
        trigger: 'Display Employee Details Layoffs',
    },
    {
        id: 'Display Employee Details Layoffs',
        message: "1. Name of the Employee: " + Employee.emp.name + " and the Emp-ID " + Employee.emp.employeeId + "\n 2. Cause of Termination:Layoff \n 3. Expected Date of Official Resignation \n Do you want to send process the below Termination Email to the Employee",
        trigger: 'Terminating Email To The Employee Due to Layoffs',
    },
    {
        id: 'Terminating Email To The Employee Due to Layoffs',
        message: "Subject: Important Notification Regarding Your Employment \n Dear " + Employee.emp.name + ",\n    I regret to inform you that, due to unforeseen circumstances, we must make the difficult decision to initiate layoffs. Your position has been affected. Our HR team will provide you with all necessary details and support during this transition. We deeply appreciate your contributions. \n Sincerely, \n HR Team",
        trigger: 'Data Removal?',
    },
    {
        id: 'Resignation Documentation',
        message: 'Cause of the Employee Termination is Resignation',
        trigger: 'Display Employee Details Resignation',
    },
    {
        id: 'Display Employee Details Resignation',
        message: "1. Name of the Employee: Subhi \n2.Emp-ID: 71325\n 3. Cause of Termination: Resignation \n 3. Expected Date of Official Resignation:" + new Date().setMonth(new Date().getMonth() + 2) + "\n Do you want to send the below Termination Email to the Employee",
        //component: 
        trigger: 'Terminating Email To The Employee Due to Resignation',
    },
    {
        id: 'Terminating Email To The Employee Due to Resignation',
        message: "Subject: Confirmation of Resignation Processing    \n Dear " + Employee.emp.name + "\nI wanted to confirm that we have received and processed your resignation from Natwest. Your last working day will be on " + new Date().setMonth(new Date().getMonth() + 2) + ". Please let us know if there are any formalities or information you require during this transition. \n     Best regards, \n    HR Team",
        trigger: 'Data Removal?',
    },
    {
        id: 'Data Removal?',
        message: 'Do you want to Process the Data Removal of this Employee right now?',
        trigger: 'Data Removal Options',
    },
    {
        id: 'Data Removal Options',
        options: [
            { value: 'YES', label: 'YES', trigger: 'Flagging Options' },
            { value: 'NO', label: 'NO', trigger: 'mainMenu' },
        ]
    },
    //FLAGGING OPTIONS.
    {
        id: 'Flagging Options',
        message: 'Flagging of relevant details to be removed. \n 1. EmployeeID \n 2. PersonalDB \n 3. EducationDetailsDB \n 4. IssuesDB \n 5. PossessionDB \n 6. ProjectDB',
        trigger: 'Termination Processing to invoke flag',
    },
    {
        id: "Termination Processing to invoke flag",
        component: <Termination />,
        trigger: "Termination Processing after Flagging",
    },
    {
        id: 'Termination Processing after Flagging',
        message: "The Flagged Details are removed from the database. \n The Concerned Employee's Termination is now being processed. \n Thank you for using our Chatbot Service. ",
        trigger: 'mainMenu',
    },

    //TRANSFERRING MAIN MENU OPTION

    {
        id: 'Tranferring Employees',
        message: 'Can you Provide me with the Employee ID',
        trigger: 'User Shares EmployeeID Transferring',
    },
    {
        id: 'Share Employee ID Transferring',
        message: 'Can you Provide me with the Employee ID',
        trigger: 'User Shares EmployeeID Transferring',
    },
    {
        id: 'User Shares EmployeeID Transferring',
        user: true,
        trigger: 'Checking Employee Exists Transferring',
    },
    {
        id: 'Checking Employee Exists Transferring',
        // message: 'Add Component to Check whether Employee Exists in the Backend Database',
        component: <CheckEmployee />,
        trigger: 'Department Transferring Message',
    },
    {
        id: 'Department Transferring Message',
        message: 'Please Enter the Department to be transferred of the Employee',
        trigger: 'User Shares Department Transferring Message',
    },
    {
        id: 'User Shares Department Transferring Message',
        user: true,
        trigger: 'Designation Transferring Message',
    },
    {
        id: 'Designation Transferring Message',
        message: 'Please Enter the Designation to be Transferred of the Employee',
        trigger: 'User Shares Designation Transferring Message',
    },
    {
        id: 'User Shares Designation Transferring Message',
        user: true,
        trigger: 'Process the transfer',
    },
    {
        id: "Process the transfer",
        component: <Transfer />,
        trigger: "Transferring Successful Prompt"
    },
    {
        id: 'Transferring Successful Prompt',
        message: "The Concerned Employee's Tranferring is now processed. Thank you for using Our ChatBot Service.",
        trigger: 'mainMenu',
    },
    // REVIEW CHANGES MAIN MENU OPTION
    {
        id: 'Review Changes',
        message: 'Please Select Either of the Below Options',
        trigger: 'Review Changes Options',
    },
    {
        id: 'Review Changes Options',
        options: [
            { value: 'Terminating Employee List', label: 'Terminating Employee List', trigger: 'Display Terminating Employee List Prompt' },
            { value: 'Check Details of a Particular Employee ID?', label: 'Check Details of a Particular Employee ID?', trigger: 'Share Employee ID - Review Changes message' },
        ],
    },
    {
        id: 'Display Terminating Employee List Prompt',
        message: "Here are a List of Employees whose termination is currently being processed",
        trigger: 'Display Terminating Employee List',
    },
    {
        id: 'Display Terminating Employee List',
        //message: "Share Employee List",
        component: <EmployeeList />,
        trigger: 'Share Employee ID - Review Changes message',
    },
    {
        id: 'Check Details Message',
        message: 'Please Check Either of the below options',
        trigger: 'Check Details Message Options',
    },
    {
        id: 'Check Details Message Options',
        options: [
            { value: 'Yes', label: 'Yes', trigger: 'Share Employee ID - Review Changes message' },
            { value: 'No', label: 'No', trigger: 'mainMenu' },
        ],
    },
    {
        id: 'Share Employee ID - Review Changes message',
        message: 'Please enter the EmployeeID of the employee to check his/her details',
        trigger: 'Share Employee ID - Review Changes',
    },
    {
        id: 'Share Employee ID - Review Changes',
        user: true,
        trigger: 'Checking Employee Exists - Review Changes',
    },
    {
        id: 'Checking Employee Exists - Review Changes',
        //message: 'Add Component to Check whether Employee Exists in the Backend Database',
        component: <CheckEmployee />,
        trigger: 'Display Employee Details - Review Changes',
    },
    {
        id: 'Display Employee Details - Review Changes',
        message: "1. Name of the Employee: subhi",
        trigger: 'Review Changes Options message',
    },
    {
        id: "Review Changes Options message",
        options: [
            { value: 'Termination Date changed?', label: 'Termination Date changed?', trigger: 'Termination Date changed?' },
            { value: 'Has the Employee Rescinded Resignation?', label: 'Has the Employee Rescinded Resignation?', trigger: 'Employee Rescinded Resignation?' },
        ],
    },
    {
        id: 'Termination Date changed?',
        message: "Please enter the New Date",
        trigger: "User Shares New Date",
    },
    {
        id: 'User Shares New Date',
        user: true,
        trigger: 'Updating New Termination Date',
    },
    {
        id: 'Updating New Termination Date',
        //message: 'Add Component to update new termination date in the Backend Database',
        component: <DateChange />,
        trigger: 'Updated New Termination Date Message',
    },
    {
        id: "Updated New Termination Date Message",
        message: "Processed the Documentation for the Employee's Resignation. Date is changed to the New Date {previousValue}. \n Thank you for using Our Chatbot Service",
        trigger: 'mainMenu',
    },
    {
        id: 'Employee Rescinded Resignation?',
        message: "Do you want to confirm rescinding the termination of the employee?",
        trigger: "Employee Rescinded Options",
    },
    {
        id: "Employee Rescinded Options",
        options: [
            { value: "Yes", label: 'Yes', trigger: 'Employee Rescinded Resignation Message' },
            { value: 'No', label: 'No', trigger: 'mainMenu' },
        ],
    },
    {
        id: 'Employee Rescinded Resignation Message',
        message: "Sending the below Employee Rescinded Email to the Employee",
        trigger: 'Rescinding Email To The Employee'
    },
    {
        id: 'Rescinding Email To The Employee',
        message: "Rescinding the Termination - Welcome Back \n Dear [Employee Name], \n We are pleased to inform you that the termination of your employment with Natwest, which was previously communicated, has been rescinded. After further review, we have decided to retain your service. \n You are expected to return to work on [Return Date]. Please contact [HR Contact] for further details. \n We appreciate your understanding and look forward to your continued contributions to our team. \n Sincerely, \n HR Team",
        trigger: 'Employee Rescinded Resignation Request',
    },

    {
        id: 'Employee Rescinded Resignation Request',
        component: <RescindedResignation />,
        trigger: 'mainMenu'
    },
];

export default basicSteps;