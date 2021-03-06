const Terre = require("../models/terre.model")

const getPagination = (page, size) => {
  const limit = size ? +size : 3;
  const offset = page ? page * limit : 0;
  return { limit, offset };
};

exports.listeTerre = async (req, res) => {

  const { page, size } = req.query;
  const { limit, offset } = getPagination(page, size);
  try {
    let data = await Terre.find();
    console.log(data.docs)
    return res.status(200).json({
      terres: data,
      totalPages: data.length,
    });
  } catch(err) {
    return res.status(500).json({
      message:
        err.message || "Une erreur s'est produite.",
    });
  }
};

// exports.detailRecitation = async (req, res, next) => {

//   try {
//     let detailRecitation = await Recitation.findOne({
//       lien: req.params.lien
//     })

//     if(detailRecitation == null) {
//       return res.status(404).json({
//         message: "Récitation ou comptine inexistant"
//       });
//     }
//     console.log(detailRecitation)
//     return res.status(200).json({
//       message: "Récitation / comptine "+ req.params.lien,
//       data: detailRecitation
//     });
//   } catch(err) {
//     return res.status(500).json({
//       message: "Une erreur s'est produite",
//       error: err
//     });
//   };
// };
