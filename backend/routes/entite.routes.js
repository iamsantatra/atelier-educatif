const express = require("express")

const entiteController = require("../controllers/entite.controller")
const router = express.Router();

router.get("/liste_animaux", entiteController.listeAnimaux)
router.get("/liste_fruitsEtLegumes", entiteController.listeFruitEtLegume)
router.get("/recherche_animal/:nom", entiteController.recherche_animal)
router.get("/recherche_fruitEtLegume/:nom", entiteController.recherche_fruitEtLegume)

module.exports = router;
