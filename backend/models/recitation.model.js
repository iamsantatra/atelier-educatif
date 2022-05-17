const mongoose = require("mongoose")

const recitationSchema = mongoose.Schema({
  lien: {
    type: String,
    required: true
  }
});

module.exports = mongoose.model("Recitation", recitationSchema)
