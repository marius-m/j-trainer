import React, {Component} from "react";

export default class Code extends Component {

  constructor(props) {
    super(props);
    this.state = {source: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({source: event.target.value});
  }

  handleSubmit(event) {
    alert('Submitted source: ' + this.state.source);
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>Code to execute</label><br />
        <textarea type="java_code" name="source" value={this.state.source} onChange={this.handleChange}/><br />
        <input type="submit" value="Submit"/><br />
      </form>
    );
  }
}
