import React from 'react'
import bikes from './bike'

function Bikes() {
  return (
     <div> 
        <h1>Bike Details</h1>
        <div className='container'>
        {bikes.map((bike,index) => (
         <article key={index}>
            <img src={bike.url} height="90px" width="150px"/>
            <p>{bike.name}</p>
            <p>{bike.price}</p>
         </article>
        ))
         }
         </div>
         
    </div>
  )
}

export default Bikes