import './App.css'
//import OnlineCourseRegistration from './component/OnlineCourseRegistration'
//import UserReg from './component/UserReg'
//import BMICalculator from './component/BMICalculator'
//import CricketScoreUpdate from './component/CricketScoreUpdate'
//import FetchUser from './component/FetchUser'
//import PasswordChecker from './component/PasswordChecker'
//import Mode from './component/Mode'
//import Profile from './component/Profile'
//import Toggle from './component/Toggle'
//import DynamicFontSize from './component/DynamicFontSize'
//import Counter from './component/Counter'
//import NameInput from './component/NameInput'
//import CarsModel from './component/CarsModel'
//import Car from './component/Car'
//import Circle from './component/Circle'
//import Courses from './component/Courses'
//import EmployeeDashboard from './component/EmployeeDashboard'
//import Greeting from './component/Greeting'
//import Welcome from './component/Welcome'
import {NavLink, Route, BrowserRouter as Router ,Routes} from 'react-router-dom'
import Home from './component/Home'
import Result from './component/Result'
//import Bikes from './component/Bikes'
//import Cars from './component/Cars'
//import Truck from './component/Truck'
function App() {
  return (
    <>
      {/*
      
  console.log("Bikes : "+Bikes);
  console.log("Cars : "+Cars);
  console.log("Truck :" +Truck);
      <Welcome name = "Asma"  dept = "CS" year = "III"></Welcome>
      <Greeting></Greeting>
      <Circle></Circle>
      <Car></Car>
      <Courses></Courses>
      <EmployeeDashboard></EmployeeDashboard>
      <CarsModel></CarsModel>
      <NameInput></NameInput>
      <Counter></Counter>
      <DynamicFontSize></DynamicFontSize>
      <Toggle></Toggle>
      <Mode></Mode>
       <Profile></Profile>
       <PasswordChecker></PasswordChecker>
        <FetchUser></FetchUser>
        <CricketScoreUpdate></CricketScoreUpdate>
         <BMICalculator></BMICalculator>
          <UserReg></UserReg>
          <OnlineCourseRegistration></OnlineCourseRegistration>  
          
        
        <Router>
        <nav>
          <NavLink to="/">Bike</NavLink>
          <NavLink to="/car">Car</NavLink>
          <NavLink to="/truck">Truck</NavLink>
        </nav>
        <Routes>
          <Route path="/" element={<Bikes/>}/>
          <Route path="/car" element={<Cars/>}/>
          <Route path="/truck" element={<Truck/>}/>
        </Routes>
      </Router>
          
*/}
    
          <Router>
            <nav>
              <NavLink to = "/" >Home</NavLink>
            </nav>
            <Routes>
              <Route path = "/" element={<Home/>}/>
              <Route path = "/result/:regno" element = {<Result/>}/>
            </Routes>

          </Router>
        
    </>
  )
}

export default App
