const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const DessertSchema = new Schema({
    name: String,
    rating: Number,
    menuId: String,
})

module.exports = Mongoose.model('Dessert', DessertSchema)