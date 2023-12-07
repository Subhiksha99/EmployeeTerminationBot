/*import "./chatBotPage.css"
const ChatBot = () => {
    return ( 
        <>
        
        </>
     );
}
 
export default ChatBot;*/
import React, { Component } from 'react';
import ChatBot from 'react-simple-chatbot';
import './chatBotPage.css';
import basicSteps from './complexSteps';
import NavBarComponent from '../../components/NavbarComponent/navbarComponent';
import FooterComponent from '../../components/FooterComponent/footerComponent';
import OptionsComponent from '../../components/OptionsComponent/optionsComponent';

const steps = basicSteps;

class ChatBotPage extends Component {
    render() {
        return (

            <div className='bg-dark-subtle'>
                <NavBarComponent></NavBarComponent>
                <div className='container p-5'>
                    <div className='mx-auto'>
                        <ChatBot steps={steps} />
                    </div>
                </div>
            </div>
        )
    }
}

export default ChatBotPage;