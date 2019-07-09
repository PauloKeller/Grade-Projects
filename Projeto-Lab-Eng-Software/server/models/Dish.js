const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const DishSchema = new Schema({
    name: String,
    rating: Number,
    menuId: String,
})

module.exports = Mongoose.model('Dish', DishSchema)