const React = require('react');


export default class SensorList extends React.Component {

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
                        sensor={sensor}
                        onUpdate={this.props.onUpdate}
                        onDelete={this.props.onDelete}/>
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
                <CreateDialog attributes={this.props.attributes} onCreate={this.onCreate}/>
                <input ref={this.pageSize
                } defaultValue={this.props.pageSize} onInput={this.handleInput}/>
                <table>
                    <tbody>
                        <tr>
                            <th>Name</th>
                            <th>High Temp Alert</th>
                            <th>Low Temp Alert</th>
                            <th>High Humidity Alert</th>
                            <th>Low Humidity Alert</th>
                            <th>Temp Alert</th>
                            <th>Humidity Alert</th>
                            <th>Time Between Alerts</th>
                            <th>Last Alert Triggered</th>
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
        this.handleDelete = this.handleDelete.bind(this);
    }

    handleDelete() {
        this.props.onDelete(this.props.sensor);
    }

    render() {
        return (
            <tr>
                <td>{this.props.sensor.entity.name}</td>
                <td>{this.props.sensor.entity.htAlert}</td>
                <td>{this.props.sensor.entity.ltAlert}</td>
                <td>{this.props.sensor.entity.hhAlert}</td>
                <td>{this.props.sensor.entity.lhAlert}</td>
                {this.props.sensor.entity.tempAlertOn ? <td>On</td> : <td>Off</td>}
                {this.props.sensor.entity.humAlertOn ? <td>On</td> : <td>Off</td>}
                <td>{this.props.sensor.entity.timeBetween}</td>
                <td>{this.props.sensor.entity.alertTriggered}</td>
                <td>
                    <UpdateDialog sensor={this.props.sensor} onUpdate={this.props.onUpdate}/>
                </td>
                <td>
                    <button onClick={this.handleDelete}>Delete</button>
                </td>
            </tr>
        )
    }
}


class UpdateDialog extends React.Component {

    constructor(props) {
        super(props);
        this.textInput = React.createRef();
        this.state = {
            tempAlertOn: true,
            humAlertOn: true,
            timeBetween: this.props.sensor.entity['timeBetween'],
            htAlert: this.props.sensor.entity['htAlert'],
            ltAlert: this.props.sensor.entity['ltAlert'],
            hhAlert: this.props.sensor.entity['hhAlert'],
            lhAlert: this.props.sensor.entity['lhAlert'],
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleInputChange = this.handleInputChange.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    handleSubmit(e) {
        e.preventDefault();
        const updateSensor = {};
        updateSensor['name'] = this.textInput.current.value;
        updateSensor['htAlert'] = this.state.htAlert;
        updateSensor['ltAlert'] = this.state.ltAlert;
        updateSensor['hhAlert'] = this.state.hhAlert;
        updateSensor['lhAlert'] = this.state.lhAlert;
        updateSensor['tempAlertOn'] = this.state.tempAlertOn;
        updateSensor['humAlertOn'] = this.state.humAlertOn;
        updateSensor['timeBetween'] = this.state.timeBetween;
        this.props.onUpdate(this.props.sensor.entity, updateSensor);
        window.location = '#';

    }

    render() {

        const dialogId = "updateSensor-" + this.props.sensor.entity._links.self.href;
        return (
            <div key={this.props.sensor.entity._links.self.href}>
                <a href={'#' + dialogId}>Update</a>
                <div id={dialogId} className="modalDialog">
                    <div>
                        <a href="#" title="Close" className="close">X</a>
                        <h2>Update a Sensor</h2>
                        <form>
                            <p> Sensor Name:
                                <input type='text' ref={this.textInput} defaultValue={this.props.sensor.entity['name']}/>
                            </p>
                            <p> High Temperature Alert:
                                <input name='htAlert'
                                       type="range" min="0" max="100"
                                       value={this.state.htAlert}
                                       onChange={this.handleInputChange} />
                                <output>{this.state.htAlert}</output>
                            </p>
                            <p> Low Temperature Alert:
                                <input name='ltAlert'
                                       type='range' min="0" max="100"
                                       value={this.state.ltAlert}
                                       onChange={this.handleInputChange} />
                                <output>{this.state.ltAlert}</output>
                            </p>
                            <p> High Humidity Alert:
                                <input name="hhAlert"
                                       type="range" min="0" max="100"
                                       value={this.state.hhAlert}
                                       onChange={this.handleInputChange} />
                                <output>{this.state.hhAlert}</output>
                            </p>
                            <p> Low Humidity Alert:
                                <input name="lhAlert"
                                       type="range" min="0" max="100"
                                       value={this.state.lhAlert}
                                       onChange={this.handleInputChange} />
                                <output>{this.state.lhAlert}</output>
                            </p>
                            <p> Temperature Alert On:
                                <input name="tempAlertOn"
                                       type="checkbox"
                                       checked={this.state.tempAlertOn}
                                       onChange={this.handleInputChange} />
                            </p>
                            <p> Humidity Alert On:
                                <input name='humAlertOn'
                                       ref='humAlertOn'
                                       type="checkbox"
                                       checked={this.state.humAlertOn}
                                       onChange={this.handleInputChange} />
                            </p>
                            <p> Time Between Alert (in hours):
                                <input name="timeBetween"
                                       type="number"
                                       value={this.state.timeBetween}
                                       onChange={this.handleInputChange} />
                            </p>
                            <button onClick={this.handleSubmit}>Update</button>
                        </form>
                    </div>
                </div>
            </div>

        )
    }
}

class CreateDialog extends React.Component {

    constructor(props) {
        super(props);
        this.textInput = React.createRef();
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        this.props.onCreate(this.textInput.current.value.trim());
        this.textInput.current.value = '';
        window.location = "#";
    }

    render() {

        return (
            <div>
                <a href="#createSensor">Create</a>

                <div id="createSensor" className="modalDialog">
                    <div>
                        <a href="#" title="Close" className="close">X</a>

                        <h2>Create new sensor</h2>

                        <form>
                            <p>
                                <input type="text" placeholder="sensor name" ref={this.textInput} className="field"/>
                            </p>
                            <button onClick={this.handleSubmit}>Create</button>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}

