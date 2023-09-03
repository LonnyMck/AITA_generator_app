package com.example.aita_generator_app

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import kotlin.random.Random.Default.nextInt

class SampleViewModel (
    app: Application
): AndroidViewModel( app ){
    var age by mutableStateOf("AGE")
    var gender by mutableStateOf("GENDER")
    var relation by mutableStateOf("RELATION")
    var starter by mutableStateOf("I (___)")
    var location by mutableStateOf("___")
    var involves by mutableStateOf("___")
    var opinion by mutableStateOf("___")
    var commenter by mutableStateOf("___")
    fun handleAction( action: Action ){
        when(action){
            Action.ButtonOne -> randoClick1()
            Action.ButtonTwo -> randoClick2()
        }
    }

    fun randoClick1(){

        val optionage = nextInt(0,LISTAGE.size)
        age = LISTAGE[optionage].toString()

        val optiongender = nextInt(0, LISTGENDER.size)
        gender = LISTGENDER[optiongender]

        val optionrelation = nextInt(0, LISTRELATION.size)
        relation = LISTRELATION[optionrelation]

        val fiftyfifty = nextInt(0,2)

        if (fiftyfifty == 0){
            starter = "I ($age$gender)"
        }else{
            starter = "My ($age$gender) $relation"
        }

        val optioninvolves = nextInt(0, LISTINVOLVES.size)
        involves = LISTINVOLVES[optioninvolves]

        val optionlocation = nextInt(0, LISTLOCATION.size)
        location = LISTLOCATION[optionlocation]
    }

    fun randoClick2(){
        val optionopinion = nextInt(0, LISTOPINION.size)
        opinion = LISTOPINION[optionopinion]

        val optioncommenter = nextInt(0, LISTCOMMENTER.size)
        commenter = LISTCOMMENTER[optioncommenter]
    }



    sealed class Action {
        object ButtonOne: Action()
        object ButtonTwo: Action()
    }

    companion object {
        val LISTAGE = listOf<Int>(3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70)
        val LISTGENDER = listOf<String>("M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","NB","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F",)
        val LISTRELATION = listOf<String>("Parent","Mom", "Dad", "Grandma", "Grandpappy","Papa","Grandparent","Child","Son","Daughter","Cousin","Sibling", "Long-term Long-Distance Low-Commitment Casual Girlfriend","Partner","Girlfriend","Boyfriend","Spouse","Co-worker","Dog","Cat","Pizza Delivery Guy","FWB","Mother-in-Law","Hairdresser")

        val LISTLOCATION = listOf<String>("Wedding", "Papa's Pizzeria","The Morgue","Buckingham Palace", "The White House", "A Tropical Island", "Kyrgzstan", "Quebec","The middle of the dessert, no civilization in site", "Mickey Mouse Clubhouse","AirBNB", "Family Christmas Event", "Home", "Vacation", "Bachelor Party", "Bachelorette Party", "FWB's house","Cruiseship","Middle of the woods", "Sex Dungeon", "Relative's House", "Orgy", "Office", "Frat Party", "Funeral")
        val LISTINVOLVES = listOf<String>("Grandma's Secret Recipe","Fire","Rival Households","Immortality", "A six-fingered hand", "Petty Family Drama", "A magical potion that turns you gay at midnight","DIY conversion therapy (you couldn't afford actual conversion therapy)","A swarm of bees", "Strippers", "Sex", "Divorce", "Infidelity", "Faking Sick", "The US government", "pseudo-incest","a bad haircut", "Funeral Arrangements")

        val LISTOPINION = listOf<String>("YTA","YTA","YTA","YTA","YTA","NTA","NTA","NTA","NTA","ESH","NAH","INFO")
        val LISTCOMMENTER = listOf<String>("Santa", "A reddit user who tries to humblebrag about himself whenever he can", " A tiktok user who didn't listen and is trying to get as many likes as possible in the comment section", "A reddit user trying to break up as many couples as he can","OP's favourite author", "OP's therapist","An alien trying to learn about humans and their customs from Reddit","A time traveler trying to subtly find out what year it is","a concerned mother", "a firefighter", "your 9-month old son", "the president","OP's grandmother", "a femcel", "a normal well-adjusted individual", "OP's one-night-stand", "a tiktok commenter")
    }
}