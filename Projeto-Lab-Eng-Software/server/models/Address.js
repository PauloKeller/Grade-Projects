const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const AddressSchema = new Schema({
    cep: String,
    state: String,
    city: String,
    district: String,
    street: String,
    number: Number
})

module.exports = Mongoose.model('Address', AddressSchema)