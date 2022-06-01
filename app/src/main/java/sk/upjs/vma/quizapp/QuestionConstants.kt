package sk.upjs.vma.quizapp

object QuestionConstants {



    fun getHistoryQuestions():ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1,
            "When was Slovak republic created?",
            "1991",
            "1998",
            "2003",
            "1993",
            4)
        questionList.add(que1)

        val que2 = Question(
            2,
            "When World War 2 ended?",
            "1948",
            "1887",
            "1945",
            "2022",
            3)
        questionList.add(que2)

        val que3= Question(
            3,
            "What is the name of American president?",
            "Donald Trump",
            "Joe Biden",
            "Zuzana Plackova",
            "Jozko Vajda",
            2
             )
        questionList.add(que3)

        val que4 = Question(
            4,
        "Who was first Slovakian president?",
            "Michal Kovac",
            "Ludovit Stur",
            "Janko Hrasko",
            "Vladimir Putin",
            1
            )
        questionList.add(que4)

        val que5 = Question(
            5,
            "What was the capital city of Czechoslovakia?",
            "Bratislava",
            "Kosice",
            "Hradec Kralove",
            "Praha",
            4
            )
        questionList.add(que5)

        val que6 = Question(
            6,
            "How many years did czechoslovakia existed?",
            "75",
            "112",
            "87",
            "10",
            1
            )
        questionList.add(que6)

        val que7 = Question(
            7,
            "Which country invented vodka?",
            "Moldova",
            "Hungary",
            "Russia",
            "Germany",
            3
             )

        questionList.add(que7)

        return questionList
    }

    fun getMathsQuestions():ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1,
            "2+2",
            "devat",
            "4",
            "16",
            "8",
            2)
        questionList.add(que1)

        val que2 = Question(
            2,
            "How much is pi?",
            "3,14159",
            "1,41",
            "987654",
            "cake",
            1)
        questionList.add(que2)

        val que3= Question(
            3,
            "100-(100)^2?",
            "-Too much",
            "1",
            "2",
            "100",
            1
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            "how many numbers exists?",
            "1.000.000",
            "250.000",
            "10",
            "infinite",
            4
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            "1^2",
            "12",
            "2",
            "1",
            "11",
            3
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            "2^2",
            "4",
            "99",
            "12",
            "10",
            1
        )
        questionList.add(que6)

        val que7 = Question(
            7,
            "which number is prime?",
            "8",
            "4",
            "1",
            "64",
            3
        )

        questionList.add(que7)

        return questionList
    }

    fun getSportsQuestions():ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1,
            "Who is most popular basketball player?",
            "Michael Jordan",
            "Ovechkin",
            "Hamsik",
            "Vlhova",
            1)
        questionList.add(que1)

        val que2 = Question(
            2,
            "In Winter Olympic games 2022 Slovakian national hockey team won: ",
            "Golden medal",
            "Silver medal",
            "bronze medal",
            "nothing",
            3)
        questionList.add(que2)

        val que3= Question(
            3,
            "Which sport is untraditional",
            "ringo",
            "football",
            "basketball",
            "hockey",
            1
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            "How many minutes does football takes to play",
            "80",
            "100",
            "60",
            "90",
            4
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            "How many minutes does hockey takes to play",
            "80",
            "100",
            "60",
            "90",
            3
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            "Which year did slovakia win golend medal in hockey?",
            "200",
            "2012",
            "2002",
            "2003",
            3
        )
        questionList.add(que6)

        val que7 = Question(
            7,
            "Which one is sport?",
            "hockey",
            "killing",
            "war",
            "programming",
            1
        )

        questionList.add(que7)

        return questionList
    }

    fun getMusicQuestions():ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1,
            "When did Freddie Mercury die?",
            "1991",
            "2000",
            "1851",
            "2050",
            1)
        questionList.add(que1)

        val que2 = Question(
            2,
            "Most popular Meky's Zbirka song",
            "Atlantida",
            "Mur nasich lasok",
            "22 dni",
            "Biely kvet",
            1)
        questionList.add(que2)

        val que3= Question(
            3,
            "What instrument is Meky Zbirka playing",
            "Guitar",
            "Trumpet",
            "Tuba",
            "Flaute",
            1
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            "When did Michael Jackson die?",
            "2000",
            "2023",
            "1998",
            "2009",
            4
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            "How many songs did Michael Jackson record?",
            "Too many to count",
            "1",
            "2",
            "3",
            1
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            "Question",
            "wront",
            "wront",
            "correct",
            "wront",
            3
        )
        questionList.add(que6)

        val que7 = Question(
            7,
            "Question",
            "wront",
            "wront",
            "correct",
            "wront",
            3
        )

        questionList.add(que7)

        return questionList
    }
}