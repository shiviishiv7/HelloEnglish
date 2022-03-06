package com.shiviishiv7.helloenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static int section = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        case 1: return AnswerData.getData(state);
//        case 2:return AnswerNegativeData.getData(state);
//        case 3:return QuestionData.getData(state);
//        case 4:return NegativeQuestion.getData(state);
//
//        case 5:return QuestionType2.getData(state);
//        default:return AnswerData.getData(state);
    }
    public void button1(View view){ //answer
//        Toast.makeText(view.getContext(),"t1",Toast.LENGTH_SHORT).show();
        section = 1;
        startActivity(new Intent(view.getContext(),RecycleViewShowData.class));

    }
    public void button2(View view){ //question
 //       Toast.makeText(view.getContext(),"t1",Toast.LENGTH_SHORT).show();
        section = 3;
        startActivity(new Intent(view.getContext(),QuestionList.class));

    }
    public void button3(View view){ //-ve answer
        section = 2;
        startActivity(new Intent(view.getContext(),RecycleViewShowData.class));
    }
    public void button4(View view){ //-ve question
        section = 4;
        startActivity(new Intent(view.getContext(),RecycleViewShowData.class));
    }
    public void button5(View view){ //question type 2
        section =5;
        startActivity(new Intent(view.getContext(),RecycleViewShowData.class));

    }
    public void button6(View view){
        startActivity(new Intent(view.getContext(),WordMeaning.class));
    }
}