import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

import Login from './pages/LoginPage/loginPage'
import Admin from './pages/AdminPage/adminPage'
import ResetPassword from './pages/ResetPasswordPage/resetPasswordPage'
import Home from './pages/HomePage/homePage'
import LogOut from './pages/LogOutPage/logOutPage'
import ChatBot from './pages/ChatBotPage/chatBotPage'
import Documentation from './pages/DocumentationPage/documentationPage'
import Profile from './pages/ProfilePage/profilePage'
import Team from './pages/TeamPage/teamPage'
import AboutUs from './pages/AboutPage/about'

function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' exact element={<Login />} />,
          <Route path='/admin' element={<Admin />} />,
          <Route path='/reset' element={<ResetPassword />} />,
          <Route path='/home' element={<Home />} />,
          <Route path='/chatbot' element={<ChatBot />} />,
          <Route path='/documentation' element={<Documentation />} />,
          <Route path='/profile' element={<Profile />} />,
          <Route path='/team' element={<Team />} />,
          <Route path="/logout" element={<LogOut />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App