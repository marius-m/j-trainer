import React, {Component} from "react";

export default class CodeSubmit extends Component {

  constructor(props) {
    super(props);
    this.state = {
      uuid: '',
      source: '',
      output: ''
    };
    this.handleChange = this
      .handleChange
      .bind(this);
    this.handleSubmit = this
      .handleSubmit
      .bind(this);
  }

  componentDidMount() {
    fetch('http://localhost:8080/api/code_issue_uuid', {method: 'GET'})
    .then((response) => response.json())
    .then((responseJson) => {
      this.setState({
        source: this.state.source,
        uuid: responseJson.uuid, 
        output: this.state.output
      })
    }).catch((error) => {
      console.error(error);
    });
  }

  handleChange(event) {
    this.setState({
      source: event.target.value, 
      uuid: this.state.uuid
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    this.props.doSearch(this.state.uuid, this.state.source)
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>Code to execute</label><br/>
        <textarea
          type="java_code"
          name="source"
          value={this.state.source}
          onChange={this.handleChange}/><br/>
        <input type="submit" value="Submit"/><br/>
      </form>
    );
  }
}
