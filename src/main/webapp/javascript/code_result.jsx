import React, {Component} from "react";
import Observable from 'rxjs/observable';
import {interval} from 'rxjs/observable/interval';
import {takeWhile} from 'rxjs/operators';

export default class CodeResult extends Component {

  constructor(props) {
    super(props);
    this.state = {
      uuid: this.props.uuid,
      source: this.props.source,
      loading: true,
      output: ''
    };
  }

  componentDidMount() {
    console.log("Fetching events for " + this.state.uuid + " / " + this.state.source);
    interval(1000)
      .pipe(takeWhile(tickItem => {
      return tickItem < 4
    }))
      .subscribe(tickItem => {
        if (tickItem == 3) {
          this.setState({
            uuid: this.props.uuid,
            source: this.props.source,
            loading: false,
            output: "Cool output"
          });
        }
      })
  }

  render() {
    if (this.state.loading) {
       return(<div>Loading...</div>);
    }
    return (
      <div>Output: {this.state.output}</div>
    );
  }
}
