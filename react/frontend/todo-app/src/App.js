import './App.css';
import Counter from './component/counter/CounterButton';

function App() {
  return (
    <div className="App">
      <PlayingWithProps property1="value1" property2="value2"/> 
      <Counter />      
    </div>
  );
}

// function PlayingWithProps(properties){
//   console.log(properties);
//   return (<div> Props</div>
//   )
// }
function PlayingWithProps({property1,property2}){
  console.log(property1);
  console.log(property2);
  return (<div> Props</div>
  )
}


export default App;
