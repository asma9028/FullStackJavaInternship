import {useParams,useNavigate} from 'react-router-dom'
import students from './students';
function Result() {
    const {regno} = useParams();
    const navigate = useNavigate();
    const student = students.find((stud)=>stud.regno === regno);
    if(!student){
        return(
        <div>
            <h2>Student Not Found</h2>
            <button onClick ={()=>navigate("/")}>Back</button>
        </div>
        )
    }
  return (
    <div>
        <h1>Student Result</h1>
        <h2>Name : {student.name}</h2>
        <h3>Year : {student.year}</h3>
        <h3>Department : {student.dept}</h3>
        <center>
        <table border = "1">
            <tbody>
            <tr>
                <td>Subject</td>
                <td>Mark</td>
            </tr>
            {
                student.subjects.map((sub,index)=>(
                    <tr key={index}>
                        <td>{sub.name}</td>
                        <td>{sub.mark}</td>
                    </tr>
                ))
            }
            </tbody>
        </table>
        </center>
        <button onClick={()=>navigate("/")}>Back to Home</button>
    </div>
  )
}

export default Result