import { useState } from 'react'
import {BrowserRouter, Routes, Route, useNavigate} from 'react-router-dom'
import './TodoApp.css'


export default function TodoApp() {
    return (
        <div className="TodoApp">

        Todo Management application
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<LoginComponent/>}></Route>
                <Route path='/login' element={<LoginComponent/>}></Route>
                <Route path='/welcome' element={<WelcomeComponent/>}></Route>
                <Route path='/*' element={<ErrorComponent/>}></Route>
            </Routes>
        </BrowserRouter>
        </div>
    )
}

function LoginComponent(){

    const [username, setUserName] = useState('Omkar');
    const [password, setpassword] = useState('');
    const [showSuccessMessage, setshowSuccessMessage] = useState(false);
    const [showErrorMessage, setshowErrorMessage] = useState(false);
    const navigate = useNavigate();

    function handleusernameChange(event){
        setUserName(event.target.value);
    }

    function handlepasswordChange(event){
        setpassword(event.target.value);
    }
    function handleSubmit(event){
        if(username==='Omkar' && password==='dummy'){
            console.log('ok');
            setshowSuccessMessage(true);
            setshowErrorMessage(false);
            navigate('/welcome')
        }else{
            console.log('Fail');
            setshowSuccessMessage(false);
            setshowErrorMessage(true);
        }
    }

    return (
        <div className="Login">
            {showSuccessMessage && <div className='successMessage'>Authentication Successfull.</div>}
            {showErrorMessage && <div className='errorMessage'>Authentication failed. Please check your credentials.</div>}

           <div className="LoginForm">
            <div>
                <label>User Name</label>
                <input type="text" name="username" value={username} onChange={handleusernameChange}/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" value={password} onChange={handlepasswordChange}/>
            </div>
            <div>
                <button type="button" name="login" onClick={handleSubmit}> Login </button> 
            </div>

           </div>
        </div>
    )
}


function WelcomeComponent(){
    return (
        <div className="Welcome">
            <h1>Welcome !!!</h1>
            Welcome Component
        </div>
    )
}

function ErrorComponent(){
    return (
        <div className="ErrorComponent">
            <h1> We are Working really hard!</h1>
            <div>
                Apologies for 404. reachout to out team at abc@xyz.com
            </div>
        </div>
    )
}