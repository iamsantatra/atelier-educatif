const mongoose = require("mongoose")

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
  },
  cri: {
    type: String,
    required: true
  }
});

module.exports = mongoose.model("Entite", entiteSchema)
