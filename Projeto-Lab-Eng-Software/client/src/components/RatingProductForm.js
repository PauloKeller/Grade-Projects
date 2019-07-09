import React, { Component } from 'react';
import StarRatingComponent from 'react-star-rating-component';
import { gql } from 'apollo-boost'
import { graphql } from 'react-apollo'
import { 
    FormGroup,  
    FormControl,
    Button,
    ControlLabel,
    Col,
    Form,
    Grid,
    PageHeader,
    Panel,
    Radio } from 'react-bootstrap'

const getShopQuery = gql`
    {
        shop(id:"5b1d9aa565d82554ab0e6b67") {
            name
            id
            waiters{
                name
                id
            }
            menu{
                name
                id
                dishes{
                    name
                    id
                }
                drinks{
                    name
                    id
                }
                desserts{
                    name
                    id
                }
            }
        }
    }
`
 
class RatingProuctForm extends Component {
    getShop() {
        var data = this.props.data
        if ( data.loading ) {
            return ( <option disabled>Carregando informações...</option> )
        } else {
            return data.shop
        }
    }

    displayWaiters() {
        var data = this.props.data
        if ( data.loading ) {
            return ( <option disabled>Carregando informações...</option> )
        } else {
            return data.shop.waiters.map(waiter => {
                return <option key={ waiter.id } value={waiter.id}>{ waiter.name }</option>
            })
        }
    }

    displayDishes() {
        var data = this.props.data
        if ( data.loading ) {
            return ( <option disabled>Carregando informações...</option> )
        } else {
            return data.shop.menu.dishes.map(dish => {
                return <option key={ dish.id } value={dish.id}>{ dish.name }</option>
            })
        }
    }

    displayDrinks() {
        var data = this.props.data
        if ( data.loading ) {
            return ( <option disabled>Carregando informações...</option> )
        } else {
            return data.shop.menu.drinks.map(drink => {
                return <option key={ drink.id } value={drink.id}>{ drink.name }</option>
            })
        }
    }

    displayDesserts() {
        var data = this.props.data
        if ( data.loading ) {
            return ( <option disabled>Carregando informações...</option> )
        } else {
            return data.shop.menu.desserts.map(dessert => {
                return <option key={ dessert.id } value={dessert.id}>{ dessert.name }</option>
            })
        }
    }

    
    constructor(props) {
        super(props);
     
        this.state = {
            dish: "",
            dishRate: 0,
            drink: "",
            drinkRate: 0,
            dessert: "",
            dessertRate: 0,
            waiter: {
                name: "",
                waiterRate: 0,
                place: "",
                watingTime: "",
            }
        }
    }

    onStarClick(nextValue, prevValue, name) {
        switch (name) {
            case 'dishRate':
                this.setState({dishRate: nextValue})
                break
            case 'drinkRate':
                this.setState({dishRate: nextValue})
                break
            case 'dessertRate':
                this.setState({dessertRate: nextValue})
                break
            case 'waiterRate':
                this.setState({waiterRate: nextValue})
                break
            default:
                break
        }
    }

    submitForm(e) {
        e.preventDefault()
        
        var variables = {
            dish: this.state.dish,
            dishRate: this.state.dishRate,
            drink: this.state.drink,
            drinkRate: this.state.drinkRate,
            dessert: this.state.dessert,
            dessertRate: this.state.dessertRate,
            waiter: {
                name: this.state.name,
                waiterRate: this.state.waiterRate,
                place: this.state.place,
                watingTime: this.state.watingTime,
            }
        }

        console.log(variables)
    }
         
    render() {
        const { rating } = this.state;
        return (
        <div className="rating-product-form">
        <Grid>
            <PageHeader>
                DESCREVA SUA EXPERIÊNCIA! <small>Fale um pouco sobre como foi nos visitar...</small>
            </PageHeader>
            <Form horizontal onSubmit={ this.submitForm.bind(this) }>
                <Panel>
                    <Panel.Heading>Pedido</Panel.Heading>
                    <Panel.Body>
                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={1}>
                            Prato
                            </Col>
                            <Col sm={3}>
                                <FormControl componentClass="select" placeholder="select" onChange={ (e) => this.setState({ dish: e.target.value })}>
                                    {this.displayDishes()}
                                </FormControl>
                            </Col>
                            <Col componentClass={ControlLabel} sm={1}>
                            Bebida
                            </Col>
                            <Col sm={3}>
                                <FormControl componentClass="select" placeholder="select" onChange={ (e) => this.setState({ drink: e.target.value })}>
                                    {this.displayDrinks()}
                                </FormControl>
                            </Col>
                            <Col componentClass={ControlLabel} sm={1}>
                            Sobremesa
                            </Col>
                            <Col sm={3}>
                                <FormControl componentClass="select" placeholder="select" onChange={ (e) => this.setState({ dessert: e.target.value })}>
                                    {this.displayDesserts()}
                                </FormControl>
                            </Col>
                        </FormGroup>
                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={1}>
                            Nota
                            </Col>
                            <Col sm={3}>
                                <StarRatingComponent 
                                name="dishRate" 
                                starCount={5}
                                value={rating}
                                onStarClick={this.onStarClick.bind(this)}
                                />
                            </Col>
                            <Col componentClass={ControlLabel} sm={1}>
                            Nota
                            </Col>
                            <Col sm={3}>
                                <StarRatingComponent 
                                name="drinkRate" 
                                starCount={5}
                                value={rating}
                                onStarClick={this.onStarClick.bind(this)}/>
                            </Col>
                            <Col componentClass={ControlLabel} sm={1}>
                            Nota
                            </Col>
                            <Col sm={3}>
                                <StarRatingComponent 
                                name="dessertRate" 
                                starCount={5}
                                value={rating}
                                onChange={ (e) => this.setState({ dessertRate: e.target.value })}
                                />
                            </Col>
                        </FormGroup> 
                    </Panel.Body>
                </Panel>
                <Panel>
                    <Panel.Heading>Atendente</Panel.Heading>
                    <Panel.Body>
                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={1}>
                            Nome
                            </Col>
                            <Col sm={6}>
                                <FormControl componentClass="select" placeholder="select" onChange={ (e) => this.setState({ name: e.target.value })}>
                                   {this.displayWaiters()}
                                </FormControl>
                            </Col>
                            <Col componentClass={ControlLabel} sm={1}>
                            Nota
                            </Col>
                            <Col sm={3}>
                                <StarRatingComponent 
                                name="waiterRate" 
                                starCount={5}
                                value={rating}
                                onChange={ (e) => this.setState({ waiterRate: e.target.value })}
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup>
                            
                        </FormGroup>
                        <FormGroup>
                        <Col componentClass={ControlLabel} sm={1}>
                            Ambiente
                            </Col>
                            <Col sm={3}>
                                <FormControl componentClass="select" placeholder="select" onChange={ (e) => this.setState({ place: e.target.value })}>
                                    <option value="confortavel">Confortavel</option>
                                    <option value="other">...</option>
                                </FormControl>
                            </Col>
                            <Col componentClass={ControlLabel} sm={1}>
                            Espera
                            </Col>
                            <Col sm={4}>
                            <FormGroup>
                                <Radio name="radioGroup" inline value="15.0" onChange={ (e) => this.setState({ watingTime: e.target.value })}>
                                    15 min
                                </Radio>{' '}
                                <Radio name="radioGroup" inline value="30.0" onChange={ (e) => this.setState({ watingTime: e.target.value })}>
                                    30 min
                                </Radio>{' '}
                                <Radio name="radioGroup" inline value="60.0" onChange={ (e) => this.setState({ watingTime: e.target.value })}>
                                    60 min
                                </Radio>
                            </FormGroup>
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

export default graphql(getShopQuery)(RatingProuctForm);
