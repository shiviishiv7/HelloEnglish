package com.shiviishiv7.helloenglish;


import com.shiviishiv7.helloenglish.QuestionSource.How;
import com.shiviishiv7.helloenglish.QuestionSource.What;
import com.shiviishiv7.helloenglish.QuestionSource.When;
import com.shiviishiv7.helloenglish.QuestionSource.Where;
import com.shiviishiv7.helloenglish.QuestionSource.Which;
import com.shiviishiv7.helloenglish.QuestionSource.Who;
import com.shiviishiv7.helloenglish.QuestionSource.Whom;
import com.shiviishiv7.helloenglish.QuestionSource.Whose;

import java.util.Map;

public class QuestionData {
    static Map<String,String> getData(int state){
        int question = QuestionList.QuestionState;
        switch (question){
            case 1:return What.What(state);
            case 3:return How.How(state);
            case 4:return Where.Where(state);
            case 6:return Whom.Whom(state);
            case 2:return When.When(state);
            case 5:return Who.Who(state);
            case 7:return Whose.Whose(state);
            case 8:return Which.Which(state);
//            list.add("What");
//            list.add("When");
//            list.add("How");
//            list.add("Where");
//            list.add("Who");
//            list.add("Whom");
//            list.add("Whose");
//            list.add("Which");


            default:return What.What(state);
        }

    }

}
