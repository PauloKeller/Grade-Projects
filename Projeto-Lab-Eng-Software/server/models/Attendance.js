const Mongoose = require('mongoose')
const Schema = Mongoose.Schema

const AttendanceSchema = new Schema({
    waiterId: String,
    placeRating: String,
    waitingTimeRating: Number,
})

module.exports = Mongoose.model('Attendance', AttendanceSchema)