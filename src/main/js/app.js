import React from "react";
import { Link, Route } from "react-router-dom";
import Sensors from "./sensors";
import Display from "./display";

class Home extends React.Component {
    render() {
        return (
            <div>
                <h2>Home</h2>
            </div>
        )
    }
}

const Graphs = () => (
    <div>
        <h2>Graphs</h2>
    </div>
);

export default class App extends React.Component {
    render () {
        return (
            <div>
                <nav className="navbar navbar-light">
                    <ul className="nav navbar-nav">
                        <li>
                            <Link to="/">Home</Link>
                        </li>
                        <li>
                            <Link to="/display">Temperature Display</Link>
                        </li>
                        <li>
                            <Link to="/graphs">Graphs</Link>
                        </li>
                        <li>
                            <Link to="/sensors">Sensors</Link>
                        </li>

                    </ul>
                </nav>

                { /* Route components are rendered if the path prop matches the current URL */}
                <Route path="/"><Home/></Route>
                <Route path="/display"><Display/></Route>
                <Route path="/graphs"><Graphs/></Route>
                <Route path="/sensors"><Sensors/></Route>
            </div>
        )
    }
}