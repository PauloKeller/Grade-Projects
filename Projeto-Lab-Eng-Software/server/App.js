const Express = require('express')
const GraphQLHTTP = require('express-graphql')
const Schema = require('./schema/Schema')
const Mongoose = require('mongoose')
const Cors = require('cors')

const App = Express()

// Allow cross-origin requests
App.use(Cors())

Mongoose.connect('mongodb://root:root123@ds231205.mlab.com:31205/lab-eng-software')
Mongoose.connection.once('open', () => {
    console.log('Connected to database')
})

App.use('/graphql', GraphQLHTTP({
    schema: Schema,
    graphiql: true
}))

App.listen(4000, () => {
    console.log('Now listening for requests on port 4000')
})