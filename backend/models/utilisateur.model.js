const mongoose = require("mongoose")

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

module.exports = mongoose.model("Utilisateur", utilisateurSchema)
