import React, { useState } from 'react'

function DynamicFontSize() {
    const [size,setSize] = useState(16);
  return (
    <div>
        <input type='number' name={size} onChange={(e)=>setSize(e.target.value)}/>
        <p style={{fontSize:`${size}px`,margin:"20px"}}>Welcome to KCE</p> 
    </div>
  )
}

export default DynamicFontSize