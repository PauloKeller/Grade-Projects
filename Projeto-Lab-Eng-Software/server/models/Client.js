const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const ClientSchema = new Schema({
    name: String,
    email: String,
    phone: String,
    addressId: String
})

module.exports = Mongoose.model('Client', ClientSchema)