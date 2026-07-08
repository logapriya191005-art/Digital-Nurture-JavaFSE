import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div className="App">
      <h1>Cohort Dashboard</h1>
      <CohortDetails 
        name="Java FSE Batch 1"
        status="ongoing"
        startDate="2026-06-01"
        endDate="2026-12-31"
      />
      <CohortDetails 
        name="Java FSE Batch 2"
        status="completed"
        startDate="2026-01-01"
        endDate="2026-05-31"
      />
    </div>
  );
}

export default App;