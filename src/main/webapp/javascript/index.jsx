import ReactDOM from 'react-dom';
import React from 'react';
import Code from './code'
import '../css/general.css';

ReactDOM.render(
  <div>
    Enter code that should be executed:
    <Code />
  </div>,
  document.getElementById('content')
);
