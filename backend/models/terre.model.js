const mongoose = require("mongoose")
const mongoosePaginate = require('mongoose-paginate-v2');

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

terreSchema.plugin(mongoosePaginate);

module.exports = mongoose.model("Terre", terreSchema)
