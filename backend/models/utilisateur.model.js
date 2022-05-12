const mongoose = require("mongoose")
const uniqueValidator = require("mongoose-unique-validator")

const utilisateurSchema = mongoose.Schema({
  nom: {
    type: String,
    required: true
  },
  nomUtilisateur : {
    type: String,
    required: true
  },
  motDePasse : {
    type: String,
    required: true
  }
}
);

utilisateurSchema.plugin(uniqueValidator)

module.exports = mongoose.model("Utilisateur", utilisateurSchema)
