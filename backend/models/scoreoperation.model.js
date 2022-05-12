const mongoose = require("mongoose")
const uniqueValidator = require("mongoose-unique-validator")
const Utilisateur = require("../models/utilisateur.model")

const scoreoperationSchema = mongoose.Schema({
  utilisateur: [Utilisateur.schema],
  score: {
    type: number,
    required: true,
  }
});

scoreoperationSchema.plugin(uniqueValidator)

module.exports = mongoose.model("ScoreOperation", scoreoperationSchema)
