const mongoose = require("mongoose")
const uniqueValidator = require("mongoose-unique-validator")

const terreSchema = mongoose.Schema({
  image: {
    type: String,
    required: true,
  },
  titre : {
    type: String,
    required: true,
  },
  description: {
    type: String,
    required: true,
  }
});

terreSchema.plugin(uniqueValidator)

module.exports = mongoose.model("Terre", terreSchema)
