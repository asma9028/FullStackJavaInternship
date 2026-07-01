import React from 'react'
import cars from './car'
function Cars() {
  return (
    <div>
        
        <h1>Car Details</h1>
        <div className='container'>
        {cars.map((car,index) => (
         <article key={index}>
            <img src={car.url} height="90px" width="150px"/>
            <p>{car.name}</p>
            <p>{car.price}</p>
         </article>
        ))
         }
         </div>
    </div>
  )
}

export default Cars