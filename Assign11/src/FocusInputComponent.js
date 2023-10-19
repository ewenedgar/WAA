import React, {useRef} from 'react';

 const FocusInputComponent = () =>{
    const inputRef = useRef(null);
    
    const focusInput = () =>{
        inputRef.current.focus();
    }
    const removeFocusInput = () =>{
        inputRef.current.blur();
    }
    return(
        <div>
            <h2>Focus on Input</h2>
            <button onClick={removeFocusInput} > Remove Focus on Click</button>
            <input type='text' ref={inputRef} autoFocus={false}/>
            <button onClick={focusInput} >Add Focus on Click</button>
        </div>
    )
}
export default FocusInputComponent;