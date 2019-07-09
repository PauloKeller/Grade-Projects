const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const OrderSchema = new Schema({
    dishId: String,
    drinkId: String,
    dessertId: String,
})

module.exports = Mongoose.model('Order', OrderSchema)