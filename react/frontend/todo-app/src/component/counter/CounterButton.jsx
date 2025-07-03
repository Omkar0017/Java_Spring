import { useState } from "react"
import {PropTypes} from 'prop-types'
import "./Counter.css"


export default function Counter(){
     const [count,setParentCount] = useState(0)

     function incrementParent(by){
        setParentCount(count + by)
     }

    function decrementParent(by){
        setParentCount(count - by)
     }
     function resetCounter(){
        setParentCount(0)
     }
     
    return (
    <div className="App">
        <span className="count">{count}</span>
        <CounterButton by={1} incrementParent={incrementParent} decrementParent={decrementParent}/>   
        <CounterButton by={2} incrementParent={incrementParent} decrementParent={decrementParent}/>    
        <CounterButton by={5} incrementParent={incrementParent} decrementParent={decrementParent}/>
        <button className="resetButton" 
                        onClick={resetCounter}
                >Reset</button>
    </div>
    )
}


 function CounterButton( {by,incrementParent, decrementParent}) {

   const [count,setCount] = useState(0)

    function increment(){
        setCount(count + by)
        incrementParent(by)
        console.log(count)
    }

    function decrement(){
        setCount( count- by)
        decrementParent(by)
        console.log(count)
    }

return(
    <div className="counter">  
        
        <div>
            <button className="counterButton" 
            onClick={increment}
            > +{by}
            </button>
            <button className="counterButton" 
            onClick={decrement}
            > -{by}
            </button>
        </div>
    </div>
)
}

CounterButton.propTypes = {
    by: PropTypes.number
}

CounterButton.defaultProps = {
    by: 1
}