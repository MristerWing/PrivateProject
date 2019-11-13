import React from 'react';
//import './App.css';

function App() {
  const name = 'React';
  /* const style = {
    backgroundColor: 'black',
    color: 'aqua',
    fontSize: '48px',
    fontWeight: 'bold',
    padding: 16
  }; */
  // return <div style={style}>{name || '정의되지 않음'}</div>
  // other Ver
  return (
    <div
      style={{
        backgroundColor: 'black',
        color: 'aqua',
        fontSize: '48px',
        fontWeight: 'bold',
        padding: 16 //단위 생략시 px로 지정
      }}
    >
      {name}
    </div>
  );
}

export default App;
