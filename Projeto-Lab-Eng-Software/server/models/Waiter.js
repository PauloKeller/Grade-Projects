const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const WaiterSchema = new Schema({
    name: String,
    rating: Number,
    shopId: String,
})

module.exports = Mongoose.model('Waiter', WaiterSchema)