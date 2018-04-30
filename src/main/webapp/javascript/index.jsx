import ReactDOM from 'react-dom';
import React from 'react';
import Code from './code'
import '../css/general.css';

if (document.getElementById('code_submit') !=null)  {
  ReactDOM.render(
    <div>
      <Code />
    </div>,
    document.getElementById('code_submit')
  );
}
