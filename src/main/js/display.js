'use-strict';

const React = require('react');
const client = require('./functions/client');
const follow = require('./functions/follow');
const when = require('when');

const root = '/api'

class LoadFromServer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {sensors: [], attributes: [], pageSize: 10, links: {}};
        this.updatePageSize = this.updatePageSize.bind(this);
        this.onNavigate = this.onNavigate.bind(this);
    }

    loadFromServer(pageSize) {
        follow(client, root, [
            {rel: 'sensors', params: {size: pageSize}}]
        ).then(sensorCollection => {
            //console.log("loadFromServer:sensorCollection");
            //console.log(sensorCollection);
            return client({
                method: 'GET',
                path: sensorCollection.entity._links.profile.href,
                headers: {'Accept': 'application/schema+json'}
            }).then(schema => {
                this.schema = schema.entity;
                return sensorCollection;
            });
        }).then(sensorCollection => {
            this.setState({links: sensorCollection.entity._links});
            return sensorCollection.entity._embedded.sensors.map(sensor =>
                client({
                    method: 'GET',
                    path: sensor._links.self.href
                })
            );
        }).then(sensorPromises => {
            return when.all(sensorPromises);
        }).done(sensors => {
            //console.log("loadFromServer:sensors")
            //console.log(sensors);
            this.setState({
                sensors: sensors,
                attributes: Object.keys(this.schema.properties),
                pageSize: pageSize,
            });
        });
    }

    onNavigate(navUri) {
        client({method: 'GET', path: navUri}).then (sensorCollection => {
            this.links = sensorCollection.entity._links;

            return sensorCollection.entity._embedded.sensors.map(sensor =>
                client({method: 'GET', path: sensor._links.self.href}));
        }).then(sensorPromises => {
            return when.all(sensorPromises);
        }).done(sensors => {
            this.setState({
                sensors: sensors,
                attributes: Object.keys(this.schema.properties),
                pageSize: this.state.pageSize,
                links: this.links
            });
        });
    }

    updatePageSize(pageSize) {
        if (pageSize !== this.state.pageSize) {
            this.loadFromServer(pageSize);
        }
    }

    componentDidMount() {
        this.loadFromServer(this.state.pageSize);
    }
}

class Display extends LoadFromServer {
    render() {
        return (
            <div>
                <SensorList sensors={this.state.sensors}
                            links={this.state.links}
                            pageSize={this.state.pageSize}
                            onNavigate={this.onNavigate}
                            updatePageSize={this.updatePageSize}/>
            </div>
        )
    }
}

class SensorList extends React.Component {

    constructor(props) {
        super(props);
        this.pageSize = React.createRef();
        this.handleNavFirst = this.handleNavFirst.bind(this);
        this.handleNavPrev = this.handleNavPrev.bind(this);
        this.handleNavNext = this.handleNavNext.bind(this);
        this.handleNavLast = this.handleNavLast.bind(this);
        this.handleInput = this.handleInput.bind(this);
    }

    handleInput(e) {
        e.preventDefault();
        const pageSize = this.pageSize.current.value;
        if (/^[0-9]+$/.test(pageSize)) {
            this.props.updatePageSize(pageSize);
        } else {
            this.pageSize.current.value =
                pageSize.substring(0, pageSize.length - 1);
        }
    }

    handleNavFirst(e){
        e.preventDefault();
        this.props.onNavigate(this.props.links.first.href);
    }

    handleNavPrev(e) {
        e.preventDefault();
        this.props.onNavigate(this.props.links.prev.href);
    }

    handleNavNext(e) {
        e.preventDefault();
        this.props.onNavigate(this.props.links.next.href);
    }

    handleNavLast(e) {
        e.preventDefault();
        this.props.onNavigate(this.props.links.last.href);
    }

    render() {
        //console.log("SensorList:sensors");
        //console.log(this.props.sensors);
        const sensors = this.props.sensors.map(sensor =>
            <Sensor key={sensor.entity._links.self.href}
                    sensor={sensor}/>
        );

        const navLinks = [];
        if ("first" in this.props.links) {
            navLinks.push(<button key="first" onClick={this.handleNavFirst}>&lt;&lt;</button>);
        }
        if ("prev" in this.props.links) {
            navLinks.push(<button key="prev" onClick={this.handleNavPrev}>&lt;</button>);
        }
        if ("next" in this.props.links) {
            navLinks.push(<button key="next" onClick={this.handleNavNext}>&gt;</button>);
        }
        if ("last" in this.props.links) {
            navLinks.push(<button key="last" onClick={this.handleNavLast}>&gt;&gt;</button>);
        }

        return(
            <div>
                <input ref={this.pageSize
                } defaultValue={this.props.pageSize} onInput={this.handleInput}/>
                <table>
                    <tbody>
                    <tr>
                        <th>Name</th>
                        <th>Current Temperature</th>
                    </tr>
                    {sensors}
                    </tbody>
                </table>
                <div>
                    {navLinks}
                </div>
            </div>
        )
    }
}

class Sensor extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <tr>
                <td>{this.props.sensor.entity.name}</td>
                <td>{this.props.sensor.entity.lastTemp}</td>
            </tr>
        )
    }
}

export default Display;