const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const DrinkSchema = new Schema({
    name: String,
    rating: Number,
    menuId: String,
})

module.exports = Mongoose.model('Drink', DrinkSchema)