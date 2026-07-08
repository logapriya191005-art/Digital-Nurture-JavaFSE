import React, { useState } from 'react';

function App() {
  // State to track if the user is logged in
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Function to handle Login
  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  // Function to handle Logout
  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div className="App">
      <h1>Ticket Booking App</h1>
      
      {/* Login/Logout Buttons */}
      <div style={{ margin: '20px' }}>
        {!isLoggedIn ? (
          <button onClick={handleLogin} style={{ padding: '10px 20px', backgroundColor: 'blue', color: 'white', border: 'none', borderRadius: '5px' }}>
            Login
          </button>
        ) : (
          <button onClick={handleLogout} style={{ padding: '10px 20px', backgroundColor: 'red', color: 'white', border: 'none', borderRadius: '5px' }}>
            Logout
          </button>
        )}
      </div>

      {/* Conditional Rendering: Show GuestPage OR UserPage based on login state */}
      {isLoggedIn ? (
        <UserPage />
      ) : (
        <GuestPage />
      )}
    </div>
  );
}

// Guest Page Component - Can only browse flights
function GuestPage() {
  return (
    <div style={{ padding: '20px', border: '1px solid #ccc', margin: '20px', borderRadius: '5px' }}>
      <h2>Guest Page - Browse Flights</h2>
      <p>Welcome! Please login to book tickets.</p>
      
      <h3>Available Flights:</h3>
      <div style={{ border: '1px solid #ddd', padding: '15px', margin: '10px', borderRadius: '5px' }}>
        <h4>Flight 1: Chennai to Bangalore</h4>
        <p>Departure: 10:00 AM | Price: ₹5,000</p>
      </div>
      <div style={{ border: '1px solid #ddd', padding: '15px', margin: '10px', borderRadius: '5px' }}>
        <h4>Flight 2: Delhi to Mumbai</h4>
        <p>Departure: 2:00 PM | Price: ₹6,500</p>
      </div>
      <div style={{ border: '1px solid #ddd', padding: '15px', margin: '10px', borderRadius: '5px' }}>
        <h4>Flight 3: Kolkata to Hyderabad</h4>
        <p>Departure: 6:00 PM | Price: ₹4,800</p>
      </div>
    </div>
  );
}

// User Page Component - Can book tickets
function UserPage() {
  const [selectedFlight, setSelectedFlight] = useState('');

  const handleBookTicket = (e) => {
    e.preventDefault();
    alert(`Ticket booked successfully for ${selectedFlight}!`);
    setSelectedFlight(''); // Reset dropdown after booking
  };

  return (
    <div style={{ padding: '20px', border: '1px solid #ccc', margin: '20px', borderRadius: '5px' }}>
      <h2>User Page - Book Your Ticket</h2>
      <p>Welcome! You can now book your tickets.</p>
      
      <form onSubmit={handleBookTicket}>
        <h3>Select Flight:</h3>
        <select 
          value={selectedFlight} 
          onChange={(e) => setSelectedFlight(e.target.value)}
          style={{ padding: '10px', margin: '10px', width: '300px', borderRadius: '5px' }}
          required
        >
          <option value="">-- Select a Flight --</option>
          <option value="Flight 1: Chennai to Bangalore - ₹5,000">
            Flight 1: Chennai to Bangalore - ₹5,000
          </option>
          <option value="Flight 2: Delhi to Mumbai - ₹6,500">
            Flight 2: Delhi to Mumbai - ₹6,500
          </option>
          <option value="Flight 3: Kolkata to Hyderabad - ₹4,800">
            Flight 3: Kolkata to Hyderabad - ₹4,800
          </option>
        </select>
        
        <br />
        <button 
          type="submit" 
          style={{ padding: '10px 20px', margin: '10px', backgroundColor: 'green', color: 'white', border: 'none', borderRadius: '5px' }}
          disabled={!selectedFlight}
        >
          Book Ticket
        </button>
      </form>
    </div>
  );
}

export default App;