use atelier;

db.utilisateurs.insertMany(
	[
		{
			nom: "Léo Weber",
      nomUtilisateur: "leo2018",
			motDePasse: "$2b$10$rfCEvo8nYI2rFqdgVpyzeu/mNuccmlwO8YDNvTmVDwA/.LGPHPbpm",
		},
		{
			nom: "Alice Mervei",
      nomUtilisateur: "alice2018",
			motDePasse: "$2b$10$rfCEvo8nYI2rFqdgVpyzeu/mNuccmlwO8YDNvTmVDwA/.LGPHPbpm",
		}
	]
)

db.terres.insertMany(
  [
    {
      image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652355354/Images/eau_vcjiwi.jpg",
			titre: "L'importance de l'eau",
			description: "L’eau potable est une ressource vitale mais très rare. À la maison, il est ainsi essentiel d’économiser l’eau, que ce soit en réduisant sa consommation dans les toilettes, la salle de bain ou pour le jardinage ou encore la cuisine.",
    },
    {
      image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652355353/Images/jardin_mstcvd.jpg",
			titre: "Jardiner pour comprendre la nature",
			description: "Il n’y a rien de mieux que le contact direct avec la nature. Avec le jardinage, on comprend le fonctionnement des plantes et du cycle de la vie. Faites germer des graines, installez un petit potager dans votre jardin.",
    },
    {
      image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652355353/Images/dechet_fpdsge.jpg",
			titre: "Trier les jouets pour prendre conscience de la valeur des choses",
			description: "Sélectionner les jouets dont vous ne voulez plus, pour les donner à des associations caritatives ou à des enfants qui en ont usage.",
    },
    {
      image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351785/Images/peigne_qbmycy.png",
			titre: "Trier ses déchets",
			description: "Apprenez à trier les déchets par catégorie (nourriture, papier, verre…), vers l'âge de 7 ans. Le verre et le plastique ne peuvent pas être détruits par la nature et qu'il est donc essentiel de les trier pour pouvoir ensuite les recycler.",
    },
  ]
)

db.entites.insertMany(
	[
		{
			nom: "Ananas",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351782/Images/ananas_vduc30.jpg",
			type: "fruitLegume"
		},
		{
			nom: "Avocat",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351788/Images/avocat_cd7qx5.jpg",
			type: "fruitLegume"
		},
    {
			nom: "Orange",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351782/Images/orange_bleq57.jpg",
			type: "fruitLegume"
		},
		{
			nom: "Pastèque",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351793/Images/pasteque_lqkhqr.jpg",
			type: "fruitLegume"
		},
    {
			nom: "Pomme",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351790/Images/pomme_u5e6c9.jpg",
			type: "fruitLegume"
		},
		{
			nom: "Aubergine",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351785/Images/aubergine_rxzpqs.jpg",
			type: "fruitLegume"
		},
    {
			nom: "Carotte",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351793/Images/carotte_w6btwx.jpg",
			type: "fruitLegume"
		},
		{
			nom: "Oignon",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351783/Images/oignon_w7oagl.jpg",
			type: "fruitLegume"
		},
    {
			nom: "Radis",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351783/Images/radis_yslxwv.jpg",
			type: "fruitLegume"
		},
		{
			nom: "Tomate",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351795/Images/tomate_gumbvg.jpg",
			type: "fruitLegume"
		},
    {
			nom: "Cochon",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652357005/Images/cochon_roczvl.jpg",
			type: "animal"
		},
		{
			nom: "Lion",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652357006/Images/lion_alvzfu.jpg",
			type: "animal"
		},
    {
			nom: "Oie",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652357006/Images/oie_qx0dag.jpg",
			type: "animal"
		},
		{
			nom: "Tortue",
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652357006/Images/tortue_j2sniu.jpg",
			type: "animal"
		}
	]
)

db.entites.findOneAndUpdate(
	{
		'nom':'Tortue'
	},
	{
		$set: {
				'nom':'Poule', 'image': 'https://res.cloudinary.com/dyptj60q1/image/upload/v1652973160/Images/poule_kcu6pp.jpg', 
				'cri': 'https://res.cloudinary.com/dyptj60q1/video/upload/v1652973137/Images/poule_egdixz.wav'
			}
	})

db.entites.findOneAndUpdate(
	{
		'nom':'Cochon'
	},
	{
		$set: {
				'cri': 'https://res.cloudinary.com/dyptj60q1/video/upload/v1652973136/Images/pig_teyvli.mp3'
			}
	})

db.entites.findOneAndUpdate(
	{
		'nom':'Lion'
	},
	{
		$set: {
				'cri': 'https://res.cloudinary.com/dyptj60q1/video/upload/v1652973137/Images/lion_wyhao9.wav'
			}
	})


db.entites.findOneAndUpdate(
	{
		'nom':'Oie'
	},
	{
		$set: {
				'cri': 'https://res.cloudinary.com/dyptj60q1/video/upload/v1652973137/Images/oie_ouutlu.wav'
			}
	})


db.recitations.insertMany(
	[
		{
      lien: "qNhIcfszeDQ"
    },
    {
      lien: "1kq88XtHOEA"
    },
    {
      lien: "iLvVZny4HzQ"
    },
    {
      lien: "kCLE_Wvl5wM"
    },
    {
      lien: "IYLTc3tGdzc"
    },
    {
      lien: "xVw74cHnxig"
    },
    {
      lien: "owVJ7ppTwPg"
    },
  ]
)

db.devinettes.insertMany(
	[
		{
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351785/Images/peigne_qbmycy.png",
			question: "Qu'est-ce qui a des dents mais qui ne mange pas ?",
			reponse: "Un peigne",
			point: 20
		},
		{
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351793/Images/soleil_tb8xeo.jpg",
			question: "Je ne fais pas de bruit et pourtant je réveille tout le monde, qui suis-je ?",
			reponse: "Le soleil",
			point: 13
		},
		{
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351795/Images/etoile_ri88qc.jpg",
			question: "Qu'est-ce qui peut être dans la mer et dans le ciel ?",
			reponse: "Une étoile",
			point: 5
		},
		{
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351790/Images/lunette_gsvway.jpg",
			question: "Qu'est-ce qui a deux branches mais pas de feuilles ?",
			reponse: "Les lunettes",
			point: 24
		},
    {
			image: "https://res.cloudinary.com/dyptj60q1/image/upload/v1652351791/Images/pluie_teno8z.jpg",
			question: "Qu'est ce qui tombe de très très haut et ne se fait pourtant jamais mal ?",
			reponse: "La pluie",
			point: 6
		}
	]
)

// db.createView('VCommande','commandes', [
//   {
//     $lookup: {
//       from: "plats",
//       localField: "plat_id",
//       foreignField: "_id",
//       as: "commandePlat"
//     },
//   },
//   {
//     $lookup: {
//       from: "restaurants",
//       localField: "commandePlat.restaurant_id",
//       foreignField: "_id",
//       as: "commandeRestaurant"
//     }
//   },
//   {
//     $lookup: {
//       from: "utilisateurs",
//       localField: "utilisateur_id",
//       foreignField: "_id",
//       as: "commandeUtilisateur"
//     }
//   }
// ])

// db.createView("VbeneficeResto", "VCommande",  [
// 	{
// 		$match: { etat: 3 }
// 	},
// 	{
// 		$group: {
// 			_id: "$commandeRestaurant._id",
// 			restaurant_id: { $first: '$commandeRestaurant._id' },
// 			nom_restaurant: { $first: '$commandeRestaurant.nom' },
// 			total: {
// 				$sum: {
// 					$subtract: ["$sumPrixVente", "$sumPrixAchat"]
// 					}
// 				}
// 			}
// 	}
// ])
