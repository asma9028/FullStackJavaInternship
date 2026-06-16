import { useState} from 'react'
import {useNavigate} from 'react-router-dom'
function Home() {
    const [regno , setRegNo] = useState("");
    const[error,setError] = useState("");
    const navigate = useNavigate();
    const searchResult = ()=>{
        if(regno.trim() == ""){
            setError("Invalid Register number");
            return;
        }
        else{
            navigate(`/result/${regno}`);
        }
    }
  return (
    <div>
        <h1>Karpagam college of Engineering</h1>
        <h2>Student result portal</h2>
        <input type='text' value = {regno} placeholder='Enter register number'
        onChange={(e)=>setRegNo(e.target.value)}/>
        <button onClick={searchResult}>View Results</button>
    </div>
  )
}

export default Home