const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {sensors:[]};
    }

    componentDidMount() {
        client({method: "GET", path: '/api/sensors'}).done(response => {
            this.setState({sensors: response.entity._embedded.sensors});
        });
    }

    render() {
        return (<SensorList sensors={this.state.sensors}/>)
    }
}

class SensorList extends React.Component {
    render() {
        const sensors = this.props.sensors.map(sensor =>
            <Sensor key={sensor._links.self.href} sensor={sensor}/>
        );

        return(
            <table>
                <tbody>
                <tr>
                    <th>name</th>
                    <th>High Temp Alert</th>
                    <th>Low Temp Alert</th>
                    <th>High Humidity Alert</th>
                    <th>Low Humidity Alert</th>
                    <th>Temp Alert On</th>
                    <th>Humidity Alert On</th>
                    <th>Time Between Alerts</th>
                    <th>Last Alert Triggered</th>
                    <th>Last Temp</th>
                </tr>
                {sensors}
                </tbody>
            </table>
        )
    }
}

class Sensor extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.sensor.name}</td>
                <td>{this.props.sensor.htAlert}</td>
                <td>{this.props.sensor.ltAlert}</td>
                <td>{this.props.sensor.hhAlert}</td>
                <td>{this.props.sensor.lhAlert}</td>
                <td>{this.props.sensor.tempAlertOn}</td>
                <td>{this.props.sensor.humAlertOn}</td>
                <td>{this.props.sensor.timeBetween}</td>
                <td>{this.props.sensor.alertTriggered}</td>
                <td>{this.props.sensor.lastTemp}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)
