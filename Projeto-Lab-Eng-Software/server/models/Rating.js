const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const RatingSchema = new Schema({
    shopId: String,
    clientId: String,
    orderId: String,
    attendanceId: String,
})

module.exports = Mongoose.model('Rating', RatingSchema)