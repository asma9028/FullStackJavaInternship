import {useDispatch, useSelector} from "react-redux";
import { decrement, increment, incrementByAmount, reset } from "./counterSlice";
import { useState } from "react";
function Counter() {
    const count = useSelector((state)=>state.counter.value);
    const dispatch = useDispatch();
    const [amount,setAmount] = useState(0);
  return (
    <div>
        <p>{count}</p>
        <div>
            <button onClick={()=>dispatch(increment())}>+</button>
            <button onClick={()=>dispatch(decrement())}>-</button>
            <div>
                <input type ='number'
                value = {amount}
                onChange={(e)=>setAmount(parseInt(e.target.value))}/>
                <button onClick={()=>dispatch(incrementByAmount(amount))}>+ (amount)</button>
            </div>
            <button onClick={()=>dispatch(reset())}>Reset</button>
        </div>
    </div>
  )
}

export default Counter