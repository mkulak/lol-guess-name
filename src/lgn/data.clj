(ns lgn.data)

(def champs {
              "4cf2896" {:id "4cf2896", :name "Teemo", :gender :male}
              "2bdbe13d" {:id "2bdbe13d", :name "Dr. Mundo", :gender :male}
              "28fe308c" {:id "28fe308c", :name "Nidalee", :gender :female}
              "3ff0654" {:id "3ff0654", :name "Elise", :gender :female}
              "12201" {:id "12201", :name "Jax", :gender :male}
              "6c462136" {:id "6c462136", :name "Volibear", :gender :male}
              "2ce0b7a9" {:id "2ce0b7a9", :name "Lissandra", :gender :female}
              "78913cb4" {:id "78913cb4", :name "Lee Sin", :gender :male}
              "12bef" {:id "12bef", :name "Lux", :gender :female}
              "752a9cd2" {:id "752a9cd2", :name "Anivia", :gender :female}
              "6e4fc783" {:id "6e4fc783", :name "Rengar", :gender :male}
              "1f7ad1" {:id "1f7ad1", :name "Bard", :gender :male}
              "20fcaa" {:id "20fcaa", :name "Ekko", :gender :male}
              "6487af33" {:id "6487af33", :name "LeBlanc", :gender :female}
              "233b69" {:id "233b69", :name "Jinx", :gender :female}
              "6c0c47bf" {:id "6c0c47bf", :name "Soraka", :gender :female}
              "21028fbe" {:id "21028fbe", :name "Shyvana", :gender :female}
              "4c25df8" {:id "4c25df8", :name "Shaco", :gender :male}
              "43e303b3" {:id "43e303b3", :name "Pantheon", :gender :male}
              "3c74911" {:id "3c74911", :name "Amumu", :gender :male}
              "6aba03a4" {:id "6aba03a4", :name "Thresh", :gender :male}
              "4c321e9" {:id "4c321e9", :name "Sivir", :gender :female}
              "7f9c3263" {:id "7f9c3263", :name "Gragas", :gender :male}
              "2cbe18d0" {:id "2cbe18d0", :name "Alistar", :gender :male}
              "40bd71b" {:id "40bd71b", :name "Fiora", :gender :female}
              "7aa94785" {:id "7aa94785", :name "Miss Fortune", :gender :female}
              "3e45544" {:id "3e45544", :name "Corki", :gender :male}
              "6d6ed54f" {:id "6d6ed54f", :name "Rumble", :gender :male}
              "2450f2" {:id "2450f2", :name "Lulu", :gender :female}
              "15dfc" {:id "15dfc", :name "Zac", :gender :male}
              "4e9b7e5" {:id "4e9b7e5", :name "Varus", :gender :male}
              "7995dd32" {:id "7995dd32", :name "Darius", :gender :male}
              "21ef78" {:id "21ef78", :name "Gnar", :gender :male}
              "1f48cf" {:id "1f48cf", :name "Ashe", :gender :female}
              "ad3" {:id "ad3", :name "Vi", :gender :female}
              "13a5bdf1" {:id "13a5bdf1", :name "Gangplank", :gender :male}
              "27692f" {:id "27692f", :name "Sona", :gender :female}
              "5140225" {:id "5140225", :name "Yasuo", :gender :male}
              "eac21d6" {:id "eac21d6", :name "Blitzcrank", :gender :male}
              "274dde" {:id "274dde", :name "Shen", :gender :male}
              "7a1d85fb" {:id "7a1d85fb", :name "Kha'Zix", :gender :monster}
              "7fecda4d" {:id "7fecda4d", :name "Nautilus", :gender :male}
              "6b812215" {:id "6b812215", :name "Syndra", :gender :female}
              "15faefa2" {:id "15faefa2", :name "Mordekaiser", :gender :male}
              "2b1cd3cd" {:id "2b1cd3cd", :name "Kalista", :gender :female}
              "7a7de14c" {:id "7a7de14c", :name "Draven", :gender :male}
              "1b8a2666" {:id "1b8a2666", :name "Orianna", :gender :female}
              "92733da" {:id "92733da", :name "Malzahar", :gender :male}
              "89d7d6a" {:id "89d7d6a", :name "Malphite", :gender :male}
              "2477898b" {:id "2477898b", :name "Jarvan IV", :gender :male}
              "64e751e5" {:id "64e751e5", :name "Wukong", :gender :male}
              "440b5e4" {:id "440b5e4", :name "Jayce", :gender :male}
              "3d75b67" {:id "3d75b67", :name "Brand", :gender :male}
              "77b05bc4" {:id "77b05bc4", :name "Lucian", :gender :male}
              "6e8880f3" {:id "6e8880f3", :name "Rammus", :gender :male}
              "44eb450" {:id "44eb450", :name "Karma", :gender :female}
              "3c7a29d" {:id "3c7a29d", :name "Annie", :gender :female}
              "3ef730f" {:id "3ef730f", :name "Diana", :gender :female}
              "724a488e" {:id "724a488e", :name "Twisted Fate", :gender :male}
              "44ece7c" {:id "44ece7c", :name "Kayle", :gender :female}
              "1f6342" {:id "1f6342", :name "Azir", :gender :male}
              "79b85900" {:id "79b85900", :name "Kog'Maw", :gender :monster}
              "7a41991d" {:id "7a41991d", :name "Kennen", :gender :male}
              "6c629072" {:id "6c629072", :name "Singed", :gender :male}
              "14c68932" {:id "14c68932", :name "Master Yi", :gender :male}
              "2539ee" {:id "2539ee", :name "Nunu", :gender :male}
              "4165561" {:id "4165561", :name "Garen", :gender :male}
              "38dd7c5d" {:id "38dd7c5d", :name "Kindred", :gender :female}
              "770fdd48" {:id "770fdd48", :name "Maokai", :gender :male}
              "15e79" {:id "15e79", :name "Zed", :gender :male}
              "17763307" {:id "17763307", :name "Xin Zhao", :gender :male}
              "4ac3725" {:id "4ac3725", :name "Quinn", :gender :female}
              "6410f690" {:id "6410f690", :name "Xerath", :gender :male}
              "49b7ffa" {:id "49b7ffa", :name "Poppy", :gender :female}
              "199380ae" {:id "199380ae", :name "Renekton", :gender :male}
              "4cd719e" {:id "4cd719e", :name "Talon", :gender :male}
              "7f9c6b2e" {:id "7f9c6b2e", :name "Graves", :gender :male}
              "71963f" {:id "71963f", :name "Fiddlesticks", :gender :male}
              "7cf83738" {:id "7cf83738", :name "Irelia", :gender :female}
              "5258de4" {:id "5258de4", :name "Ziggs", :gender :male}
              "5e20b928" {:id "5e20b928", :name "Tristana", :gender :female}
              "61cf16eb" {:id "61cf16eb", :name "Yorick", :gender :male}
              "216b63" {:id "216b63", :name "Fizz", :gender :male}
              "607194cb" {:id "607194cb", :name "Zilean", :gender :male}
              "7d49be2e" {:id "7d49be2e", :name "Illaoi", :gender :female}
              "4cd875f" {:id "4cd875f", :name "Taric", :gender :male}
              "2abdce" {:id "2abdce", :name "Zyra", :gender :female}
              "7caaeff3" {:id "7caaeff3", :name "Ezreal", :gender :male}
              "2b7637ce" {:id "2b7637ce", :name "Karthus", :gender :male}
              "3d75c49" {:id "3d75c49", :name "Braum", :gender :male}
              "1e0149ba" {:id "1e0149ba", :name "Vladimir", :gender :male}
              "3e9f3087" {:id "3e9f3087", :name "Tahm Kench", :gender :male}
              "6e516fbd" {:id "6e516fbd", :name "Rek'Sai", :gender :monster}
              "44f413de" {:id "44f413de", :name "Kassadin", :gender :male}
              "2752d5" {:id "2752d5", :name "Sion", :gender :male}
              "59bda27e" {:id "59bda27e", :name "Warwick", :gender :male}
              "76709b19" {:id "76709b19", :name "Heimerdinger", :gender :male}
              "4ce32c45" {:id "4ce32c45", :name "Tryndamere", :gender :male}
              "4e330af" {:id "4e330af", :name "Urgot", :gender :male}
              "3c61514" {:id "3c61514", :name "Akali", :gender :female}
              "26f4ee81" {:id "26f4ee81", :name "Sejuani", :gender :female}
              "45e9229" {:id "45e9229", :name "Leona", :gender :female}
              "74785d27" {:id "74785d27", :name "Aatrox", :gender :male}
              "24b82bc6" {:id "24b82bc6", :name "Trundle", :gender :male}
              "7c3a6648" {:id "7c3a6648", :name "Caitlyn", :gender :female}
              "4c93042" {:id "4c93042", :name "Swain", :gender :male}
              "69ea840d" {:id "69ea840d", :name "Twitch", :gender :male}
              "674531a1" {:id "674531a1", :name "Viktor", :gender :male}
              "4163f58" {:id "4163f58", :name "Galio", :gender :male}
              "478ff9e" {:id "478ff9e", :name "Nasus", :gender :male}
              "677db527" {:id "677db527", :name "Vel'Koz", :gender :monster}
              "112c03c1" {:id "112c03c1", :name "Evelynn", :gender :female}
              "4408dea" {:id "4408dea", :name "Janna", :gender :female}
              "4b509e8" {:id "4b509e8", :name "Riven", :gender :female}
              "677eaae2" {:id "677eaae2", :name "Veigar", :gender :male}
              "271bd2" {:id "271bd2", :name "Ryze", :gender :male}
              "1f20be" {:id "1f20be", :name "Ahri", :gender :female}
              "6d44f705" {:id "6d44f705", :name "Hecarim", :gender :male}
              "24eeaf" {:id "24eeaf", :name "Nami", :gender :female}
              "70088b88" {:id "70088b88", :name "Cho'Gath", :gender :monster}
              "258ae2" {:id "258ae2", :name "Olaf", :gender :male}
              "45b3130d" {:id "45b3130d", :name "Katarina", :gender :female}
              "4e9d145" {:id "4e9d145", :name "Vayne", :gender :female}
              "4437ecd1" {:id "4437ecd1", :name "Cassiopeia", :gender :female}
              "282a08" {:id "282a08", :name "Udyr", :gender :male}
              "52df7d03" {:id "52df7d03", :name "Morgana", :gender :female}
              "45f8b226" {:id "45f8b226", :name "Nocturne", :gender :male}
              "1d37dbae" {:id "1d37dbae", :name "Skarner", :gender :male}
              })

(def result-desc [
                   "Seems like you intentionally pick wrong answers" ;0
                   "Have you ever heard of League of Legends?" ;1
                   "You pick random answers" ;2
                   "You pick random answers" ;3
                   "Unimpressive" ;4
                   "U need to learn dat champz" ;5
                   "Average" ;6
                   "Not bad" ;7
                   "Quite good" ;8
                   "You are pro" ;9
                   "Cheat0r!" ;10
                   ])

