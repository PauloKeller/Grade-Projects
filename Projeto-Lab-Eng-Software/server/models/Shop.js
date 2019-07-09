const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const ShopSchema = new Schema({
    name: String,
    menuId: String,
})

module.exports = Mongoose.model('Shop', ShopSchema)