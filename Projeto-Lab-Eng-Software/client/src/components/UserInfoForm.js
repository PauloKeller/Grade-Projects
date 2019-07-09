import React, { Component } from 'react';
import { 
    FormGroup, 
    InputGroup, 
    FormControl,
    Button,
    ControlLabel,
    Col,
    Form,
    Grid,
    PageHeader,
    Panel,
    Glyphicon } from 'react-bootstrap'

class UserInfoForm extends Component {
    constructor(props) {
        super(props)
        this.state = {
            name: "",
            email: "",
            phone: "",
            address: {
                cep: "",
                state: "",
                city: "",
                district: "",
                street: "",
                number: 0,    
            }
        }
    }

    submitForm(e) {
        e.preventDefault()
        
        var variables = {
            name: this.state.name,
            email: this.state.email,
            phone: this.state.phone,
            address: {
                cep: this.state.cep,
                state: this.state.state,
                city: this.state.city,
                district: this.state.district,
                street: this.state.street,
                number: this.state.number,
            }
        }

        console.log(variables);
    }

  render() {
    return (
      <div className="user-info-form">
        <Grid>
            <PageHeader>
                QUERO AJUDAR! <small>Primeiro precisamos saber quem é você...</small>
            </PageHeader>

            <Form horizontal id="send-user-info" onSubmit={ this.submitForm.bind(this) }>
                <Panel>
                    <Panel.Heading>Cliente</Panel.Heading>
                    <Panel.Body>
                        <FormGroup controlId="formHorizontalEmail">
                            <Col componentClass={ControlLabel} sm={2}>
                            Nome Completo
                            </Col>
                            <Col sm={8}>
                            <FormControl type="text" placeholder="Nome" onChange={ (e) => this.setState({ name: e.target.value })} />
                            </Col>
                        </FormGroup>

                        <FormGroup controlId="formHorizontalPassword">
                            <Col componentClass={ControlLabel} sm={2}>
                            Email
                            </Col>
                            <Col sm={8}>
                            <InputGroup>
                                <InputGroup.Addon>@</InputGroup.Addon>
                                <FormControl type="email" placeholder="Email" onChange={ (e) => this.setState({ email: e.target.value })}/>
                            </InputGroup>
                            </Col>
                        </FormGroup>
                        <FormGroup controlId="formHorizontalPassword">
                            <Col componentClass={ControlLabel} sm={2}>
                            Telefone
                            </Col>
                            <Col sm={8}>
                            <InputGroup>
                                <InputGroup.Addon><Glyphicon glyph="phone" /></InputGroup.Addon>
                                <FormControl type="text" placeholder="(xx) xxxxx-xxxx" onChange={ (e) => this.setState({ phone: e.target.value })}/>
                            </InputGroup>
                            </Col>
                        </FormGroup>
                    </Panel.Body>
                </Panel>
                <Panel>
                    <Panel.Heading>Endereço</Panel.Heading>
                    <Panel.Body>
                        <FormGroup controlId="formControlsSelect">
                            <Col componentClass={ControlLabel} sm={2}>
                            Cep
                            </Col>
                            <Col sm={4}>
                            <FormControl type="text" placeholder="12325-120" onChange={ (e) => this.setState({ cep: e.target.value })} />
                            </Col>
                            <Col componentClass={ControlLabel} sm={1}>
                            Estado
                            </Col>
                            <Col sm={3}>
                                <FormControl componentClass="select" placeholder="select" onChange={ (e) => this.setState({ state: e.target.value })}>
                                    <option value="estado">Estado</option>
                                    <option value="other">...</option>
                                </FormControl>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={2}>
                            Cidade
                            </Col>
                            <Col sm={4}>
                            <FormControl type="text" placeholder="Cidade" onChange={ (e) => this.setState({ city: e.target.value })}/>
                            </Col>
                            <Col componentClass={ControlLabel} sm={1}>
                            Bairro
                            </Col>
                            <Col sm={4}>
                            <FormControl type="text" placeholder="Bairro" onChange={ (e) => this.setState({ district: e.target.value })}/>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={2}>
                            Rua
                            </Col>
                            <Col sm={4}>
                            <FormControl type="text" placeholder="Rua" onChange={ (e) => this.setState({ street: e.target.value })}/>
                            </Col>
                            <Col componentClass={ControlLabel} sm={1}>
                            Número
                            </Col>
                            <Col sm={2}>
                            <FormControl type="text" placeholder="Nº" onChange={ (e) => this.setState({ number: e.target.value })}/>
                            </Col>
                        </FormGroup>
                    </Panel.Body>
                </Panel>
                <Col componentClass={ControlLabel} sm={7}>
                <Button bsSize="large" type="submit">Enviar</Button>
                </Col>
            </Form>
        </Grid>
    </div>
    );
  }
}

export default UserInfoForm;
