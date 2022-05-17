const mongoose = require("mongoose")
const Utilisateur = require("../models/utilisateur.model")
const Devinette = require("../models/devinette.model")

const scoredevinetteSchema = mongoose.Schema({
  utilisateur: [Utilisateur.schema],
  devinette : [Devinette.schema],
  score: {
    type: number,
    required: true,
  }
});


module.exports = mongoose.model("ScoreDevinette", scoredevinetteSchema)
