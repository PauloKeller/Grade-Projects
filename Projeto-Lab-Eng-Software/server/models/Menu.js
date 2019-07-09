const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const MenuSchema = new Schema({
    name: String,
    rating: Number
})

module.exports = Mongoose.model('Menu', MenuSchema)