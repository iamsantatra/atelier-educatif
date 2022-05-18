
const Entite = require("../models/entite.model")
const ObjectID = require('mongodb').ObjectID

exports.listeAnimaux = async (req, res, next) => {
  try {
    let listeAnimaux = await Entite.find({
      type: "animal"
    });
    return res.status(200).json({
      message: "Animaux",
      data: listeAnimaux
    });
  } catch(err) {
    return res.status(500).json({
      message: "Une erreur s'est produite",
      error: err
    });
  };
};

exports.listeFruitEtLegume = async (req, res, next) => {
    try {
      let listeFruitEtLegume = await Entite.find({
        type: "fruitLegume"
      });
      return res.status(200).json({
        message: "Fruits et Légumes",
        data: listeFruitEtLegume
      });
    } catch(err) {
      return res.status(500).json({
        message: "Une erreur s'est produite",
        error: err
      });
    };
  };

  exports.recherche_animal = async (req, res, next) => {

    try {
      let animal = await Entite.findOne({
        nom: {$regex: new RegExp(req.params.nom, "i")},
        type: "animal"
      })
  
      if(animal == null) {
        return res.status(404).json({
          message: "Animal non trouvé"
        });
      }
      console.log(animal)
      return res.status(200).json({
        message: "Animal bien trouvé ",
        data: animal
      });
    } catch(err) {
      return res.status(500).json({
        message: "Une erreur s'est produite",
        error: err
      });
    };
  };


  exports.recherche_fruitEtLegume = async (req, res, next) => {

    try {
      let fruitLegume = await Entite.findOne({
        nom: {$regex: new RegExp(req.params.nom, "i")},
        type: "fruitLegume"
      })
  
      if(fruitLegume == null) {
        return res.status(404).json({
          message: "Fruit ou légume non trouvé"
        });
      }
      console.log(fruitLegume)
      return res.status(200).json({
        message: "Fruit ou légume bien trouvé ",
        data: fruitLegume
      });
    } catch(err) {
      return res.status(500).json({
        message: "Une erreur s'est produite",
        error: err
      });
    };
  };
    