import React from 'react'

function EmployeeDashboard() {
    const hour = new Date().getHours();
    const greeting = hour<12? "Good Morning" : hour<17 ? "Good Afternoon" : "Good Evening";
  return (
    <div style={{border :"1px solid grey", padding:"10px"}}>
        <h1 style={{fontWeight : "bold"}}>{greeting}!</h1>
        <h1 style={{fontWeight : "bold"}}>Welcome to your Wipro Dashboard.</h1>
        <div style={{border : "1px solid grey",borderRadius:"8px", margin:"10px", fontSize:"20px", color:"black",padding :"10px",textAlign : "left"}}>
            <h2 style={{fontWeight : "bold"}}>Employee Profile</h2>
            <p>Name: James</p>
            <p>Employee ID: WIPRO7839A2</p>
            <p>Department: Global IT Structure</p>
        </div>
        <div style={{border : "1px solid grey",borderRadius:"8px", margin:"10px" , fontSize:"20px", color:"black", padding: "10px", textAlign : "left"}}>
            <h2 style={{fontWeight : "bold"}}>Current Projects</h2>
            <ul>
                <li>Advanced Threat Protection (Wipro Security Operations)</li>
                <li>Legacy Mainframe Optimization (Financial Services Client)</li>
                <li>AI/ML for Predictive Maintenance (Industrial Client)</li>
                <li>Data Privacy Compliance Audit</li>
            </ul>
        </div>
        <div style={{border : "1px solid grey",borderRadius:"8px", margin:"10px" , padding :"10px", textAlign : "left"}}>
            <h2 style={{fontWeight : "bold"}}>Team Notices</h2>
            <p style={{color:"maroon",fontSize :"20px"}}>⚠️ Product Strategy Call @ 11.30 AM</p>
        </div>
        <p style={{color :"black", textAlign :"left", fontSize :"20px",paddingLeft :"10px", fontWeight :"400"}}>Contact : james.wipro@wipro.com | +91-XXXXXXXXX</p>
        <p style = {{color: "black", textAlign : "left", fontSize : "20px", paddingLeft :"10px", fontWeight :"400",paddingBottom : "20px"}}>WIPRO TECHNOLOGY | Wipro Ltd. Global Operations</p>
    </div>
  );
}

export default EmployeeDashboard