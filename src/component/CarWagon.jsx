import React from 'react'
import wagonr from '../assets/wagonr.png'
function CarWagon() {
    const car = {
        name : "WangonR",
        color : "Red",
        model : "LXI 2025",
        pic : wagonr
    }
  return (
    <div>
        <h3>Car Details :</h3>
        <img src = {car.pic} height="80px" width="160px"/>
        <p>Car name : {car.name}</p>
        <p>Car color : {car.color}</p>
        <p>Car model : {car.model}</p>
    </div>
  )
}

export default CarWagon