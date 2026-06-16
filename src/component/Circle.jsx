import React from 'react'

function radiusCalc(radius){
    return 3.14*radius*radius;
}

function Circle() {
  return (
    <div> 
        <h3>Area : {radiusCalc(5)}</h3>
     </div>
  )
}

export default Circle