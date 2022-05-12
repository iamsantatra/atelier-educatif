const mongoose = require("mongoose")
const uniqueValidator = require("mongoose-unique-validator")

const recitationSchema = mongoose.Schema({
  lien: {
    type: String,
    required: true
  }
});

recitationSchema.plugin(uniqueValidator)

module.exports = mongoose.model("Recitation", recitationSchema)
