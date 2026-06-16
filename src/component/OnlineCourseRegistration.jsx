import React, {  useState } from 'react'

function OnlineCourseRegistration() {
    const [user,setUser] = useState({
        fname : "",
        lname : "",
        dob : "",
        phone : "",
        course : "",
        duration : ""
    });
    const[loading,setLoading] = useState(false);
    const handleSubmit = (e)=>{
        e.preventDefault();
        setLoading(true);
    }
  return ( <>
    <div style={{textAlign:"left",padding:"20px"}}>
        {!loading && (<>
        <h1>Online Course Registration Form</h1>
        <form onSubmit={handleSubmit}>
            <label style={{marginRight:"80px",marginLeft:"5px"}}><strong>First Name</strong></label>
            <label style={{marginRight:"120px",marginLeft:"18px"}}><strong>Last Name</strong></label><br/>
            <input type='text'placeholder='Enter your first name' value= {user.fname} onChange={(e)=>setUser({...user,fname : e.target.value})}/>
            <input type='text' placeholder='Enter your last name' value= {user.lname} onChange={(e)=>setUser({...user,lname : e.target.value})}/>
            <br/>
            <label><strong>Email</strong></label><br/>
            <input type='email' placeholder='Email address' value= {user.email} onChange={(e)=>setUser({...user,email : e.target.value})}/> <br/>
            <label><strong>Date of Birth</strong></label><br/>
            <input type='date' value= {user.dob} onChange={(e)=>setUser({...user,dob : e.target.value})}/> <br/>
            <label><strong>Phone/Mobile</strong></label><br/>
            <input type='Mobile number' placeholder='Mobile Number' value= {user.phone} onChange={(e)=>setUser({...user,phone : e.target.value})}/><br/>
            <label><strong>Choose the course you want to enroll in</strong></label><br/>
            <select onChange={(e)=>setUser({...user, course : e.target.value})}>
                <option>-Select-</option>
                <option value="Graphic design">Graphic design</option>
                <option value="Animation">Animation 3D</option>
                <option value="Digital Marketing">Digital Marketing</option>
            </select>
            <p><strong>Preferred Course Duration</strong></p>
            <input type='radio' name='duration' id='duration6' value="6 Months" onChange={(e)=>setUser({...user,duration : e.target.value})}/> 6 Months <br/>
            <input type='radio' name='duration' id='duration12' value="12 Months" onChange={(e)=>setUser({...user,duration : e.target.value})}/> 12 Months <br/>
            <button style={{backgroundColor :"dodgerblue",height:"39px",width:"140px",border:"1px solid white",color:"white",borderRadius:"5px"}}>Apply to Enroll</button>
        </form></>
        )}
        {
            loading && <>
            <h1>User Details</h1>
            <p><strong>Name : </strong>{user.fname + user.lname}</p>
            <p><strong>Email : </strong>{user.email}</p>
            <p><strong>DOB : </strong>{user.dob}</p>
            <p><strong>Course : </strong>{user.course}</p>
            <p><strong>Duration : </strong>{user.duration}</p>
            </>
        }
    </div>
    </>
  )
}

export default OnlineCourseRegistration