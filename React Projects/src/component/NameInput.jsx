import React, { useState } from 'react'

function NameInput() {
      const[name,setName] = useState('Asma');

  return (
    <div>
    <input type='text' placeholder='Enter your name' value = {name} onChange={(e)=>setName(e.target.value)} style={{padding:'15px',marginTop:'40px'}} height='20px' width='500px' />
    <p>Hello {name} !</p>
    </div>
  )
}

export default NameInput