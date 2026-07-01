import React, { useState } from 'react'

function Profile() {
    const [user,setUser] = useState({name: '',age: ''});
  return (
    <div>
        <input type = 'text' placeholder='Name' onChange={(e)=>setUser({...user,name:e.target.value})}/>
        <br/>
        <input type='text' placeholder='Age' onChange={(e)=>setUser({...user,age:e.target.value})}/>
        <p>Name : {user.name}</p>
        <p>Age : {user.age}</p>
    </div>
  )
}

export default Profile