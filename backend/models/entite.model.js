const mongoose = require("mongoose")
const uniqueValidator = require("mongoose-unique-validator")

const entiteSchema = mongoose.Schema({
  nom: {
    type: String,
    required: true,
  },
  image : {
    type: String,
    required: true,
  },
  type: {
    type: String,
    required: true,
    enum: ["fruitLegume", "animal"],
  }
});

entiteSchema.plugin(uniqueValidator)

module.exports = mongoose.model("Entite", entiteSchema)
