import React, { useState } from 'react'

function UserReg() {
    const[user, setUser] = useState({
        name : "",
        password : "",
        email : "",
        dob : ""
    });
    const[loading, setLoading] = useState(false);
    const handleSubmit = (e)=>{
        e.preventDefault();
        setLoading(true);
    }
  return (
    <div>{!loading && (
        <form onSubmit={handleSubmit}>
            <label>Name : </label>
            <input type="text" placeholder='Enter name' value={user.name}
            onChange={(e)=>setUser({...user,name : e.target.value})}/><br/>
            <label>Email : </label>
            <input type="email" placeholder='Enter email' value={user.email}
            onChange={(e)=>setUser({...user,email : e.target.value})}/><br/>
            <label>Password : </label>
            <input type="password" placeholder='Enter password' value={user.password}
            onChange={(e)=>setUser({...user,password : e.target.value})}/><br/>
            <label>DOB : </label>
            <input type="date" placeholder='Enter date of birth' value={user.dob}
            onChange={(e)=>setUser({...user,dob : e.target.value})}/><br/>
            <button>Submit</button>
        </form>)}
        {
            loading && 
            <>
            <h1>User Info</h1>
            <p><strong>Name : </strong>{user.name}</p>
            <p><strong>Email : </strong>{user.email}</p>
            <p><strong>Password : </strong>{user.password}</p>
            <p><strong>DOB :</strong>{user.dob}</p>
            </>
        }
    </div>
  )
}

export default UserReg