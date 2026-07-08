import React from 'react';

function App() {
  // Create an object of office to display details
  const office = {
    name: "Cognizant Tech Hub",
    rent: 75000,
    address: "123 Business Park, Chennai"
  };

  // Create a list of office space objects
  const officeSpaces = [
    { id: 1, name: "Office Space 1", rent: 45000, address: "Location A" },
    { id: 2, name: "Office Space 2", rent: 65000, address: "Location B" },
    { id: 3, name: "Office Space 3", rent: 55000, address: "Location C" },
    { id: 4, name: "Office Space 4", rent: 80000, address: "Location D" }
  ];

  return (
    <div className="App">
      {/* Display heading using JSX */}
      <h1>Office Space Rental</h1>

      {/* Display office details using object */}
      <div style={{ border: '1px solid #ccc', padding: '20px', margin: '20px' }}>
        <h2>Featured Office</h2>
        <p><strong>Name:</strong> {office.name}</p>
        {/* Inline CSS: Display rent in green if above 60000, red if below */}
        <p><strong>Rent:</strong> 
          <span style={{ color: office.rent > 60000 ? 'green' : 'red' }}>
            ₹{office.rent}
          </span>
        </p>
        <p><strong>Address:</strong> {office.address}</p>
      </div>

      {/* Loop through office spaces list */}
      <h2>Available Office Spaces</h2>
      <div>
        {officeSpaces.map(space => (
          <div key={space.id} style={{ border: '1px solid #ddd', padding: '15px', margin: '10px' }}>
            <h3>{space.name}</h3>
            <p>Address: {space.address}</p>
            {/* Conditional inline CSS based on rent value */}
            <p>Rent: 
              <span style={{ color: space.rent > 60000 ? 'green' : 'red' }}>
                ₹{space.rent}
              </span>
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;