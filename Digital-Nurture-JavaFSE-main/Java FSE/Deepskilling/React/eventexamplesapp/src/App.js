import React, { useState } from 'react';

function App() {
  const [counter, setCounter] = useState(0);

  // Method 1a: To increment the value
  const increment = () => {
    setCounter(counter + 1);
  };

  // Method 1b: Say Hello
  const sayHello = () => {
    alert('Hello!');
  };

  // Static message method
  const showMessage = () => {
    alert('This is a static message');
  };

  // Method 2: Say Welcome with argument
  const sayWelcome = (message) => {
    alert(message);
  };

  // Method 3: Synthetic event handler
  const handlePress = (event) => {
    alert('I was clicked');
  };

  return (
    <div className="App">
      <h1>Event Examples App</h1>
      
      {/* Counter Section */}
      <div style={{ margin: '20px' }}>
        <h2>Counter: {counter}</h2>
        {/* Button 1: Increment - invokes multiple methods */}
        <button onClick={() => {
          increment();
          sayHello();
          showMessage();
        }}>
          Increment
        </button>
        
        {/* Button: Decrement */}
        <button onClick={() => setCounter(counter - 1)} style={{ marginLeft: '10px' }}>
          Decrement
        </button>
      </div>

      {/* Button 2: Say Welcome */}
      <button onClick={() => sayWelcome('Welcome')} style={{ margin: '10px' }}>
        Say Welcome
      </button>

      {/* Button 3: Synthetic event */}
      <button onClick={handlePress} style={{ margin: '10px' }}>
        Press Me
      </button>

      {/* Currency Converter Component */}
      <CurrencyConverter />
    </div>
  );
}

// Currency Converter Component
function CurrencyConverter() {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Convert rupees to euros (approximate rate: 1 euro = 90 rupees)
    const euroValue = parseFloat(rupees) / 90;
    setEuros(euroValue.toFixed(2));
  };

  return (
    <div style={{ margin: '30px', padding: '20px', border: '1px solid #ccc' }}>
      <h2>Currency Converter</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Indian Rupees: </label>
          <input 
            type="number" 
            value={rupees} 
            onChange={(e) => setRupees(e.target.value)}
            placeholder="Enter amount in Rupees"
          />
        </div>
        <button type="submit" style={{ margin: '10px' }}>Convert</button>
        {euros && <h3>Euros: €{euros}</h3>}
      </form>
    </div>
  );
}

export default App;