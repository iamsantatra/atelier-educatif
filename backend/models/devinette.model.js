const mongoose = require("mongoose")
const uniqueValidator = require("mongoose-unique-validator")

const devinetteSchema = mongoose.Schema({
  image: {
    type: String,
    required: true,
    // unique: true
  },
  question : {
    type: String,
    required: true,
  },
  reponse: {
    type: String,
    required: true,
  },
  point: {
    type: number,
    required: true,
  }
});

devinetteSchema.plugin(uniqueValidator)

module.exports = mongoose.model("Devinette", devinetteSchema)
