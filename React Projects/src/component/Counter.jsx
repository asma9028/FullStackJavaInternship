import React, { useState } from 'react'

function Counter() {
    const [count,setCount] = useState(0);

  return (
    <div>
    <p>Count : {count}</p>
    <button onClick={()=>setCount(count+1)} style={{height:"30px",width:"180px",padding:"8px",margin:"10px",backgroundColor:"yellow",color:"black",borderRadius:'8px'}}>Increment</button>
    </div>
  )
}

export default Counter