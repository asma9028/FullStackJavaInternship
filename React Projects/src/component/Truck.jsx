import React from 'react'
import trucks from './truck'

function Truck() {
  return (
        <div>
        <h1>Truck Details</h1>
        <div className='container'>
        {trucks.map((truck,index) => (
         <article key={index}>
            <img src={truck.url} height="90px" width="150px"/>
            <p>{truck.name}</p>
            <p>{truck.price}</p>
         </article>
        ))
         }
         </div>
         
    </div>
  )
}

export default Truck