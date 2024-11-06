package com.example.pregnancyquiz

object Constants {

    const val BEST_SCORE: String = "best_score"
    const val CURRENT_SCORE : String = "current_score"
    const val SP = "shared_preferences"

    //keys under which we are storing

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,
            "Which of these types of cheese must be avoided during pregnancy?",
            R.drawable.ic_cheese,
            "Most of blue cheeses (Stilton, Roquefort, Gorgonzola)",
            "Mozzarella",
            "Cheddar",
            "Emmental",
            1,
            "FDA (2018, September 27). Listeria from Food Safety for Moms to Be. https://www.fda.gov/food/health-educators/listeria-food-safety-moms-be"
        )

        val que2 = Question(
            2,
            "How much alcohol is safe to drink during pregnancy?",
            R.drawable.ic_alcohol,
            "100 ml/ 3.38 oz per day",
            "200 ml/ 6.76 oz per day",
            "300 ml/10.14 oz per day",
            "None",
            4,
            "Centers for Disease Control and Prevention (2021, December 14). Alcohol Use During Pregnancy. https://www.cdc.gov/ncbddd/fasd/alcohol-use.html"
        )

        val que3 = Question(
            3,
            "Which of these meals is safe to eat during pregnancy?",
            R.drawable.ic_chicken,
            "Raw oysters",
            "Medium done steak",
            "Sushi with raw fish",
            "Roasted chicken",
            4,
            "FDA (2018, September 27). Listeria from Food Safety for Moms to Be. https://www.fda.gov/food/health-educators/listeria-food-safety-moms-be"
        )

        val que4 = Question(
            4,
            "Which of these types of fish should be avoided during pregnancy?",
            R.drawable.ic_tuna,
            "Bigeye tuna",
            "Flounder",
            "Black sea bass",
            "Cod",
            1,
            "FDA (2022, June 08). Advice about Eating Fish. https://www.fda.gov/food/consumers/advice-about-eating-fish"
        )

        val que5 = Question(
            5,
            "Which of these types of fish is very healthy to eat up to three times per week during pregnancy?",
            R.drawable.ic_salmon,
            "Swordfish",
            "Salmon",
            "King mackerel",
            "Marlin",
            2,
            "FDA (2022, June 08). Advice about Eating Fish. https://www.fda.gov/food/consumers/advice-about-eating-fish"
        )

        val que6 = Question(
            6,
            "Which of these sauces is not safe to eat while pregnant?",
            R.drawable.ic_hollandaise_sauce,
            "Ketchup",
            "Hollandaise sauce, unless made with pasteurized eggs",
            "BBQ sauce",
            "Cranberry sauce",
            2,
            "FDA (2018, September 27). Dairy and Eggs from Food Safety for Moms to Be. https://www.fda.gov/food/people-risk-foodborne-illness/dairy-and-eggs-food-safety-moms-be"
        )

        val que7 = Question(
            7,
            "What is the maximum quantity of caffeine that a pregnant woman can have in a day?",
            R.drawable.ic_caffeine,
            "500 mg",
            "400 mg",
            "200 mg",
            "100 mg",
            3,
            "ACOG CommitteeOpinion No. 462: Moderate caffeine consumption during pregnancy. (2010). Obstetrics and gynecology, 116(2 Pt 1), 467–468. https://doi.org/10.1097/AOG.0b013e3181eeb2a1"
        )

        val que8 = Question(
            8,
            "Which of these beverages does not contain caffeine (that should be limited during pregnancy)?",
            R.drawable.ic_mint_tea,
            "Peppermint tea",
            "Cola",
            "Green tea",
            "Hot cocoa",
            1,
            " 1. FoodData Central (2019, April 1). Beverages, tea, herb, other than chamomile, brewed. https://fdc.nal.usda.gov/fdc-app.html#/food-details/173232/nutrients \n https://sci-hub.mksa.top/10.1111/j.1750-3841.2010.01561.x \n 2. FoodData Central (2019, April 1). Beverages, carbonated, cola, fast-food cola. https://fdc.nal.usda.gov/fdc-app.html#/food-details/175093/nutrients \n 3. FoodData Central (2019, April 1). Beverages, tea, green, brewed, regular. https://fdc.nal.usda.gov/fdc-app.html#/food-details/171917/nutrients \n 4. FoodData Central (2019, April 1). Milk, chocolate beverage, hot cocoa, homemade. https://fdc.nal.usda.gov/fdc-app.html#/food-details/171277/nutrients"
        )

        val que9 = Question(
            9,
            "Which of these types of tea does not contain caffeine (that should be limited during pregnancy)?",
            R.drawable.ic_herbal_tea,
            "White tea",
            "Oolong tea",
            "Herbal tea",
            "Black tea",
            3,
            " 1. Boros, K., Jedlinszki, N., & Csupor, D. (2016). Theanine and Caffeine Content of Infusions Prepared from Commercial Tea Samples. Pharmacognosy magazine, 12(45), 75–79. https://doi.org/10.4103/0973-1296.176061 \n 2. FoodData Central (2019, April 1). Beverages, tea, herb, other than chamomile, brewed. https://fdc.nal.usda.gov/fdc-app.html#/food-details/173232/nutrients"
        )

        val que10 = Question(
            10,
            "Which of these activities is not safe during pregnancy?",
            R.drawable.ic_scubadiving,
            "Yoga",
            "Moderate aerobic exercises",
            "Scuba diving",
            "Swimming",
            3,
            " 1. Babbar, S., & Shyken, J. (2016). Yoga in Pregnancy. Clinical obstetrics and gynecology, 59(3), 600–612. https://doi.org/10.1097/GRF.0000000000000210 \n 2. Barakat, R., Perales, M., Garatachea, N., Ruiz, J. R., & Lucia, A. (2015). Exercise during pregnancy. A narrative review asking: what do we know?. British journal of sports medicine, 49(21), 1377–1381. https://doi.org/10.1136/bjsports-2015-094756 \n 3. Reid, R. L., & Lorenzo, M. (2018). SCUBA Diving in Pregnancy. Journal of obstetrics and gynaecology Canada : JOGC = Journal d'obstetrique et gynecologie du Canada : JOGC, 40(11), 1490–1496. https://doi.org/10.1016/j.jogc.2017.11.024 \n 4. Juhl, M., Kogevinas, M., Andersen, P. K., Andersen, A. M., & Olsen, J. (2010). Is swimming during pregnancy a safe exercise?. Epidemiology (Cambridge, Mass.), 21(2), 253–258. https://doi.org/10.1097/EDE.0b013e3181cb6267"
        )

        val que11 = Question(
            11,
            "Which of these relaxation methods is not generally recommended during pregnancy, especially in the first trimester?",
            R.drawable.ic_bath_tubs,
            "Yoga",
            "Hot tubs",
            "Massage",
            "Listening to music",
            2,
            " 1. Babbar, S., & Shyken, J. (2016). Yoga in Pregnancy. Clinical obstetrics and gynecology, 59(3), 600–612. https://doi.org/10.1097/GRF.0000000000000210 \n 2. Rogers, J., & Davis, B. A. (1995). How risky are hot tubs and saunas for pregnant women?. MCN. The American journal of maternal child nursing, 20(3), 137–140. https://doi.org/10.1097/00005721-199505000-00010 \n 3. Pachtman Shetty, S. L., & Fogarty, S. (2021). Massage During Pregnancy and Postpartum. Clinical obstetrics and gynecology, 64(3), 648–660. https://doi.org/10.1097/GRF.0000000000000638 \n 4. Perkovic, R., Tustonja, M., Devic, K., & Kristo, B. (2021). Music Therapy and Mental Health in Pregnancy. Psychiatria Danubina, 33(Suppl 4), 786–789."
        )

        val que12 = Question(
            12,
            "Which of these activities is safe to do while pregnant?",
            R.drawable.ic_flu_shot,
            "Get a flu shot",
            "Change a cat litter",
            "Passive smoking",
            "Painting your house",
            1,
            " 1. Centers for Disease Control and Prevention (2019, December 12). Influenza (Flu) Vaccine and Pregnancy. https://www.cdc.gov/vaccines/pregnancy/hcp-toolkit/flu-vaccine-pregnancy.html \n 2. Beazley, D. M., & Egerman, R. S. (1998). Toxoplasmosis. Seminars in perinatology, 22(4), 332–338. https://doi.org/10.1016/s0146-0005(98)80022-0 \n 3. Meng, X., Sun, Y., Duan, W., & Jia, C. (2018). Meta-analysis of the association of maternal smoking and passive smoking during pregnancy with neural tube defects. International journal of gynaecology and obstetrics: the official organ of the International Federation of Gynaecology and Obstetrics, 140(1), 18–25. https://doi.org/10.1002/ijgo.12334 \n 4. Bailey, H. D., Milne, E., de Klerk, N. H., Fritschi, L., Attia, J., Cole, C., Armstrong, B. K., & Aus-ALL Consortium (2011). Exposure to house painting and the use of floor treatments and the risk of childhood acute lymphoblastic leukemia. International journal of cancer, 128(10), 2405–2414. https://doi.org/10.1002/ijc.25572"
        )

        val que13 = Question(
            13,
            "Which of these activities is not safe to do during pregnancy?",
            R.drawable.ic_saunaa,
            "Receiving a relaxation massage",
            "Exercising",
            "Air traveling",
            "Sauna bathing",
            4,
            " 1. Mueller, S. M., & Grunwald, M. (2021). Effects, Side Effects and Contraindications of Relaxation Massage during Pregnancy: A Systematic Review of Randomized Controlled Trials. Journal of clinical medicine, 10(16), 3485. https://doi.org/10.3390/jcm10163485 \n 2. Barakat, R., Perales, M., Garatachea, N., Ruiz, J. R., & Lucia, A. (2015). Exercise during pregnancy. A narrative review asking: what do we know?. British journal of sports medicine, 49(21), 1377–1381. https://doi.org/10.1136/bjsports-2015-094756 \n 3. Shalev Ram, H., Ram, S., Miller, N., Rosental, Y. S., & Chodick, G. (2020). Air travel during pregnancy and the risk of adverse pregnancy outcomes as gestational age and weight at birth: A retrospective study among 284,069 women in Israel between the years 2000 to 2016. PloS one, 15(2), e0228639. https://doi.org/10.1371/journal.pone.0228639 \n 4. Rogers, J., & Davis, B. A. (1995). How risky are hot tubs and saunas for pregnant women?. MCN. The American journal of maternal child nursing, 20(3), 137–140. https://doi.org/10.1097/00005721-199505000-00010"
        )

        val que14 = Question(
            14,
            "Which of these symptoms is not a symptom of preeclampsia?",
            R.drawable.ic_braxton,
            "Braxton Hicks contractions",
            "A persistent headache",
            "Changes in vision, including blurry vision or seeing spots",
            "Pain in the upper stomach area",
            1,
            "Centers for Disease Control and Prevention (2021, May 6). High Blood Pressure During Pregnancy. https://www.cdc.gov/bloodpressure/pregnancy.htm"
        )

        val que15 = Question(
            15,
            "Which of these symptoms is not a symptom of preeclampsia?",
            R.drawable.ic_gums,
            "Swelling of the face or hands",
            "Nausea or vomiting",
            "Sore, bleeding gums",
            "Sudden weight gain",
            3,
            "Centers for Disease Control and Prevention (2021, May 6). High Blood Pressure During Pregnancy. https://www.cdc.gov/bloodpressure/pregnancy.htm"
        )

        val que16 = Question(
            16,
            "Which of these symptoms can be a symptom of preeclampsia?",
            R.drawable.ic_breathing,
            "Reflux and feeling full faster",
            "Trouble breathing",
            "Restless leg syndrome",
            "Frequent urination",
            2,
            "Centers for Disease Control and Prevention (2021, May 6). High Blood Pressure During Pregnancy. https://www.cdc.gov/bloodpressure/pregnancy.htm"
        )

        val que17 = Question(
            17,
            "What are the symptoms that typically characterize preeclampsia?",
            R.drawable.ic_blood_pressure,
            "Sore, bleeding gums",
            "Sudden development of high blood pressure and protein in urine",
            "Restless leg syndrome",
            "Indigestion",
            2,
            "Centers for Disease Control and Prevention (2021, May 6). High Blood Pressure During Pregnancy. https://www.cdc.gov/bloodpressure/pregnancy.htm"
        )

        val que18 = Question(
            18,
            "Which of these statements is false?",
            R.drawable.ic_preeclampsia,
            "A part of women with preeclampsia can develop seizures.",
            "Approximately 1 in 25 pregnant women in the United States experience preeclampsia.",
            "Women who have chronic hypertension can get preeclampsia.",
            "Women who don't have any symptoms of preeclampsia can't have preeclampsia.",
            4,
            "Centers for Disease Control and Prevention (2021, May 6). High Blood Pressure During Pregnancy. https://www.cdc.gov/bloodpressure/pregnancy.htm"
        )

        val que19 = Question(
            19,
            "Which of these statements is true?",
            R.drawable.ic_baby_sex,
            "A NIPT test can reveal the baby's sex.",
            "The shape of a woman's belly can determine the baby's sex.",
            "Higher baby's heart rates indicate a higher chance of having a girl.",
            "Baby's sex have an impact on the frequency of the morning sickness during the first trimester.",
            1,
            " 1. Devaney, S. A., Palomaki, G. E., Scott, J. A., & Bianchi, D. W. (2011). Noninvasive fetal sex determination using cell-free fetal DNA: a systematic review and meta-analysis. JAMA, 306(6), 627–636. https://doi.org/10.1001/jama.2011.1114 \n 2. University of Utah (2019, May 7). Which pregnancy myths are actually true? https://healthcare.utah.edu/the-scope/shows.php?shows=0_qtd1io6q&fbclid=IwAR2xl3aYGRBM7OXEFl_2CDPDooTZFr5JVysPFXPS9Zz8OXvEzOCF95jZlHs"
        )

        val que20 = Question(
            20,
            "Which of these statements is true?",
            R.drawable.ic_cold_flu,
            "Cocoa butter prevents stretch marks.",
            "The mean age of women having their first child in the United States has increased from 24.9 years in 2000 to 26.3 years in 2014.",
            "A pregnant woman can have a glass of wine once in a while without exposing her child at risk.",
            "A woman should eat for two during pregnancy.",
            2,
            " 1. Korgavkar, K., & Wang, F. (2015). Stretch marks during pregnancy: a review of topical prevention. The British journal of dermatology, 172(3), 606–615. https://doi.org/10.1111/bjd.13426 \n 2. Centers for Disease Control and Prevention (2016, January 14). Mean Age of Mothers is on the Rise: United States, 2000–2014. https://www.cdc.gov/nchs/products/databriefs/db232.htm \n 3. Centers for Disease Control and Prevention (2021, December 14). Alcohol Use During Pregnancy. https://www.cdc.gov/ncbddd/fasd/alcohol-use.html \n 4. Kominiarek, M. A., & Rajan, P. (2016). Nutrition Recommendations in Pregnancy and Lactation. The Medical clinics of North America, 100(6), 1199–1215. https://doi.org/10.1016/j.mcna.2016.06.004"
        )

        val que21 = Question(
            21,
            "Which of these statements is false?",
            R.drawable.ic_records,
            "The highest number of babies born at a single birth to survive was nine.",
            "Morning sickness only happens in the morning.",
            "The heaviest newborn on record weighted 22 pounds and 8 ounces (10.20 kg).",
            "Babies can cry in the womb starting at 28 weeks.",
            2,
            " 1. Guinness World Records (n.d.). Most children delivered at a single birth to survive. https://www.guinnessworldrecords.com/world-records/most-children-delivered-at-a-single-birth-to-survive \n 2. Dean E. (2016). Morning sickness. Nursing standard (Royal College of Nursing (Great Britain) : 1987), 30(50), 15. https://doi.org/10.7748/ns.30.50.15.s16 \n 3. Guinness World Records (n.d.). Heaviest birth. https://www.guinnessworldrecords.com/world-records/heaviest-birth \n 4. Reissland, N., Francis, B., & Mason, J. (2013). Can healthy fetuses show facial expressions of \"pain\" or \"distress\"?. PloS one, 8(6), e65530. https://doi.org/10.1371/journal.pone.0065530"
        )

        val que22 = Question(
            22,
            "Which of these statements is false?",
            R.drawable.ic_c_section,
            "Babies who have ovaries are born with a fixed number of egg cells established before birth that decline with increasing age.",
            "The oldest woman to have a baby in history was 66 years old.",
            "During pregnancy, a woman's blood volume increases 40 to 50 percent.",
            "If a woman had a c-section in the past, she can't give birth vaginally.",
            4,
            " 1. Wallace, W. H., & Kelsey, T. W. (2010). Human ovarian reserve from conception to the menopause. PloS one, 5(1), e8772. https://doi.org/10.1371/journal.pone.0008772 \n 2. Guinness World Records (n.d.). Oldest person to give birth. https://www.guinnessworldrecords.com/world-records/oldest-person-to-give-birth \n 3. Hytten F. (1985). Blood volume changes in normal pregnancy. Clinics in haematology, 14(3), 601–612. \n 4. ACOG Practice Bulletin No. 205: Vaginal Birth After Cesarean Delivery. (2019). Obstetrics and gynecology, 133(2), e110–e127. https://doi.org/10.1097/AOG.0000000000003078"
        )

        val que23 = Question(
            1,
            "Which of these statements is a myth?",
            R.drawable.ic_myth,
            "Pregnant women may experience changes in their sense of taste.",
            "During pregnancy, a woman's heart rate may increase by approximately 10%.",
            "A pregnant woman can smoke a cigarette once in a while without exposing her child at risk.",
            "It is recommended that pregnant woman to wear compression stockings to prevent and treat edema.",
            3,
            " 1. Kuga, M., Ikeda, M., Suzuki, K., & Takeuchi, S. (2002). Changes in gustatory sense during pregnancy. Acta oto-laryngologica. Supplementum, (546), 146–153. https://doi.org/10.1080/00016480260046544 \n 2. Loerup, L., Pullon, R. M., Birks, J., Fleming, S., Mackillop, L. H., Gerry, S., & Watkinson, P. J. (2019). Trends of blood pressure and heart rate in normal pregnancies: a systematic review and meta-analysis. BMC medicine, 17(1), 167. https://doi.org/10.1186/s12916-019-1399-1 \n 3. Centers for Disease Control and Prevention (2022, May 5). Smoking, Pregnancy, and Babies. https://www.cdc.gov/tobacco/campaign/tips/diseases/pregnancy.html \n 4. Ochalek, K., Pacyga, K., Curyło, M., Frydrych-Szymonik, A., & Szygula, Z. (2017). Risk Factors Related to Lower Limb Edema, Compression, and Physical Activity During Pregnancy: A Retrospective Study. Lymphatic research and biology, 15(2), 166–171. https://doi.org/10.1089/lrb.2016.0038"
        )

        val que24 = Question(
            24,
            "Which type of medical testing should be avoided during pregnancy, unless it is recommended by a doctor?",
            R.drawable.ic_xray,
            "Computed tomography (CT)",
            "Ultrasound",
            "Genetic testing",
            "Magnetic resonance imaging (MRI)",
            1,
            " 1. Mattsson, S., Leide-Svegborn, S., & Andersson, M. (2021). X-RAY AND MOLECULAR IMAGING DURING PREGNANCY AND BREASTFEEDING-WHEN SHOULD WE BE WORRIED?. Radiation protection dosimetry, 195(3-4), 339–348. https://doi.org/10.1093/rpd/ncab041 \n 2. Jelin, A. C., Sagaser, K. G., & Wilkins-Haug, L. (2019). Prenatal Genetic Testing Options. Pediatric clinics of North America, 66(2), 281–293. https://doi.org/10.1016/j.pcl.2018.12.016"
        )

        val que25 = Question(
            25,
            "Which of these statements is false?",
            R.drawable.ic_which_false,
            "Pregnancy should interfere with scheduled routine dental procedures.",
            "Women can get pregnant when they’re already pregnant.",
            "There is no known advantage to activity restriction for pregnant women.",
            "It is recommended that pregnant women wear lap and shoulder seatbelts while in a motor vehicle.",
            1,
            " 1. Fox N. S. (2018). Dos and Don'ts in Pregnancy: Truths and Myths. Obstetrics and gynecology, 131(4), 713–721. https://doi.org/10.1097/AOG.0000000000002517 \n 2. Tarín, J. J., García-Pérez, M. A., Hermenegildo, C., & Cano, A. (2013). Unpredicted ovulations and conceptions during early pregnancy: an explanatory mechanism of human superfetation. Reproduction, fertility, and development, 25(7), 1012–1019. https://doi.org/10.1071/RD12238"
        )

        val que26 = Question(
            26,
            "Which of these statements is false?",
            R.drawable.ic_spicy,
            "Babies can cry in the womb.",
            "Fetal cells have a remarkable ability to travel across the placenta into the mother.",
            "Carpal tunnel syndrome occurs in 31 to 62 percent of pregnant women.",
            "Sexual intercourse can induce labor.",
            4,
            " 1. Reissland, N., Francis, B., & Mason, J. (2013). Can healthy fetuses show facial expressions of \"pain\" or \"distress\"?. PloS one, 8(6), e65530. https://doi.org/10.1371/journal.pone.0065530 \n 2. Dawe, G. S., Tan, X. W., & Xiao, Z. C. (2007). Cell migration from baby to mother. Cell adhesion & migration, 1(1), 19–27. \n 3. Meems, M., Truijens, S., Spek, V., Visser, L. H., & Pop, V. J. (2015). Prevalence, course and determinants of carpal tunnel syndrome symptoms during pregnancy: a prospective study. BJOG : an international journal of obstetrics and gynaecology, 122(8), 1112–1118. https://doi.org/10.1111/1471-0528.13360 \n 4. Carbone, L., De Vivo, V., Saccone, G., D'Antonio, F., Mercorio, A., Raffone, A., Arduino, B., D'Alessandro, P., Sarno, L., Conforti, A., Maruotti, G. M., Alviggi, C., & Zullo, F. (2019). Sexual Intercourse for Induction of Spontaneous Onset of Labor: A Systematic Review and Meta-Analysis of Randomized Controlled Trials. The journal of sexual medicine, 16(11), 1787–1795. https://doi.org/10.1016/j.jsxm.2019.08.002"
        )

        val que27 = Question(
            27,
            "Which of these body changes is not expected to happen during pregnancy?",
            R.drawable.ic_fingers,
            "Stretch marks",
            "Vocal abnormalities",
            "Chloasma (the “mask” of pregnancy)",
            "Fingers length increase",
            4,
            " 1. Chang, A. L., Agredano, Y. Z., & Kimball, A. B. (2004). Risk factors associated with striae gravidarum. Journal of the American Academy of Dermatology, 51(6), 881–885. https://doi.org/10.1016/j.jaad.2004.05.030 \n 2. Ulkumen, B., Artunc-Ulkumen, B., & Celik, O. (2021). Impact of pregnancy on voice: a prospective observational study. Logopedics, phoniatrics, vocology, 1–6. Advance online publication. https://doi.org/10.1080/14015439.2021.1903076 \n 3. Bolanca, I., Bolanca, Z., Kuna, K., Vuković, A., Tuckar, N., Herman, R., & Grubisić, G. (2008). Chloasma--the mask of pregnancy. Collegium antropologicum, 32 Suppl 2, 139–141."
        )

        val que28 = Question(
            28,
            "Which of these supplements is safe during pregnancy?",
            R.drawable.ic_ginger,
            "Ginger",
            "Vitamin E",
            "Black cohosh",
            "Dong quai",
            1,
            " 1. Ding, M., Leach, M., & Bradley, H. (2013). The effectiveness and safety of ginger for pregnancy-induced nausea and vomiting: a systematic review. Women and birth : journal of the Australian College of Midwives, 26(1), e26–e30. https://doi.org/10.1016/j.wombi.2012.08.001 \n 2. Office of Dietary Supplements, National Institutes of Health (2021, March 26). Vitamin E: Fact sheet for health professionals. https://ods.od.nih.gov/factsheets/VitaminE-HealthProfessional/ \n 3. Office of Dietary Supplements, National Institutes of Health (2020, June 3). Black Cohosh: Fact sheet for health professionals. https://ods.od.nih.gov/factsheets/BlackCohosh-HealthProfessional/ \n 4. MedlinePlus, National Library of Medicine, National Institutes of Health (2021, September 8). Dong Quai. https://medlineplus.gov/druginfo/natural/936.html"
        )

        val que29 = Question(
            29,
            "Which of these symptoms is not a sign of early pregnancy?",
            R.drawable.ic_fever,
            "Light vaginal bleeding or spotting",
            "Tender, swollen breasts or nipples",
            "Hyperpyrexia (very high fever)",
            "Frequent urination",
            3,
            " 1. Hasan, R., Baird, D. D., Herring, A. H., Olshan, A. F., Jonsson Funk, M. L., & Hartmann, K. E. (2010). Patterns and predictors of vaginal bleeding in the first trimester of pregnancy. Annals of epidemiology, 20(7), 524–531. https://doi.org/10.1016/j.annepidem.2010.02.006 \n 2. Eunice Kennedy Shriver National Institute of Child Health and Human Development (2017, January 1). What are some common signs of pregnancy? https://www.nichd.nih.gov/health/topics/pregnancy/conditioninfo/signs \n 3. Shahrukh Hashmi, S., Gallaway, M. S., Waller, D. K., Langlois, P. H., Hecht, J. T., & National Birth Defects Prevention Study (2010). Maternal fever during early pregnancy and the risk of oral clefts. Birth defects research. Part A, Clinical and molecular teratology, 88(3), 186–194. https://doi.org/10.1002/bdra.20646"
        )

        val que30 = Question(
            30,
            "Which of these medications is generally considered safe during pregnancy?",
            R.drawable.ic_medications,
            "Aspirin in high-doses (more than 100 mg/day)",
            "Diclofenac",
            "Ibuprofen",
            "Paracetamol/Acetaminophen",
            4,
            " 1. Toda K. (2017). Is acetaminophen safe in pregnancy?. Scandinavian journal of pain, 17, 445–446. https://doi.org/10.1016/j.sjpain.2017.09.007 \n 2. Nezvalová-Henriksen, K., Spigset, O., & Nordeng, H. (2013). Effects of ibuprofen, diclofenac, naproxen, and piroxicam on the course of pregnancy and pregnancy outcome: a prospective cohort study. BJOG : an international journal of obstetrics and gynaecology, 120(8), 948–959. https://doi.org/10.1111/1471-0528.12192 \n 3. Hertz-Picciotto, I., Hopenhayn-Rich, C., Golub, M., & Hooper, K. (1990). The risks and benefits of taking aspirin during pregnancy. Epidemiologic reviews, 12, 108–148. https://doi.org/10.1093/oxfordjournals.epirev.a036049 \n 4. FDA (2022, September 1). FDA recommends avoiding use of NSAIDs in pregnancy at 20 weeks or later because they can result in low amniotic fluid. https://www.fda.gov/drugs/drug-safety-and-availability/fda-recommends-avoiding-use-nsaids-pregnancy-20-weeks-or-later-because-they-can-result-low-amniotic"
        )

        val que31 = Question(
            31,
            "Which of these supplements is safe during pregnancy?",
            R.drawable.ic_fish_oil,
            "Goldenseal",
            "Fish oil",
            "Yohimbe",
            "Blue cohosh",
            2,
            " 1. National Center for Complementary and Integrative Health, National Institutes of Health (2021, March). Goldenseal. https://www.nccih.nih.gov/health/goldenseal \n 2. Makrides, M., Gibson, R. A., McPhee, A. J., Yelland, L., Quinlivan, J., Ryan, P., & DOMInO Investigative Team (2010). Effect of DHA supplementation during pregnancy on maternal depression and neurodevelopment of young children: a randomized controlled trial. JAMA, 304(15), 1675–1683. https://doi.org/10.1001/jama.2010.1507 \n 3. National Center for Complementary and Integrative Health, National Institutes of Health (2020, November). Yohimbe. https://www.nccih.nih.gov/health/yohimbe \n 4. Dugoua, J. J., Perri, D., Seely, D., Mills, E., & Koren, G. (2008). Safety and efficacy of blue cohosh (Caulophyllum thalictroides) during pregnancy and lactation. The Canadian journal of clinical pharmacology = Journal canadien de pharmacologie clinique, 15(1), e66–e73."
        )

        val que32 = Question(
            32,
            "Which of these supplements is not safe during pregnancy?",
            R.drawable.ic_vitamin_a,
            "Magnesium",
            "Vitamin D",
            "Vitamin A in high doses (more than 3,000 mcg RAE [10,000 IU] daily)",
            "Folate",
            3,
            " 1. Office of Dietary Supplements, National Institutes of Health (2022, June 15). Vitamin A and Carotenoids: Fact sheet for health professionals. ods.od.nih.gov/factsheets/VitaminA-HealthProfessional \n 2. Centers for Disease Control and Prevention (2022, June 15). Folic Acid. https://www.cdc.gov/ncbddd/folicacid/about.html \n 3. Office of Dietary Supplements, National Institutes of Health (2022, August 12). Vitamin D: Fact sheet for health professionals. https://ods.od.nih.gov/factsheets/VitaminD-HealthProfessional/ \n 4. Zarean, E., & Tarjan, A. (2017). Effect of Magnesium Supplement on Pregnancy Outcomes: A Randomized Control Trial. Advanced biomedical research, 6, 109. https://doi.org/10.4103/2277-9175.213879"
        )

        val que33 = Question(
            33,
            "Which of these meals is safe to eat during pregnancy?",
            R.drawable.ic_pastry,
            "Spinach puff pastry",
            "Salami",
            "Brie cheese",
            "Parmesan made with unpasteurized milk",
            1,
            "FDA (2018, September 27). Listeria from Food Safety for Moms to Be. https://www.fda.gov/food/health-educators/listeria-food-safety-moms-be"
        )

        val que34 = Question(
            34,
            "Which of these meals is safe to eat during pregnancy?",
            R.drawable.ic_prawns,
            "Vegetarian pâté",
            "Well-done grilled prawns",
            "Chicken liver",
            "Prosciutto pizza",
            2,
            " 1. FDA (2018, September 27). Listeria from Food Safety for Moms to Be. https://www.fda.gov/food/health-educators/listeria-food-safety-moms-be \n 2. Bastos Maia, S., Rolland Souza, A. S., Costa Caminha, M. F., Lins da Silva, S., Callou Cruz, R., Carvalho Dos Santos, C., & Batista Filho, M. (2019). Vitamin A and Pregnancy: A Narrative Review. Nutrients, 11(3), 681. https://doi.org/10.3390/nu11030681"
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        questionsList.add(que11)
        questionsList.add(que12)
        questionsList.add(que13)
        questionsList.add(que14)
        questionsList.add(que15)
        questionsList.add(que16)
        questionsList.add(que17)
        questionsList.add(que18)
        questionsList.add(que19)
        questionsList.add(que20)
        questionsList.add(que21)
        questionsList.add(que22)
        questionsList.add(que23)
        questionsList.add(que24)
        questionsList.add(que25)
        questionsList.add(que26)
        questionsList.add(que27)
        questionsList.add(que28)
        questionsList.add(que29)
        questionsList.add(que30)
        questionsList.add(que31)
        questionsList.add(que32)
        questionsList.add(que33)
        questionsList.add(que34)

        questionsList.shuffle()

        return questionsList

    }
}