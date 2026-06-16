import React, { useEffect, useState } from 'react'

function PasswordChecker() {
    const[pass,setPass] = useState("");
    const[msg,setMsg] = useState("");
    useEffect(()=>{
        if(pass.length < 5){
            setMsg("Too short");
        }
        else{
            setMsg("Good Password");
        }
    },[pass])
  return (
    <>
      <input type="password" onChange={(e)=>setPass(e.target.value)}
      placeholder='Enter password'/>
      <p>{msg}</p>
    </>
    
  )
}

export default PasswordChecker   