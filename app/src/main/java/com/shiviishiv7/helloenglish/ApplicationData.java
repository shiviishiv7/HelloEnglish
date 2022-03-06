package com.shiviishiv7.helloenglish;

import com.shiviishiv7.helloenglish.QuestionSource.AnswerNegativeData;
import com.shiviishiv7.helloenglish.QuestionSource.NegativeQuestion;
import com.shiviishiv7.helloenglish.QuestionSource.QuestionType2;

import java.util.Map;

public class ApplicationData {


        static Map<String,String> getData(int state, int section){
            switch (section){
                case 1: return AnswerData.getData(state);
                case 2:return AnswerNegativeData.getData(state);
                case 3:return QuestionData.getData(state);
                case 4:return NegativeQuestion.getData(state);

                case 5:return QuestionType2.getData(state);
                default:return AnswerData.getData(state);
            }
        }



}
