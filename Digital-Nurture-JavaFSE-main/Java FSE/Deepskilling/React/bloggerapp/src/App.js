import React, { useState } from 'react';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';

function App() {
  const [selectedComponent, setSelectedComponent] = useState('all');
  const [showDetails, setShowDetails] = useState(true);

  // Method 1: Using Ternary Operator
  const renderWithTernary = () => {
    return selectedComponent === 'book' ? <BookDetails /> :
           selectedComponent === 'blog' ? <BlogDetails /> :
           selectedComponent === 'course' ? <CourseDetails /> :
           <div>
             <BookDetails />
             <BlogDetails />
             <CourseDetails />
           </div>;
  };

  // Method 2: Using Logical AND (&&) Operator
  const renderWithLogicalAnd = () => {
    return (
      <div>
        {showDetails && <BookDetails />}
        {showDetails && <BlogDetails />}
        {showDetails && <CourseDetails />}
      </div>
    );
  };

  // Method 3: Using Switch Statement
  const renderWithSwitch = (component) => {
    switch(component) {
      case 'book':
        return <BookDetails />;
      case 'blog':
        return <BlogDetails />;
      case 'course':
        return <CourseDetails />;
      default:
        return (
          <div>
            <BookDetails />
            <BlogDetails />
            <CourseDetails />
          </div>
        );
    }
  };

  return (
    <div className="App">
      <h1>Blogger App - Conditional Rendering Examples</h1>
      
      {/* Control Buttons */}
      <div style={{ margin: '20px' }}>
        <h3>Select Component to Display:</h3>
        <button onClick={() => setSelectedComponent('all')} style={{ margin: '5px' }}>All</button>
        <button onClick={() => setSelectedComponent('book')} style={{ margin: '5px' }}>Book Only</button>
        <button onClick={() => setSelectedComponent('blog')} style={{ margin: '5px' }}>Blog Only</button>
        <button onClick={() => setSelectedComponent('course')} style={{ margin: '5px' }}>Course Only</button>
        
        <br /><br />
        <button onClick={() => setShowDetails(!showDetails)} style={{ margin: '5px' }}>
          {showDetails ? 'Hide All' : 'Show All'}
        </button>
      </div>

      {/* Method 1: Ternary Operator */}
      <div style={{ margin: '20px', padding: '10px', border: '2px solid blue' }}>
        <h2>Method 1: Ternary Operator</h2>
        {renderWithTernary()}
      </div>

      {/* Method 2: Logical AND */}
      <div style={{ margin: '20px', padding: '10px', border: '2px solid green' }}>
        <h2>Method 2: Logical AND (&&)</h2>
        {renderWithLogicalAnd()}
      </div>

      {/* Method 3: Switch Statement */}
      <div style={{ margin: '20px', padding: '10px', border: '2px solid red' }}>
        <h2>Method 3: Switch Statement</h2>
        {renderWithSwitch(selectedComponent)}
      </div>
    </div>
  );
}

export default App;