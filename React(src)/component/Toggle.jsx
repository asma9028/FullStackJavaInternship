import React, { useState } from 'react'

function Toggle() {
    const [show,setShow] = useState(true);
  return (
    <div>
        <button onClick={()=>setShow(!show)}>
            {show? "Hide" : "Show"}
        </button>
        {show && <p>Hello World!</p>}
    </div>
  )
}

export default Toggle