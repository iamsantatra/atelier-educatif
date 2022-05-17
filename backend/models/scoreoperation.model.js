const mongoose = require("mongoose")
const Utilisateur = require("../models/utilisateur.model")

const scoreoperationSchema = mongoose.Schema({
  utilisateur: [Utilisateur.schema],
  score: {
    type: number,
    required: true,
  }
});

module.exports = mongoose.model("ScoreOperation", scoreoperationSchema)
