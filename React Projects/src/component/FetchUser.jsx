import React, { useEffect, useState } from 'react'

function FetchUser() {
    const[users,setUser] = useState([])
    useEffect(()=>{
        fetch("https://jsonplaceholder.typicode.com/users")
        .then(res=>res.json())
        .then(data=>setUser(data));
    },[])
  return (
    <div>
        <h1>User Details</h1>
        <table>
        <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Username</th>
                <th>City</th>
            </tr>
        {
        users.map((user,index)=>(
            <tr key={index}>
                <td>{user.name}</td>
                <td>{user.email}</td>
                <td>{user.username}</td>
                <td>{user.address.city}</td>
            </tr>
        ))}
        </table>
        
    </div>
  )
}

export default FetchUser