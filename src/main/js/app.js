import React from "react";
import { Link, Route, Switch } from "react-router-dom";
import Sensors from "./sensors";

class Home extends React.Component {
    render() {
        return (
            <div>
                <h2>Home</h2>
            </div>
        )
    }
}

const Category = () => (
    <div>
        <h2>Category</h2>
    </div>
);

const Products = () => (
    <div>
        <h2>Products</h2>
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
                            <Link to="/category">Category</Link>
                        </li>
                        <li>
                            <Link to="/products">Products</Link>
                        </li>
                        <li>
                            <Link to="/sensors">Sensors</Link>
                        </li>

                    </ul>
                </nav>

                { /* Route components are rendered if the path prop matches the current URL */}
                <Route path="/"><Home/></Route>
                <Route path="/category"><Category/></Route>
                <Route path="/products"><Products/></Route>
                <Route path="/sensors"><Sensors/></Route>
            </div>
        )
    }
}