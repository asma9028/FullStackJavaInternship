import React, { useEffect, useState } from 'react'

function CricketScoreUpdate() {
    const[runs,setRuns] = useState(0);
    const[overs,setOvers] = useState(0);
    const[wickets,setWickets] = useState(0);
    const[matchStatus,setMatchStatus] = useState("Live");
    useEffect(()=>{
        const intervalId = setInterval(()=>{
            setRuns((prevRun)=>prevRun+Math.floor(Math.random()*7));
            if(Math.random()>0.8){
            setWickets((prevWicket)=>prevWicket+1);
        }
        setOvers((prevOvers)=>(prevOvers+0.5).toFixed(1));
        },2000);
        const timeOutId = setTimeout(()=>{
            clearInterval(intervalId);
            setMatchStatus("Match finished");
        },30000);
        return ()=>{
            clearInterval(intervalId);
            clearTimeout(timeOutId);
        }
    },[])
    return (
    <div>
        <h1>Cricket Score Update</h1>
        <h2>Status : {matchStatus}</h2>
        <div>
            <h3>India Vs Australia</h3>
            <p><strong>Runs : </strong> {runs}</p>
            <p><strong>Overs : </strong>{overs}</p>
            <p><strong>Wickets : </strong>{wickets}</p>

        </div>
    </div>
  )
}

export default CricketScoreUpdate