const Recitation = require("../models/recitation.model")

exports.listeRecitation = async (req, res, next) => {
    try {
      let listeRecitation = await Recitation.find();
      return res.status(200).json({
        message: "Liste des récitations",
        data: listeRecitation
      });
    } catch(err) {
      return res.status(500).json({
        message: "Une erreur s'est produite",
        error: err
      });
    };
};

exports.detailRecitation = async (req, res, next) => {

  try {
    let detailRecitation = await Recitation.findOne({
      lien: req.params.lien
    })

    if(detailRecitation == null) {
      return res.status(404).json({
        message: "Récitation ou comptine inexistant"
      });
    }
    console.log(detailRecitation)
    return res.status(200).json({
      message: "Récitation / comptine "+ req.params.lien,
      data: detailRecitation
    });
  } catch(err) {
    return res.status(500).json({
      message: "Une erreur s'est produite",
      error: err
    });
  };
};
