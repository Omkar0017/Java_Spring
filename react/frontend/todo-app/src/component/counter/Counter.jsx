export default function Counter() {

    const buttonStyle ={fontSize:"20px",
                        backgroundColor:"#00a5ab",
                        width:"100px",
                        margin:"10px",
                        padding:"15px",
                        color:"white",
                        borderRadius:"15px"

    }

    function increment(){
        alert("Increment Clicked")
        console.log("Increment Clicked")
    }
return(
    <div className="counter"> Counter 
        <span className="count">0</span>
        <div>
            <button className="counterButton" 
            onClick={increment}
            style={buttonStyle}
            
            > +1
            </button>
        </div>
    </div>
)
}