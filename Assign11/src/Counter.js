import React,{useState} from "react";

const Counter = ()=>{
  const [counter, setCounter] = useState(0);
    
 const handleCounter = (num)=> {
    const coun  = counter + num;
    setCounter(coun);
   }
    return (
        
      <div style={{top: 20,margin: 50}}>
      <button onClick={()=>handleCounter(1)}
      style={{margin: 20}}
      >Increment</button>
      <label style={{margin: 20}}>counter {counter}</label>
      <button onClick={()=>handleCounter(-1)} style={{margin: 20}}>Decrement</button>
    </div>
    );
}
export default Counter;