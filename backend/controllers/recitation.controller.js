const Recitation = require("../models/recitation.model")
const fetch = require('node-fetch');

async function getYoutube(id) {
  return await fetch("https://www.youtube.com/oembed?url=http://www.youtube.com/watch?v="+id).then(res => res.json())
};

exports.listeYoutube = async (req, res, next) => {
  try {
    let listeRecitation = await Recitation.find();
    let youtubeListe = []
    for (let i = 0; i < listeRecitation.length; i++) {
      let youtube = await getYoutube(listeRecitation[i].lien)
      youtube.lien = listeRecitation[i].lien
      youtubeListe.push(youtube)
    }
    console.log(youtubeListe);
    return res.status(200).json({
      message: "Vidéos youtube",
      data: youtubeListe
    });
  } catch(err) {
    console.log(err)
    return res.status(500).json({
      message: "Vidéos youtube",
      error: errr
    });
  };
}

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
