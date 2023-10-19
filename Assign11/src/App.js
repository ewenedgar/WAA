import './App.css';
import {useState, useEffect} from 'react';
import FocusInputComponent from './FocusInputComponent';
import Counter from './Counter';

function App() {
 const colors =  ["yellow", 
                  "red",
                "blue", "gray",
              "yeast", "teal", "pink", 
            "purple", "brown", "black"];
  const [currentColorIndex, setCurrentColorIndex] = useState(0);
  const [isMounted, setIsMounted] = useState(false);

  useEffect(()=>{
    let count  = currentColorIndex;
    const timer = setInterval(()=>{
      if(isMounted){
        //console.log(count);
        setCurrentColorIndex(count === colors.length-1? 0: count++ );
      }
    }, 1000);

return () =>{
  clearInterval(timer);
}
    // eslint-disable-next-line
  },[isMounted]);
 const handleIsMounted =()=> setIsMounted(!isMounted);

  return (
    <div className="App" >
            {<><label style={{top: 20,backgroundColor:colors[currentColorIndex]}}>
              color name : {currentColorIndex}</label>
      <h2>{colors[currentColorIndex]}</h2></>}

      <button onClick={()=>handleIsMounted()}> {isMounted ? 'Unmount' : 'Mount' }</button>

      <Counter />

      <FocusInputComponent/>
    </div>
  );
}

export default App;
