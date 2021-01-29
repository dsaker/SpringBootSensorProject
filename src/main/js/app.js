import React from "react";
import { Link, Route } from "react-router-dom";
import Sensors from "./sensors";
import Display from "./display";
import LineCharts from "./linechart/linecharts";

class Home extends React.Component {
    render() {
        return (
            <div>
                <h2>Home</h2>
            </div>
        )
    }
}

export default class App extends React.Component {
    render () {
        return (
            <div>
                <li>
                    <Link to="/">Home</Link>
                </li>
                <li>
                    <Link to="/display">Temperature Display</Link>
                </li>
                <li>
                    <Link to="/linecharts">Line Charts</Link>
                </li>
                <li>
                    <Link to="/sensors">Sensors</Link>
                </li>

                { /* Route components are rendered if the path prop matches the current URL */}
                <Route path="/"><Home/></Route>
                <Route path="/display"><Display/></Route>
                <Route path="/linecharts"><LineCharts/></Route>
                <Route path="/sensors"><Sensors/></Route>
            </div>
        )
    }
}