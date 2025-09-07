import { useState } from 'react'
import './TodoApp.css'

export default function TodoApp() {
    return (
        <div className="TodoApp">
            Todo Management application
            <LoginComponent/>
            {/* <WelcomeComponent /> */}
        </div>
    )
}

function LoginComponent(){

    const [username, setUserName] = useState('Omkar');
    const [password, setpassword] = useState('');
    const [showSuccessMessage, setshowSuccessMessage] = useState(false);
    const [showErrorMessage, setshowErrorMessage] = useState(false);

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
        }else{
            console.log('Fail');
            setshowSuccessMessage(false);
            setshowErrorMessage(true);
        }
    }

    function SuccessMessageComponent(){
        if(showSuccessMessage){
            return <div className='successMessage'>Authentication Successfull.</div>
        }else{return null}
    }

    function ErrorMessageComponent(){
        if(showErrorMessage){
            return  <div className='errorMessage'>Authentication failed. Please check your credentials.</div>
        }else{return null}
    }
    return (
        <div className="Login">
            <SuccessMessageComponent />
            <ErrorMessageComponent />
           
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
            Welcome Component
        </div>
    )
}