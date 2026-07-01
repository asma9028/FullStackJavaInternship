import React from 'react'

function Courses() {
    const courses = ["Java" , "React" ,"DS" , "WAD"]
  return (
    <div>
        <h3>List of courses</h3>
        <ul>
            {courses.map((c,index)=>(
                <li key={index}> {c}</li>
))}
        </ul>
    </div>
  )
}

export default Courses